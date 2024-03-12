package com.eduzone.jpastudy.study.listener_encryt;

import com.eduzone.jpastudy.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestService {

    @Autowired
    UserRepository repository;

    @Transactional
    void init() {
        Timer timer = new Timer();
        timer.start();
        for (int i = 0 ; i < 1000 ; i ++) {
            User user = new User("sehwan_" + (i + 1), (i + 10), "010-1234-1234-" + i, "seoul_" + i);
            repository.save(user);
        }
        timer.end();
    }

    @Transactional
    void printAll() {
        Timer timer = new Timer();
        timer.start();
        List<User> all = repository.findAll();
        all.forEach(System.out::println);
        timer.end();
    }
}
