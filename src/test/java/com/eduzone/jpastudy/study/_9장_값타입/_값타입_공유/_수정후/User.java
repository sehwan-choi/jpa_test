package com.eduzone.jpastudy.study._9장_값타입._값타입_공유._수정후;

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

    // 공유 참조를 피할수 있는 방법 1
    public static User createUser(String name, int age, String street, String detail, String zipcode) {
        User user = new User();
        user.name = name;
        user.age = age;
        user.address = new Address(detail, street, zipcode);
        return user;
    }

    // 공유 참조를 피할수 있는 방법 2
    public void setAddress(String street, String detail, String zipcode) {
        this.address = new Address(detail, street, zipcode);
    }

    public void setAddress(Address address) {
        this.address = new Address(address.getDetail(), address.getStreet(), address.getZipCode());
    }
}
