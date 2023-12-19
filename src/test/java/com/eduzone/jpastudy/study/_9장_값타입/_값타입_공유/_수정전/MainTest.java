package com.eduzone.jpastudy.study._9장_값타입._값타입_공유._수정전;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study._9장_값타입._값타입_공유._수정전")
@Rollback(value = false)
public class MainTest {

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    void test1() {
        Address address = new Address("guro", "1bun", "12345");

        User user1 = User.createUser("a", 1);
        User user2 = User.createUser("b", 2);

        user1.setAddress(address);   //  Address를 User에 넣는다.
        user2.setAddress(address);   //  Address를 User에 넣는다.

        em.persist(user1);
        em.persist(user2);

        em.flush();
        em.clear();

        User findUser1 = em.find(User.class, 1L);
        User findUser2 = em.find(User.class, 2L);

        findUser1.getAddress().setZipCode("99999"); //  User1의 Address의 zipcode를 9999로 변경한다.

        System.out.println("findUser1 = " + findUser1);
        System.out.println("findUser2 = " + findUser2);
    }

    @Test
    @Transactional
    void test2() {
        Address address = new Address("guro", "1bun", "12345");

        User user1 = User.createUser("a", 1);
        User user2 = User.createUser("b", 2);

        user1.setAddress(address);   //  Address를 User에 넣는다.
        user2.setAddress(address);   //  Address를 User에 넣는다.

        address.setZipCode("9999"); //  Address의 zipcode를 9999로 변경한다.

        em.persist(user1);
        em.persist(user2);

        em.flush();
        em.clear();

        User findUser1 = em.find(User.class, 1L);
        User findUser2 = em.find(User.class, 2L);

        System.out.println("findUser1 = " + findUser1);
        System.out.println("findUser2 = " + findUser2);
    }
}