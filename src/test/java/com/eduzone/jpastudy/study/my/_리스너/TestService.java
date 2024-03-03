package com.eduzone.jpastudy.study.my._리스너;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestService {

    private final ParentRepository repository;

    @Transactional
    public Long createUser() {

        Parent choi = new Parent("choi");
        repository.save(choi);

        System.out.println("choi = " + choi);
        return choi.getId();
    }

    @Transactional
    public Long createUserAndChild(int count) {

        Parent choi = new Parent("choi");
        for (int i = 0 ; i < count ; i ++) {
            Child kim = new Child("kim_" + (i+1));
            choi.addChild(kim);
        }
        repository.save(choi);

        System.out.println("choi = " + choi);
        return choi.getId();
    }

    @Transactional
    public void printUser(Long userId) {
        Parent parent = repository.findById(userId).get();
        System.out.println("parent = " + parent);
    }

    @Transactional
    public void updateUser(Long userId) {
        Parent parent = repository.findById(userId).get();
        System.out.println("parent = " + parent);

        parent.setName("zzz");
        System.out.println("parent = " + parent);
    }

    @Transactional
    public void deleteUser(Long userId) {
        Parent parent = repository.findById(userId).get();
        System.out.println("parent = " + parent);

        repository.delete(parent);
        System.out.println("parent = " + parent);
    }

    @Transactional
    public void deleteChild(Long userId) {
//        Parent parent = repository.findById(userId).get();
        Parent parent = repository.findByName("choi").get();
        System.out.println("parent = " + parent);

        parent.deleteChild(parent.getChildList().get(0));
        parent.deleteChild(parent.getChildList().get(1));
        System.out.println("parent = " + parent);
    }
}
