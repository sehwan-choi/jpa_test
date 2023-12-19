package com.eduzone.jpastudy.study._9장_값타입._값타입의_필요성._값타입_도입_전;

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
    private String phoneNumber;
    private String phoneNumberFirst;
    private String phoneNumberMiddle;
    private String phoneNumberLast;
    private String phoneProvider;
    private String city;
    private String street;
    private String zipCode;
    private String companyCity;
    private String companyStreet;
    private String companyZipCode;
}
