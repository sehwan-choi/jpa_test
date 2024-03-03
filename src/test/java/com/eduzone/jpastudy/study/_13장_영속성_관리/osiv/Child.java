package com.eduzone.jpastudy.study._13장_영속성_관리.osiv;

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
}
