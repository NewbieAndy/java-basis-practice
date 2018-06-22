package com.newbieandy.java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 流中间操作测试
 */
public class StreamIntermediateTest {
    public static void main(String[] args) {
//        reduceTest();
//        IntFunction f = (x) -> x + "";
//        Object apply = f.apply(9);
//        System.out.println(apply);
        toArrayTest();
    }

    private static void toCollectTest() {
        List<User> users = getTestData();
        Stream<User> stream = users.stream();
        //转成列表
        List<User> collect = stream.collect(Collectors.toList());
        //转成map->key:id  value:obj
        Map<Integer, User> map = stream.collect(Collectors.toMap(User::getId, o -> o));


    }

    private static void toArrayTest() {
        //转成int数组
        Stream<Integer> intStream = Arrays.asList(1, 2, 43, 5).stream();
        Integer[] integers = intStream.toArray(Integer[]::new);
        System.out.println(integers.toString());
    }

    private static void reduceTest() {
        List<User> users = getTestData();
        Stream<User> stream = users.stream();
        //reduce-->获取年龄最大的用户
        Optional<User> user = stream.reduce((u, item) -> u.getAge() > item.getAge() ? u : item);
        if (user.isPresent()) System.out.println(user.get());

        //reduce-->获取集合与基础值的和
        Stream<Integer> intStream = Arrays.asList(1, 2, 43, 5).stream();
        Integer reduce = intStream.reduce(2, (i, item) -> i + item);
        System.out.println(reduce);

    }

    private static void test() {
        List<User> users = getTestData();
        System.out.println(users);
        //获取性别为1的
        List<User> users1 = users.stream().filter(user -> user.getGender() == 1).collect(Collectors.toList());
        System.out.println("gender=1:" + users1);
        //转成name序列
        List<String> nameList = users.stream().map(User::getName).collect(Collectors.toList());
        System.out.println("nameList:" + nameList);
        //根据age排序
        List<User> sorted = users.stream().sorted(Comparator.comparingInt(User::getAge)).collect(Collectors.toList());
        System.out.println("sorted:" + sorted);
        //转成id-userMap
        Map<Integer, User> collect = users.stream().collect(Collectors.toMap(User::getId, o -> o));
        System.out.println("map:" + collect);

        System.out.println("=================flatMap=============");
        List<List<String>> pList = new ArrayList<>();
        List<String> list1 = Arrays.asList("andy", "tom", "amy");
        List<String> list2 = Arrays.asList("张三", "李四", "王五");
        pList.add(list1);
        pList.add(list2);
        Stream<String> stream = pList.stream().flatMap((x) -> x.stream());

        Stream<String> stringStream = stream.peek(System.out::println);
        stringStream.collect(Collectors.toList());
//        stream.forEach(System.out::println);
        System.out.println("========终止操作======");
        List<String> list = Arrays.asList("andy", "tom", "amy");
        Stream<String> finalStringStream = list.stream();
        //forEach-遍历
        finalStringStream.forEach(s -> System.out.println(s));
        Stream<Integer> minStream = Arrays.asList(1, 2, 43, 5).stream();
        //最小值
        Optional<Integer> min = minStream.min(Comparator.naturalOrder());
        if (min.isPresent()) System.out.println("min:" + min.get());

        Stream<Integer> maxStream = Arrays.asList(1, 2, 43, 5).stream();
        //最大值
        Optional<Integer> max = maxStream.max((o1, o2) -> o1.compareTo(o2));
        if (max.isPresent()) System.out.println("max:" + max.get());

        Stream<Integer> countStream = Arrays.asList(1, 2, 43, 5).stream();
        //统计个数
        long count = countStream.count();
        System.out.println("count:" + count);

        //取和-只有数值型Stream有此方法
        IntStream intStream = Arrays.asList(1, 2, 43, 5).stream().mapToInt(Integer::intValue);
        int sum = intStream.sum();
        System.out.println("sum:" + sum);
//        OptionalDouble average = intStream.average();
//        if (average.isPresent()) System.out.println("avg:"+average.getAsDouble());

//        判断是否所有流内元素都匹配-长度大于1
        //判断流内是否有元素匹配的-长度大于1
        //判断流内是否没有元素匹配的-长度大于10
        //取流内第一个元素
        Stream<String> valueStream = Arrays.asList("a", "b", "andy", "23", "cc").stream();
        Optional<String> any = valueStream.findAny();
        if (any.isPresent()) System.out.println("any:" + any.get());
//        boolean b = valueStream.noneMatch(s->s.length()>10);
//        boolean b = valueStream.allMatch(s->s.length()>1);
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
