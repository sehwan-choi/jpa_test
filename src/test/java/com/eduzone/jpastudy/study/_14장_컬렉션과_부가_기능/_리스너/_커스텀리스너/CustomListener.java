package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._리스너._커스텀리스너;

import jakarta.persistence.*;

public class CustomListener {

    @PrePersist
    public void prePersist(Parent parent) {
        System.out.println(this.getClass().getName() + "==============================> prePersist [" + parent + "]");
    }

    @PostPersist
    public void postPersist(Parent parent) {
        System.out.println(this.getClass().getName() + "==============================> postPersist [" + parent + "]");;
    }

    @PreUpdate
    public void preUpdate(Parent parent) {
        System.out.println(this.getClass().getName() + "==============================> preUpdate [" + parent + "]");
    }

    @PostUpdate
    public void postUpdate(Parent parent) {
        System.out.println(this.getClass().getName() + "==============================> postUpdate [" + parent + "]");
    }

    @PreRemove
    public void preRemove(Parent parent) {
        System.out.println(this.getClass().getName() + "==============================> preRemove [" + parent + "]");
    }

    @PostRemove
    public void postRemove(Parent parent) {
        System.out.println(this.getClass().getName() + "==============================> postRemove [" + parent + "]");
    }

    @PostLoad
    public void postLoad(Parent parent) {
        System.out.println(this.getClass().getName() + "==============================> postLoad [" + parent + "]");
    }
}
