package com.eduzone.jpastudy.study.my._리스너;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString(exclude = "parent")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Child(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Parent parent;

    @PrePersist
    public void prePersist() {
        System.out.println(this.getClass().getName() + "==============================>>>>>>>>>>>>> prePersist");
    }

    @PostPersist
    public void postPersist() {
        System.out.println(this.getClass().getName() + "==============================>>>>>>>>>>>>> postPersist");
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println(this.getClass().getName() + "==============================>>>>>>>>>>>>> preUpdate");
    }

    @PostUpdate
    public void postUpdate() {
        System.out.println(this.getClass().getName() + "==============================>>>>>>>>>>>>> postUpdate");
    }

    @PreRemove
    public void preRemove() {
        System.out.println(this.getClass().getName() + "==============================>>>>>>>>>>>>> preRemove");
    }

    @PostRemove
    public void postRemove() {
        System.out.println(this.getClass().getName() + "==============================>>>>>>>>>>>>> postRemove");
    }

    @PostLoad
    public void postLoad() {
        System.out.println(this.getClass().getName() + "==============================>>>>>>>>>>>>> postLoad");
    }
}
