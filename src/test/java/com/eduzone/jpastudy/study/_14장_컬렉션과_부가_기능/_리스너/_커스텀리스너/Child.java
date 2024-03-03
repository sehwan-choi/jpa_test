package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._리스너._커스텀리스너;

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

    @ManyToOne
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
