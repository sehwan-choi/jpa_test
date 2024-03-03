package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._컬렉션.converter_class_level;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Convert(converter = UserTypeConverter.class, attributeName = "type")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private UserType type;

    public Parent(String name, UserType type) {
        this.name = name;
        this.type = type;
    }
}

enum UserType {
    TEACHER,
    STUDENT;
}