package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._컬렉션.map;

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

    @MapKey(name = "id")
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private Map<Long, Child> maps = new HashMap<>();

    public void add(Long id, Child child) {
        maps.put(id, child);
        child.setParent(this);
    }
}
