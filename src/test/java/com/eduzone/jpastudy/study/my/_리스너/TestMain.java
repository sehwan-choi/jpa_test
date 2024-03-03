package com.eduzone.jpastudy.study.my._리스너;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study.my._리스너")
@Rollback(value = false)
public class TestMain {

    @Autowired
    TestService testService;
    @Test
    void test() {
        Long user = testService.createUser();
        testService.printUser(user);
        System.out.println("test()");
    }

    @Test
    void test2() {
        Long user = testService.createUser();
        testService.updateUser(user);
        System.out.println("test()");
    }

    @Test
    void test3() {
        Long user = testService.createUser();
        testService.deleteUser(user);
        System.out.println("test()");
    }

    @Test
    void test4() {
        Long user = testService.createUserAndChild(3);
        testService.deleteChild(user);
        System.out.println("test()");
    }
}
