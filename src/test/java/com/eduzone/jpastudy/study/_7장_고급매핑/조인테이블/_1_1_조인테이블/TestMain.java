package com.eduzone.jpastudy.study._7장_고급매핑.조인테이블._1_1_조인테이블;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study._7장_고급매핑.조인테이블._1_1_조인테이블")
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

        Parent parent = new Parent();
        parent.setName("parent");
        parent.setId(2L);
        parent.setChild(child);

        em.persist(child);
        em.persist(parent);


        Child child2 = new Child();
        child2.setId(2L);
        child2.setName("child2");

        Parent parent2 = new Parent();
        parent2.setName("parent2");
        parent2.setId(3L);

        em.persist(child2);
        em.persist(parent2);

        em.flush();
        em.clear();
    }

    @Test
    @Transactional
    void test() {
        Child child = em.find(Child.class, 1L);
        Parent parent = em.find(Parent.class, 2L);
        System.out.println("parent = " + parent);
        System.out.println("child = " + child);
    }

    @Test
    @Transactional
    @DisplayName("child는 slave기 때문에 setParent를 해도 데이터가 들어가지 않는다")
    void test2() {
        Child child = new Child();
        child.setId(999L);
        child.setName("child999");

        Parent parent = new Parent();
        parent.setName("parent999");
        parent.setId(999L);
        child.setParent(parent);

        em.persist(child);
        em.persist(parent);

        em.flush();
        em.clear();

        Parent parent1 = em.find(Parent.class, 999L);
        System.out.println("parent1.getChild() = " + parent1.getChild());
    }
}
