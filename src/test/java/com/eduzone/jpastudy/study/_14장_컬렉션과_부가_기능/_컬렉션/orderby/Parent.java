package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._컬렉션.orderby;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Parent(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("name desc")
    private Collection<Child> collection = new ArrayList<>();

    public void add(Child child) {
        collection.add(child);
        child.setParent(this);
    }
}
