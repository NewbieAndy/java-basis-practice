package com.newbieandy.trywithresource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by mchao on 2016/10/12.
 */
public class Demo1 {
    /*
     *  通常java在打开流,文件,等系统资源时,最后都需要手动在finally语句块进行关闭,代码繁琐麻烦.
     *  现在通过使用try-with-resource  语法糖,程序员无需手动关闭资源,系统将自动关闭.但其前提是资源需要直接或者间接
     *  实现AutoCloseable 接口
     *
     *  try-catch-finally时用法:
     *  ...声明资源引用
     *  try{
     *      实例化资源对象
     *      ...业务逻辑
     *  } catch(Exception e){
     *      ...处理异常
     *  } finally{
     *      各种判断,手动关闭资源
     *  }
     *
     *  try-with-resource时用法:
     *  PS:资源对象需要实现AutoCloseable接口
     *
     *  try(声明,实例化资源对象){
     *      ....使用资源对象进行业务逻辑开发
     *  } catch (Excetpion e){
     *      处理异常
     *  }
     */

    public static void main(String[] args) {
        //获取文件路径
        String path = System.getProperty("user.dir");
        path = path + "\\src\\main\\resources\\trywithresource\\test.txt";
        tryCatchFinallyTest(path);
        tryWithResourceTest(path);
        newTryWithResourceTest();
    }

    /**
     * 远古方式读取指定文件第一行文本
     *
     * @param path 文件路径
     */
    private static void tryCatchFinallyTest(String path) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            System.out.println("原始方式调用:" + bufferedReader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //手动关闭..
            if (null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * try-with-resource方式调用
     *
     * @param path 文件路径
     */
    private static void tryWithResourceTest(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            System.out.println("新方式调用:" + bufferedReader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 自定义,资源类测试
     */
    private static void newTryWithResourceTest() {
        try (ResourceDemo1 resourceDemo1 = new ResourceDemo1();
             ResourceDemo2 resourceDemo2 = new ResourceDemo2()) {
            resourceDemo1.resourceDemo1Test();
            resourceDemo2.resourceDemo2Test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ResourceDemo1 implements AutoCloseable {

    public void resourceDemo1Test() {
        System.out.println("ResourceDemo1 running....");
    }

    @Override
    public void close() throws Exception {
        System.out.println("ResourceDemo1 closed.....");
    }
}

class ResourceDemo2 implements AutoCloseable {

    public void resourceDemo2Test() {
        System.out.println("ResourceDemo2 running...");
    }

    @Override
    public void close() throws Exception {
        System.out.println("ResourceDemo2 closed....");
    }
}