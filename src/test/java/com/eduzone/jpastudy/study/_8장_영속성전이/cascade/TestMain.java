package com.eduzone.jpastudy.study._8장_영속성전이.cascade;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study._8장_영속성전이.cascade")
@Rollback(value = false)
public class TestMain {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    void test1() {
        Parent parent = new Parent();
        parent.setName("Parent");

        Child child = new Child();
        child.setParent(parent);
        child.setName("Child");

        em.persist(parent);
        em.persist(child);
    }

    @Test
    @Transactional
    void test2() {
        Parent parent = new Parent();
        parent.setName("Parent");

        Child child = new Child();
        child.setName("Child");

        parent.addChild(child);

        em.persist(parent);
    }

    @Test
    @Transactional
    void test3() {
        Parent parent = new Parent();
        parent.setName("Parent");

        Child child = new Child();
        child.setName("Child");

        parent.addChild(child);

        em.persist(parent);

        em.flush();
        em.clear();

        Parent findParent = em.find(Parent.class, 1L);
        em.remove(findParent);
    }

    @Test
    @Transactional
    void test4() {
        Parent parent = new Parent();
        parent.setName("Parent");

        Child child = new Child();
        child.setName("Child");

        parent.addChild(child);

        em.persist(parent);

        em.flush();
        em.clear();

        Parent findParent = em.find(Parent.class, 1L);
        Child findChild = em.find(Child.class, 1L);
        findParent.deleteChild(findChild);
    }
}
