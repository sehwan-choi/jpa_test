package com.eduzone.study.data_structure.set;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class TestMain {

    @Test
    void noDuplicateAdd() {
        HashSet<TestObject> set = new HashSet<>();
        set.add(new TestObject("1", 10));
        set.add(new TestObject("2", 20));
        set.add(new TestObject("3", 30));

        System.out.println("set = " + set);
    }

    @Test
    void duplicateAdd() {
        HashSet<TestObject> set = new HashSet<>();
        set.add(new TestObject("1", 10));
        set.add(new TestObject("1", 10));
        set.add(new TestObject("1", 10));

        System.out.println("set = " + set);
    }

    @Test
    void nullAdd() {
        HashSet<TestObject> set = new HashSet<>();

        set.add(null);

        System.out.println("set = " + set);
    }
}
