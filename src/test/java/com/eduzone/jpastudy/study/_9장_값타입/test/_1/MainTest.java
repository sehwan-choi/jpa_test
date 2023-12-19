package com.eduzone.jpastudy.study._9장_값타입.test._1;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study._9장_값타입.test._1")
@Rollback(value = false)
public class MainTest {

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    void test1() {
        User user1 = User.createUser("a", 1, "guro", "1bun", "12345");
        Address address = user1.getAddress();
        User user2 = User.createUser("b", 2);
        user2.setAddress(address);

        em.persist(user1);
        em.persist(user2);

        em.flush();
        em.clear();

        User findUser1 = em.find(User.class, 1L);
        User findUser2 = em.find(User.class, 2L);

        findUser1.getAddress().setStreet("zzzzzzz");
        findUser1.getAddress().setZipCode("99999");

        System.out.println("findUser1 = " + findUser1);
        System.out.println("findUser2 = " + findUser2);
    }

    @Test
    @Transactional
    void test2() {
        Address address = new Address("guro", "1bun", "12345");

        User user1 = User.createUser("a", 1);
        user1.setAddress(address);
        User user2 = User.createUser("b", 2);
        user2.setAddress(address);

        address.setZipCode("9999");

        em.persist(user1);
        em.persist(user2);

        em.flush();
        em.clear();

        User findUser1 = em.find(User.class, 1L);
        User findUser2 = em.find(User.class, 2L);

        System.out.println("findUser1 = " + findUser1);
        System.out.println("findUser2 = " + findUser2);
    }

    @Test
    void valueCopy() {
        HashMap<String, String> map = new HashMap<>();
        map.put("1","14134");
        System.out.println("valueCopy::map = " + map.hashCode());

        qq(map);
        System.out.println("valueCopy::map = " + map.hashCode());
    }

    void qq(Map map) {
        System.out.println("test::map.hashCode() = " + map.hashCode());
        map = new LinkedHashMap<String, String>();
        map.put("999","9997899");
        System.out.println("test::map.hashCode() = " + map.hashCode());
    }

    @Test
    void valueCopy2() {
        HashMap<String, String> map = new HashMap<>();
        map.put("1","14134");
        System.out.println("valueCopy::map = " + map.hashCode());

        qq2(map);
        System.out.println("valueCopy::map = " + map.hashCode());
        System.out.println("map = " + map);
    }

    void qq2(Map map) {
        map.put("999","9997899");
    }
}