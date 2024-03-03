package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._컬렉션._orderColumn;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
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

    @Setter
    @ManyToOne
    private Parent parent;
}
