package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._컬렉션.set;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
//@AllArgsConstructor
@ToString(exclude = "parent")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Child(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Child(String name) {
        this.name = name;
    }

    @Setter
    @ManyToOne
    private Parent parent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return Objects.equals(id, child.id) && Objects.equals(name, child.name) && Objects.equals(parent, child.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
