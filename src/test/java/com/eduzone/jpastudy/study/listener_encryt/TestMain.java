package com.eduzone.jpastudy.study.listener_encryt;

import com.eduzone.jpastudy.Timer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study.listener_encryt")
@Rollback(value = false)
public class TestMain {

    @Autowired
    UserRepository repository;

    @Autowired
    TestService service;
    @Test
    void test() {
        User user = new User("user", 10, "010-1234-5678", "seoul");
        repository.save(user);
    }

    @Test
    void init() {
        service.init();
    }

    @Test
    void get() {
        service.printAll();
    }
}
