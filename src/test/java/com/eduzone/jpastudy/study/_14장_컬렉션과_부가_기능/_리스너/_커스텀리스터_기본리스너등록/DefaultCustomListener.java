package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._리스너._커스텀리스터_기본리스너등록;

import jakarta.persistence.*;

public class DefaultCustomListener {

    @PrePersist
    public void prePersist(Object obj) {
        System.out.println("[" + getClass().getSimpleName() + "]" + "DefaultListener==============================> prePersist [" + obj + "]");
    }

    @PostPersist
    public void postPersist(Object obj) {
        System.out.println("[" + getClass().getSimpleName() + "]" + "DefaultListener==============================> postPersist [" + obj + "]");;
    }

    @PreUpdate
    public void preUpdate(Object obj) {
        System.out.println("[" + getClass().getSimpleName() + "]" + "DefaultListener==============================> preUpdate [" + obj + "]");
    }

    @PostUpdate
    public void postUpdate(Object obj) {
        System.out.println("[" + getClass().getSimpleName() + "]" + "DefaultListener==============================> postUpdate [" + obj + "]");
    }

    @PreRemove
    public void preRemove(Object obj) {
        System.out.println("[" + getClass().getSimpleName() + "]" + "DefaultListener==============================> preRemove [" + obj + "]");
    }

    @PostRemove
    public void postRemove(Object obj) {
        System.out.println("[" + getClass().getSimpleName() + "]" + "DefaultListener==============================> postRemove [" + obj + "]");
    }

    @PostLoad
    public void postLoad(Object obj) {
        System.out.println("[" + getClass().getSimpleName() + "]" + "DefaultListener==============================> postLoad [" + obj + "]");
    }
}
