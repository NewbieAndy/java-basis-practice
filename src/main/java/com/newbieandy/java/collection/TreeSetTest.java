package com.newbieandy.java.collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {
        Set<User> set = new TreeSet<>(Comparator.comparingInt(o -> o.id));
        User user1 = new User(12, "amy", Gender.FEMALE);
        User user2 = new User(13, "lucy", Gender.FEMALE);
        User user3 = new User(1, "andy", Gender.MALE);
        set.add(user1);
        set.add(user2);
        set.add(user3);
        System.out.println(set);
    }


    @Getter
    @Setter
    @AllArgsConstructor
    static class User {
        private int id;
        private String name;
        private Gender gender;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            boolean b = id == user.id &&
                    gender.equals(user.gender);
            return b;
        }

    }

    enum Gender {
        MALE,
        FEMALE
    }
}
