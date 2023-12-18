package com.eduzone.jpastudy.study._7장_고급매핑.식별관계맵핑.embedded_id.id_class;

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
        parent.setName("choi");
        parent.setAge(29);

        em.persist(parent);

        Child child = new Child();
        child.setParent(parent);
        child.setChildId("11");

        em.persist(child);

        GrandChild grandChild = new GrandChild();
        grandChild.setChild(child);
        grandChild.setGrandChildId("111");

        em.persist(grandChild);

        em.flush();
        em.clear();
    }

    @Test
    @Transactional
    void test() {

        ChildId childId = new ChildId("1", "11");
        Child child = em.find(Child.class, childId);
        System.out.println("child = " + child);
    }
}
