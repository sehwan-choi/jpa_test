package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._리스너.preupdate_logadd;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._리스너.preupdate_logadd")
@Rollback(value = false)
public class TestMain {

    @Autowired
    ParentRepository repository;

//    @BeforeEach
//    @Transactional
//    void beforeEach() {
//        Parent parent = new Parent("parent");
//        parent.setAddChild(true);
//        repository.save(parent);
//    }

    @Test
    @Transactional
    void test() {
        Parent parent = repository.findById(1L).get();
        parent.setAddChild(true);

        parent.setName("name=" + Instant.now());
    }

    @Test
    @Transactional
    void test2() {
        Parent parent = repository.findById(1L).get();
        parent.setAddChild(true);

        parent.setName("name=" + Instant.now());
        repository.save(parent);
    }


    @Test
    @Transactional
    void test3() {
        Parent parent = repository.findById(1L).get();
        parent.setAddChild(true);

        parent.setName("name=" + Instant.now());
        repository.saveAndFlush(parent);
    }
}
