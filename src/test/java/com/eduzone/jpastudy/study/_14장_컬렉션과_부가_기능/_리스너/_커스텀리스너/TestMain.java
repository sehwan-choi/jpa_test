package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._리스너._커스텀리스너;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._리스너._커스텀리스너")
@Rollback(value = false)
public class TestMain {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    void test() {
        Parent choi = new Parent("choi");
        choi.addChild(new Child("kim"));
        em.persist(choi);

        em.flush();
        em.clear();

        Parent parent = em.find(Parent.class, 1L);
        System.out.println("parent = " + parent);

        System.out.println("parent.getChildList().get(0) = " + parent.getChildList().get(0));
    }

    @Test
    @Transactional
    void test2() {
        Parent choi = new Parent("choi");
        choi.addChild(new Child("kim"));
        em.persist(choi);

        em.flush();
        em.clear();

        Parent parent = em.find(Parent.class, 1L);
        System.out.println("parent = " + parent);

        parent.setName("kkkk");

        em.flush();
        em.clear();
    }

    @Test
    @Transactional
    void test3() {
        Parent choi = new Parent("choi");
        choi.addChild(new Child("kim"));
        em.persist(choi);

        em.flush();
        em.clear();

        Parent parent = em.find(Parent.class, 1L);
        Child child = em.find(Child.class, 1L);
        System.out.println("parent = " + parent);

        parent.deleteChild(child);

        em.flush();
        em.clear();

        Parent parent2 = em.find(Parent.class, 1L);
        em.remove(parent2);
    }
}
