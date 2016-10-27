package com.newbieandy.java.reflect;

import com.newbieandy.java.reflect.bean.Person;
import com.newbieandy.java.reflect.bean.Student;

import java.lang.reflect.Field;

/**
 * Created by mchao on 2016/10/27.
 */
public class ReflectTestDemo {
    public static void main(String[] args) {
        test1();
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
}
