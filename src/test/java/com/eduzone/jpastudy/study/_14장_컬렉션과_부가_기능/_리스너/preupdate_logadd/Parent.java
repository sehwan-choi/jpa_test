package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._리스너.preupdate_logadd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    @Transient
    @Setter
    private boolean addChild = false;

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

    @PreUpdate
    public void preUpdate() {
        System.out.println(this.getClass().getName() + "==============================> preUpdate");
        if (addChild) {
            this.childList.add(new Child("abc" + LocalDateTime.now(), this));
            System.out.println(this.getClass().getName() + "==============================> ADD !");
        }
    }
}
