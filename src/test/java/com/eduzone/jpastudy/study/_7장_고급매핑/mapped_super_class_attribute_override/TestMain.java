package com.eduzone.jpastudy.study._7장_고급매핑.mapped_super_class_attribute_override;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@SpringBootApplication(scanBasePackages = {"com.eduzone.jpastudy.study._7장_고급매핑.mapped_super_class_attribute_override"})
@Rollback(value = false)
public class TestMain {

    @Autowired
    EntityManager em;

    @BeforeEach
    @Transactional
    void beforeEach() {
        Member member = new Member();
        member.setId(1L);
        member.setName("aaa");
        member.setCreatedAt(LocalDateTime.now());
        member.setEmail("memberEmail");

        Seller seller = new Seller();
        seller.setId(1L);
        seller.setName("bbb");
        seller.setCreatedAt(LocalDateTime.now());
        seller.setShopName("shopName");

        em.persist(member);

        em.persist(seller);

        em.flush();
        em.clear();
    }

    @Test
    @Transactional
    void test() {
        Member member = em.find(Member.class, 1L);
        Seller seller = em.find(Seller.class, 1L);

        System.out.println("member = " + member);
        System.out.println("seller = " + seller);
    }
}
