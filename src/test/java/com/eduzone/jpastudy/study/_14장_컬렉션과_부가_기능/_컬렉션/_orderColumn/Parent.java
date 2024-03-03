package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._컬렉션._orderColumn;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Parent(String name) {
        this.name = name;
    }

    @OrderColumn(name = "POSITION")
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private final List<Child> children = new ArrayList<>();

    public void add(Child child) {
        children.add(child);
        child.setParent(this);
    }
}
