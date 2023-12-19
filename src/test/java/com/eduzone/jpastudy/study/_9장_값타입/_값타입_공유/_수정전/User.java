package com.eduzone.jpastudy.study._9장_값타입._값타입_공유._수정전;

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

    public static User createUser(String name, int age) {
        User user = new User();
        user.name = name;
        user.age = age;
        return user;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
