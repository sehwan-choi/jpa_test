package com.eduzone.jpastudy.study.listener_encryt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
class EncryptUserService {

    @Autowired
    EncryptUserRepository repository;

    @Transactional
    void init(int count) {
        for (int i = 0 ; i < count ; i ++) {
            EncryptUser user = new EncryptUser("sehwan_" + (i + 1), (i + 10), "010-1234-1234-" + i, "seoul_" + i);
            repository.save(user);
        }
    }

    void printAll() {
        List<EncryptUser> all = repository.findAll();
        all.forEach(System.out::println);
    }

    void printCount() {
        List<EncryptUser> all = repository.findAll();
        System.out.println("count = " + all.size());
    }

    @Transactional
    void update() {
        EncryptUser user = repository.findById(1L).get();
        user.setName("zzzzz");
    }
}