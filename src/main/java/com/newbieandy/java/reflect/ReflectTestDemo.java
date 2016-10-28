package com.newbieandy.java.reflect;

import com.newbieandy.java.reflect.bean.MiddleStudent;
import com.newbieandy.java.reflect.bean.Person;
import com.newbieandy.java.reflect.bean.Student;

import java.lang.reflect.Field;

/**
 * Created by mchao on 2016/10/27.
 */
public class ReflectTestDemo {
    public static void main(String[] args) throws IllegalAccessException {
        MiddleStudent person = new MiddleStudent();
        person.setName("andy");
        person.setAge(22);
        person.setGender(1);
        person.setGrade(4);
        person.setClasses(2);
        person.setSubject("wen");
        test2(person);
    }

    private static void test1() {
        Person person = new Person();
        person.setName("andy");
        person.setAge(22);
        person.setGender(1);

        Student student = new Student();
        student.setName("Tom");
        student.setAge(20);
        student.setGender(0);
        student.setGrade(5);
        student.setClasses(3);

        Field[] fields = person.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("person field:" + field.getName());

            try {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                Class<?> type = field.getType();
                String simpleName = type.getSimpleName();
                System.out.println("typeName:" + simpleName);
                Object o = field.get(person);
                System.out.println(o);
                field.setAccessible(false);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        System.out.println("################################");
        String name = person.getClass().getSuperclass().getName();
        System.out.println(name);
        System.out.println(person.getClass().getSuperclass().equals(Object.class));
        System.out.println("################################");
        Field[] fields1 = student.getClass().getDeclaredFields();
        for (Field field : fields1) {
            System.out.println("student field:" + field.getName());
        }
        System.out.println("################################");

        Field[] fields2 = student.getClass().getSuperclass().getDeclaredFields();
        for (Field field : fields2) {
            System.out.println("student supper calss field:" + field.getName());
        }


    }

    /**
     * 获取除了serID以及Obj所有属性的值
     */
    private static <T> void test2(T t) throws IllegalAccessException {
        //获取当前类
        Class<?> clazz = t.getClass();
        while (!Object.class.equals(clazz)) {
            getFields(clazz, t);
            clazz = clazz.getSuperclass();
        }
    }

    private static void getFields(Class clazz, Object obj) throws IllegalAccessException {
        //获取当前类的属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("serialVersionUID")) {
                continue;
            }
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            System.out.println(field.getName() + "::" + field.get(obj).toString());
            field.setAccessible(false);
        }
    }

}
