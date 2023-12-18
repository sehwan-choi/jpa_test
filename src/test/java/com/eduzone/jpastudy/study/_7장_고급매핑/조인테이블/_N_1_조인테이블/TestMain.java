package com.eduzone.jpastudy.study._7장_고급매핑.조인테이블._N_1_조인테이블;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study._7장_고급매핑.조인테이블._N_1_조인테이블")
@Rollback(value = false)
public class TestMain {

    @Autowired
    EntityManager em;

    @BeforeEach
    @Transactional
    void beforeEach() {
        Child child = new Child();
        child.setId(1L);
        child.setName("child");

        Child child2 = new Child();
        child2.setId(2L);
        child2.setName("child2");


        Parent parent = new Parent();
        parent.setName("parent");
        parent.setId(1L);
//        parent.setChild(List.of(child, child2));  //  안됌 parent가 slave기 때문

        Parent parent2 = new Parent();
        parent2.setName("parent2");
        parent2.setId(2L);

        child.setParent(parent);
        child2.setParent(parent2);

        em.persist(child);
        em.persist(parent);
        em.persist(child2);
        em.persist(parent2);

        em.flush();
        em.clear();
    }

    @Test
    @Transactional
    void test() {
        Child child = em.find(Child.class, 1L);
        Child child2 = em.find(Child.class, 2L);
        Parent parent = em.find(Parent.class, 1L);
        Parent parent2 = em.find(Parent.class, 2L);
        System.out.println("parent = " + parent);
        System.out.println("parent2 = " + parent2);
        System.out.println("child = " + child);
        System.out.println("child2 = " + child2);
    }
}
