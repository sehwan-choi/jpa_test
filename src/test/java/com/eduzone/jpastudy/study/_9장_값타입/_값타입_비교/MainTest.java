package com.eduzone.jpastudy.study._9장_값타입._값타입_비교;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study._9장_값타입._값타입_공유._수정후")
@Rollback(value = false)
public class MainTest {

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    void test1() {

        Address user1Address = new Address("인천", "부평구", "부평동");
        User user1 = User.createUser("choi", 1);
        user1.setAddress(user1Address);

        Address user2Address = new Address("인천", "부평구", "부평동");
        User user2 = User.createUser("lee", 1);
        user2.setAddress(user2Address);

        System.out.println("equals = " + user1.getAddress().equals(user2.getAddress()));
        System.out.println("== = " + (user1.getAddress() == user2.getAddress()));
    }
}