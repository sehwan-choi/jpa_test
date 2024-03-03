package com.eduzone.jpastudy.study.my._리스너;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Data
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
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
