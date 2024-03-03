package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._컬렉션.set;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Getter
//@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Parent(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private final Set<Child> children = new HashSet<>();

    public void add(Child child) {
        children.add(child);
        child.setParent(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parent parent = (Parent) o;
        return Objects.equals(id, parent.id) && Objects.equals(name, parent.name) && Objects.equals(children, parent.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, children);
    }
}
