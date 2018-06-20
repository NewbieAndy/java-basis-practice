package com.newbieandy.java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 流中间操作测试
 */
public class StreamIntermediateTest {
    public static void main(String[] args) {
        List<User> users = getTestData();
        System.out.println(users);
        //获取性别为1的
        Stream<User> stream = users.stream().filter(user -> user.getGender() == 1);
        Stream<User> distinct = stream.distinct();
        Stream<String> stringStream = users.stream().map(User::getName);
        //转成name序列
        List<String> nameList = users.stream().map(User::getName).collect(Collectors.toList());
        System.out.println("nameList:" + nameList);
        Stream<User> userStream = users.stream().sorted(Comparator.comparingInt(User::getAge));
        Stream<User> limit = userStream.limit(2);
        Stream<User> skip = userStream.skip(2);
        //根据age排序
        List<User> sorted = users.stream().sorted(Comparator.comparingInt(User::getAge)).collect(Collectors.toList());
        System.out.println("sorted:" + sorted);
        //转成id-userMap
        Map<Integer, User> collect = users.stream().collect(Collectors.toMap(User::getId, o -> o));
        System.out.println("map:" + collect);
        System.out.println("===========stream 的创建=======");

    }


    /**
     * 获取测试数据
     *
     * @return
     */
    private static List<User> getTestData() {
        List<User> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i + 1);
            user.setAge(random.nextInt(100));
            user.setName("张三" + i + 1);
            user.setGender(user.getAge() % 2 == 0 ? 1 : 0);
            list.add(user);
        }
        return list;
    }
}
