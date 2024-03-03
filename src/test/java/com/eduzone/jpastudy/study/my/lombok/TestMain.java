package com.eduzone.jpastudy.study.my.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study.my.lombok")
public class TestMain {

    @Test
    void test() {
        MyObject build = MyObject.builder().name("aa").build();
        System.out.println("build = " + build);
    }
}
