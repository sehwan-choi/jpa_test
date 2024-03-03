package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._컬렉션.check_class;

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

    // class org.hibernate.collection.spi.PersistentBag
    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Child> collection = new ArrayList<>();

    // class org.hibernate.collection.spi.PersistentBag
    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Child> list = new ArrayList<>();

    // class org.hibernate.collection.spi.PersistentSet
    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Child> set = new HashSet<>();

    // class org.hibernate.collection.spi.PersistentList
    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderColumn
    private List<Child> orderList = new ArrayList<>();
}
