package com.eduzone.jpastudy.study._9장_값타입._값타입_공유._수정후;

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

        User user1 = User.createUser("a", 1,"guro", "1bun", "12345");
        Address address = user1.getAddress();

        user1.setAddress("seoul", "2bun", "54163");
        Address address2 = user1.getAddress();

        Address newAddress = new Address("mola", "zzz", "432592");
        user1.setAddress(newAddress);
        Address address3 = user1.getAddress();

        System.out.println("address = " + address);
        System.out.println("address2 = " + address2);
        System.out.println("address3 = " + address3);

        em.persist(user1);

        em.flush();
        em.clear();
    }
}