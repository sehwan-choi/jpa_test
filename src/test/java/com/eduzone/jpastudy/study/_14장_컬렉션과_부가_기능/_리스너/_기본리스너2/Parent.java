package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._리스너._기본리스너2;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Child> childList = new ArrayList<>();

    public Parent(String name) {
        this.name = name;
    }

    public void addChild(Child child) {
        childList.add(child);
        child.setParent(this);
    }

    public void deleteChild(Child child) {
        childList.removeIf(f -> f.getId().equals(child.getId()));
    }

    @PrePersist
    public void prePersist() {
        System.out.println(this.getClass().getName() + "==============================> prePersist");
    }

    @PostPersist
    public void postPersist() {
        System.out.println(this.getClass().getName() + "==============================> postPersist");
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println(this.getClass().getName() + "==============================> preUpdate");
    }

    @PostUpdate
    public void postUpdate() {
        System.out.println(this.getClass().getName() + "==============================> postUpdate");
    }

    @PreRemove
    public void preRemove() {
        System.out.println(this.getClass().getName() + "==============================> preRemove");
    }

    @PostRemove
    public void postRemove() {
        System.out.println(this.getClass().getName() + "==============================> postRemove");
    }

    @PostLoad
    public void postLoad() {
        System.out.println(this.getClass().getName() + "==============================> postLoad");
    }

}
