package com.eduzone.jpastudy.study.java_is_call_by_value;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainTest {

    @Test
    void valueCopy() {
        HashMap<String, String> map = new HashMap<>();
        map.put("1","14134");

        System.out.println("1 = " + map.hashCode());

        qq(map);

        System.out.println("4 = " + map.hashCode());
    }

    void qq(Map map) {
        System.out.println("2 = " + map.hashCode());

        map = new LinkedHashMap<String, String>();
        map.put("999","9997899");

        System.out.println("3 = " + map.hashCode());
    }

    @Test
    void valueCopy2() {
        HashMap<String, String> map = new HashMap<>();
        map.put("1","14134");

        System.out.println("1 = " + map);

        qq2(map);
        System.out.println("2 = " + map);
    }

    void qq2(Map map) {
        map.put("999","9997899");
    }
}