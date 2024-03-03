package com.eduzone.jpastudy.study._8장_영속성전이.many_to_one_cascade_all;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study._8장_영속성전이.many_to_one_cascade_all")
@Rollback(value = false)
public class TestMain {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    void test() {
        Child choi = new Child("choi");
        Parent kim = new Parent("kim");

        choi.setParent(kim);

        em.persist(choi);

        em.flush();
        em.clear();

        Parent parent = em.find(Parent.class, 1L);
        System.out.println("parent = " + parent);
    }

    @Test
    @Transactional
    void test2() {
        Child choi = new Child("choi");
        Child choi2 = new Child("choi2");
        Parent kim = new Parent("kim");

        choi.setParent(kim);
        choi2.setParent(kim);

        em.persist(choi);
        em.persist(choi2);

        em.flush();
        em.clear();

        Child child = em.find(Child.class, 1L);
        System.out.println("child = " + child);

        em.remove(child);
    }
}
