package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._컬렉션._orderColumn;

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
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._컬렉션.set")
@Rollback(value = false)
public class TestMain {

    @Autowired
    EntityManager em;

    @BeforeEach
    @Transactional
    void beforeEach() {
        Parent parent = new Parent("mom");
        for (int i = 0 ; i < 10 ; i ++) {
            Child child = new Child("child_" + (i + 1));
            parent.add(child);
            em.persist(child);
        }
        em.persist(parent);
        em.flush();
        em.clear();
    }

    @Test
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void test() {
        Parent parent = em.find(Parent.class, 1L);

        Child remove = parent.getChildren().remove(5);
        em.remove(remove);
        em.flush();
        em.clear();

        System.out.println("parent = " + parent);
    }
}
