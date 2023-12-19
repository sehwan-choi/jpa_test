package com.eduzone.jpastudy.study._8장_영속성전이.orphan_removal;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study._8장_영속성전이.orphan_removal")
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
        child.setName("Child");

        parent.addChild(child);

        em.persist(parent);

        em.flush();
        em.clear();

        Parent findParent = em.find(Parent.class, 1L);
        Child findChild = em.find(Child.class, 1L);
        findParent.deleteChild(findChild);
    }

    @Test
    @Transactional
    void test2() {
        Parent parent = new Parent();
        parent.setName("Parent");

        Child child = new Child();
        child.setName("Child");

        Child child2 = new Child();
        child2.setName("Child2");

        Child child3 = new Child();
        child3.setName("Child3");

        Child child4 = new Child();
        child4.setName("Child4");

        parent.addChild(child);
        parent.addChild(child2);
        parent.addChild(child3);
        parent.addChild(child4);

        em.persist(parent);

        em.flush();
        em.clear();

        Parent findParent = em.find(Parent.class, 1L);
        findParent.clearChildList();
    }

    @Test
    @Transactional
    void test3() {
        Parent parent = new Parent();
        parent.setName("Parent");

        Child child = new Child();
        child.setName("Child");

        Child child2 = new Child();
        child2.setName("Child2");

        Child child3 = new Child();
        child3.setName("Child3");

        Child child4 = new Child();
        child4.setName("Child4");

        parent.addChild(child);
        parent.addChild(child2);
        parent.addChild(child3);
        parent.addChild(child4);

        em.persist(parent);

        em.flush();
        em.clear();

        Parent findParent = em.find(Parent.class, 1L);
        findParent.deleteChild(child2);
        findParent.deleteChild(child4);
    }
}
