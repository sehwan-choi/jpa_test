package com.eduzone.jpastudy.study._9장_값타입._null;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    @Embedded
    private Address address;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
