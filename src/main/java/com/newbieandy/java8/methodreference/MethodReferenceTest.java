package com.newbieandy.java8.methodreference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 方法引用测试
 */
public class MethodReferenceTest {
    public static void main(String[] args) {
        List<Car> list = new ArrayList<>();

        //lambda方式
        Car audi = Car.create("audi", (name) -> {
            return new Car(name);
        });
        list.add(audi);
        //构造方法引用
        Car benz = Car.create("benz", Car::new);
        list.add(benz);
        System.out.println(list);

        //lambda方式
        list.forEach(car -> Car.collide(car));
        //静态方法引用
        list.forEach(Car::collide);

        //lambda方式
        list.forEach(car -> car.repair());
        //对象方法引用
        list.forEach(Car::repair);

        Car patrol = Car.create("patrol", Car::new);
        //lambda方式
        list.forEach(car -> patrol.follow(car));
        //对象方法引用
        list.forEach(patrol::follow);
    }
}

class Car {
    private String name;

    Car(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }

    public static Car create(String name, final Function<String, Car> function) {
        return function.apply(name);
    }

    public static void collide(final Car car) {
        System.out.println("Collide " + car.toString());
    }

    public void follow(final Car anotherCar) {
        System.out.println("Follow the " + anotherCar.toString());
    }

    public void repair() {
        System.out.println("Repair " + this.toString());
    }
}
