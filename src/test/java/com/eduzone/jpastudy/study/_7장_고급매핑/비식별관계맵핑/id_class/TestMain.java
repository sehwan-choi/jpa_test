package com.eduzone.jpastudy.study._7장_고급매핑.비식별관계맵핑.id_class;

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
        Parent parent = new Parent();
        parent.setId1("1");
        parent.setId2("2");
        parent.setName("choi");
        parent.setAge(29);

        em.persist(parent);

        Child child = new Child();
        child.setId("1");
        child.setParent(parent);

        em.persist(child);

        Parent parent2 = new Parent();
        parent2.setId1("11");
        parent2.setId2("22");
        parent2.setName("lee");
        parent2.setAge(40);

        em.persist(parent2);

        Child child2 = new Child();
        child2.setId("2");
        child2.setParent(parent2);

        em.persist(child2);

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
