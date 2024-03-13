package com.eduzone.jpastudy.study.encryt.convert_encrypt;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode(of = "id")
@Table(name = "users")
public class ConvertUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = EncryptConverter.class)
    private String name;

    private int age;

    @Convert(converter = EncryptConverter.class)
    private String phoneNumber;

    @Convert(converter = EncryptConverter.class)
    private String address;

    public ConvertUser(String name, int age, String phoneNumber, String address) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
