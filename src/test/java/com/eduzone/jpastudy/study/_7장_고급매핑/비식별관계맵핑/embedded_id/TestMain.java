package com.eduzone.jpastudy.study._7장_고급매핑.비식별관계맵핑.embedded_id;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@SpringBootApplication(scanBasePackages = {"com.eduzone.jpastudy.study._7장_고급매핑.비식별관계맵핑.id_class"})
@Rollback(value = false)
public class TestMain {

    @Autowired
    EntityManager em;

    @BeforeEach
    @Transactional
    void beforeEach() {
        ParentId parentId = new ParentId("1", "2");
        Parent parent = new Parent();
        parent.setId(parentId);
        parent.setName("choi");
        parent.setAge(29);

        em.persist(parent);

        Child child = new Child();
        child.setId("1");
        child.setParent(parent);

        em.persist(child);

        em.flush();
        em.clear();
    }

    @Test
    @Transactional
    void test() {

        ParentId parentId = new ParentId("1", "2");
        Parent parent = em.find(Parent.class, parentId);
        System.out.println("parent = " + parent);
    }

    @Test
    @Transactional
    void test2() {

        Child child = em.find(Child.class, "1");
        System.out.println("child = " + child);
    }
}
