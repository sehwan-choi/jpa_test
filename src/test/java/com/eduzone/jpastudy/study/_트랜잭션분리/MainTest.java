package com.eduzone.jpastudy.study._트랜잭션분리;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study._트랜잭션분리")
@Rollback(value = false)
public class MainTest {

    @Autowired
    private UserService service;

    @Test
    void test() {
        service.doService();
    }
}