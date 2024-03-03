package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._컬렉션.map;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._컬렉션.map")
@Rollback(value = false)
public class TestMain {

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    void test() {
        Parent choi = new Parent("choi");
        Child kim = new Child("kim");
        choi.add(kim.getId(),kim);
        em.persist(choi);
        em.flush();
        em.clear();

        Parent parent = em.find(Parent.class, 1L);
        System.out.println("parent = " + parent);
        System.out.println(parent.getMaps().getClass()+"");
    }
}
