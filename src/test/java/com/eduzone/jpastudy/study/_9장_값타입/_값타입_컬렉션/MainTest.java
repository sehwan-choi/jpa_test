package com.eduzone.jpastudy.study._9장_값타입._값타입_컬렉션;

import com.eduzone.jpastudy.study._9장_값타입._값타입_공유._수정후.Address;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study._9장_값타입._값타입_컬렉션")
@Rollback(value = false)
public class MainTest {

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    void test1() {

        User user = new User("name", 1);
        user.addFood("치킨");
        user.addFood("피자");
        user.addFood("족발");
        user.addFood("보쌈");
        user.addFood("마라탕");
        user.addFood("삼겹살");
        user.addFood("소고기");

        em.persist(user);
    }

    @Test
    @Transactional
    void test2() {

        User user = new User("name", 1);
        user.addFood("치킨");
        user.addFood("피자");
        user.addFood("족발");
        user.addFood("보쌈");
        user.addFood("마라탕");
        user.addFood("삼겹살");
        user.addFood("소고기");

        em.persist(user);

        em.flush();
        em.clear();

        User findUser = em.find(User.class, 1L);

        // 해당 시점에
        //delete
        //    from
        //        favorite_foods
        //    where
        //        memmber_id=?
        // 쿼리가 발생하여 해당 멤버 ID로 저장된 데이터를 모두 지우고 다시 모든 데이터를 Insert한다
        findUser.addFood("떡볶이");

    }
}