package com.newbieandy.netty.netty.http.fileserver;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.stream.ChunkedFile;
import io.netty.util.CharsetUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Pattern;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpHeaders.isKeepAlive;
import static io.netty.handler.codec.http.HttpHeaders.setContentLength;

/**
 * @author chao.ma
 * @Date 2019/4/18 17:44
 * @Version 1.0
 */
public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    private final String url;

    public HttpFileServerHandler(String url) {
        this.url = url;
    }


    @Override
    protected void messageReceived(ChannelHandlerContext ctx, FullHttpRequest req) throws Exception {
        if (!req.getDecoderResult().isSuccess()) {
            sendError(ctx, HttpResponseStatus.BAD_REQUEST);
            return;
        }
        if (req.getMethod() != HttpMethod.GET) {
            sendError(ctx, HttpResponseStatus.METHOD_NOT_ALLOWED);
            return;
        }
        final String uri = req.getUri();
        final String path = sanitizedUri(uri);

        if (path == null) {
            sendError(ctx, HttpResponseStatus.FORBIDDEN);
            return;
        }

        File file = new File(path);
        if (file.isHidden() || !file.exists()) {
            sendError(ctx, HttpResponseStatus.NOT_FOUND);
            return;
        }
        if (file.isDirectory()) {
            if (uri.endsWith("/")) {
                sendListing(ctx, file);
            } else {
                sendRedirect(ctx, uri + "/");
            }
            return;
        }
        if (!file.isFile()) {
            sendError(ctx, HttpResponseStatus.FORBIDDEN);
            return;
        }

        RandomAccessFile randomAccessFile = null;
        try {
            //只读模式
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (FileNotFoundException fnfe) {
            sendError(ctx, HttpResponseStatus.NOT_FOUND);
            return;
        }
        long length = randomAccessFile.length();
        HttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
        setContentLength(response, length);
        setcontentTypeHeader(response, file);
        if (isKeepAlive(req)) {
            response.headers().set(CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
        }
        ctx.write(response);
        ChannelFuture sendFileFuture;
        sendFileFuture = ctx.write(new ChunkedFile(randomAccessFile, 0, length, 8192), ctx.newProgressivePromise());
        sendFileFuture.addListener(new ChannelProgressiveFutureListener() {
            @Override
            public void operationProgressed(ChannelProgressiveFuture future, long progress, long total) throws Exception {
                if (total < 0) {
                    System.out.println("Transfer progress:" + progress);
                } else {
                    System.out.println("Transfer progress:" + progress + "/" + total);
                }
            }

            @Override
            public void operationComplete(ChannelProgressiveFuture future) throws Exception {
                System.out.println("Transfer complete");
            }
        });
        ChannelFuture lastContentFuture = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);
        if (!isKeepAlive(req)) {
            lastContentFuture.addListener(ChannelFutureListener.CLOSE);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        if (ctx.channel().isActive()) {
            sendError(ctx, HttpResponseStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static final Pattern INSECURE_URL = Pattern.compile(".*[<>&\"].*");


    //净化 URL
    private String sanitizedUri(String uri) {
        try {
            uri = URLDecoder.decode(uri, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            try {
                uri = URLDecoder.decode(uri, "ISO-8859-1");
            } catch (UnsupportedEncodingException e1) {
                throw new Error();
            }
        }
        if (!uri.startsWith(url)) {
            return null;
        }
        if (!uri.startsWith("/")) {
            return null;
        }

        uri = url.replace('/', File.separatorChar);
        if (uri.contains(File.separator + '.')
                || uri.contains('.' + File.separator)
                || uri.startsWith(".")
                || uri.endsWith(".")
                || INSECURE_URL.matcher(uri).matches()) {
            return null;

        }
        return System.getProperty("user.dir") + File.separator + uri;
    }


    private static final Pattern ALLOWED_FILE_NAME = Pattern.compile("[A-Za-z0-9][-_A-Za-z0-9\\.]*");

    private void sendListing(ChannelHandlerContext ctx, File file) {
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
        response.headers().set(CONTENT_TYPE, "text/html;charset=UTF-8");
        StringBuilder buf = new StringBuilder();
        String dirPath = file.getPath();
        buf.append("<!DOCTYPE html>\r\n")
                .append("<html><head><title>")
                .append(dirPath)
                .append(" 目录:")
                .append("</title></head><body>\r\n")
                .append("<h3>")
                .append(dirPath)
                .append(" 目录: ")
                .append("</h3>\r\n")
                .append("<ul>")
                .append("<li>链接:<a href=\"../\">..</a></li>\r\n");

        for (File f : file.listFiles()) {
            if (f.isHidden() || !f.canRead()) {
                continue;
            }
            String name = f.getName();
            if (!ALLOWED_FILE_NAME.matcher(name).matches()) {
                continue;
            }
            buf.append("<li>链接:<a href=\"")
                    .append(name)
                    .append("\">")
                    .append(name)
                    .append("</a></li>\r\n");
        }
        buf.append("</ul></body></html>\r\n");
        ByteBuf buffer = Unpooled.copiedBuffer(buf, CharsetUtil.UTF_8);
        response.content().writeBytes(buffer);
        buffer.release();
        ctx.writeAndFlush(response)
                .addListener(ChannelFutureListener.CLOSE);
    }

    private void sendRedirect(ChannelHandlerContext ctx, String s) {
        //todo page 176
    }

    private void sendError(ChannelHandlerContext ctx, HttpResponseStatus badRequest) {
    }

    private void setcontentTypeHeader(HttpResponse response, File file) {
    }
}
