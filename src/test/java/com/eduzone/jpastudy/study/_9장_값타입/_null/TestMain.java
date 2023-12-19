package com.eduzone.jpastudy.study._9장_값타입._null;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study._9장_값타입._null")
@Rollback(value = false)
public class TestMain {

    @Autowired
    EntityManager em;

    @Transactional
    @Test
    void test() {
        User user = new User("name", 1);
        user.setAddress(null);

        em.persist(user);

        em.flush();
        em.clear();

        User findUser = em.find(User.class, 1L);

        System.out.println("findUser = " + findUser);
    }

    @Transactional
    @Test
    void test2() {
        User user = new User("name", 1);

        em.persist(user);

        em.flush();
        em.clear();

        User findUser = em.find(User.class, 1L);

        System.out.println("findUser = " + findUser);
    }
}
