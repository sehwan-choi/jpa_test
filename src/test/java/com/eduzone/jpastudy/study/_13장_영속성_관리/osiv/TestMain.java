package com.eduzone.jpastudy.study._13장_영속성_관리.osiv;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study._13장_영속성_관리.osiv")
@Rollback(value = false)
@ActiveProfiles(value = "osiv")
public class TestMain {


    @Autowired
    EntityManager em;

    @Autowired
    OsivService service;

    @Test
    void test() {
        Long parentId = service.initParent();
        Parent parent = service.getParent(parentId);
        Child child = parent.getChildList().get(0);
        System.out.println("child = " + child);

    }


}
