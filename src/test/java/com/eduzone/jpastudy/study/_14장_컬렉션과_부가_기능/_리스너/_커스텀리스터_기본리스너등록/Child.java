package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._리스너._커스텀리스터_기본리스너등록;

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
        System.out.println("[" + getClass().getSimpleName() + "]" + "==============================>>>>>>>>>>>>> prePersist [" + this + "]");
    }

    @PostPersist
    public void postPersist() {
        System.out.println("[" + getClass().getSimpleName() + "]" + "==============================>>>>>>>>>>>>> postPersist [" + this + "]");
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println("[" + getClass().getSimpleName() + "]" + "==============================>>>>>>>>>>>>> preUpdate [" + this + "]");
    }

    @PostUpdate
    public void postUpdate() {
        System.out.println("[" + getClass().getSimpleName() + "]" + "==============================>>>>>>>>>>>>> postUpdate [" + this + "]");
    }

    @PreRemove
    public void preRemove() {
        System.out.println("[" + getClass().getSimpleName() + "]" + "==============================>>>>>>>>>>>>> preRemove [" + this + "]");
    }

    @PostRemove
    public void postRemove() {
        System.out.println("[" + getClass().getSimpleName() + "]" + "==============================>>>>>>>>>>>>> postRemove [" + this + "]");
    }

    @PostLoad
    public void postLoad() {
        System.out.println("[" + getClass().getSimpleName() + "]" + "==============================>>>>>>>>>>>>> postLoad [" + this + "]");
    }
}
