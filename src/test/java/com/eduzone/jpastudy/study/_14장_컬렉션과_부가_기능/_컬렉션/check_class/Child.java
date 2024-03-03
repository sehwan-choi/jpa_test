package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._컬렉션.check_class;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@EqualsAndHashCode
@NoArgsConstructor
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
}
