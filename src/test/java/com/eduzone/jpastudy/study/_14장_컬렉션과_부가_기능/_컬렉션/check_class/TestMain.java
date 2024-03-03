package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._컬렉션.check_class;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._컬렉션.check_class")
@Rollback(value = false)
public class TestMain {

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    void test() {
        Parent parent = new Parent("parent");
        em.persist(parent);
        em.flush();
        em.clear();

        Parent parent2 = em.find(Parent.class, 1L);

        System.out.println("parent.getCollection() = " + parent2.getCollection().getClass());
        System.out.println("parent.getOrderList() = " + parent2.getOrderList().getClass());
        System.out.println("parent.getList() = " + parent2.getList().getClass());
        System.out.println("parent.getSet() = " + parent2.getSet().getClass());
    }
}
