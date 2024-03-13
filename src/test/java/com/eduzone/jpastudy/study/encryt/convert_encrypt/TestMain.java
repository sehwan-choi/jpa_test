package com.eduzone.jpastudy.study.encryt.convert_encrypt;

import com.eduzone.jpastudy.Timer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study.encryt.convert_encrypt")
@Rollback(value = false)
public class TestMain {

    /**
     * @Encrypted (Annocation) vs @Converter 속도 테스트 (userDataSet메서드 이용)
     *
     * 1000건 insert(단건 insert)
     *               1차    2차    3차  (단위 ms)
     * @Encrypted :  752   804    875
     * @Converter :  745   722    741
     *
     * 1000건 select (userDateGet메서드 이용)
     *               1차    2차    3차  (단위 ms)
     * @Encrypted :  316   316    312
     * @Converter :  313   346    388
     *
     */

    @Autowired
    ConvertUserService service;

    @Test
    void userDataSet() {
        Timer timer = new Timer();
        timer.start();
        service.init(1000);
        timer.end();
    }

    @Test
    void userDateGet() {
        Timer timer = new Timer();
        timer.start();
        service.printAll();
        timer.end();
    }

    @Test
    void update() {
        service.update();
    }
}