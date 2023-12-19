package com.eduzone.jpastudy.study._9장_값타입.test._1;

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

    public static User createUser(String name, int age, String street, String detail, String zipcode) {
        User user = User.createUser(name, age);
        user.setAddress(street, detail, zipcode);
        return user;
    }

    public void setAddress(String street, String detail, String zipcode) {
        this.address = new Address(detail, street, zipcode);
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
