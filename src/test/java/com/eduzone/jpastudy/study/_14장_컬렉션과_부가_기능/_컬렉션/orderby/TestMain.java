package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._컬렉션.orderby;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._컬렉션.orderby")
@Rollback(value = false)
public class TestMain {

    @Autowired
    EntityManager em;

    @BeforeEach
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void init() {
        Parent parent = new Parent("parent");
        for (int i = 0 ; i < 10 ; i++) {
            parent.add(new Child("name_" + i));
        }
        em.persist(parent);
        em.flush();
        em.clear();
    }

    @Test
    @Transactional
    void orderBy() {
        Parent parent = em.find(Parent.class, 1L);

        parent.getCollection().forEach(x -> System.out.println("x = " + x));
    }
}
