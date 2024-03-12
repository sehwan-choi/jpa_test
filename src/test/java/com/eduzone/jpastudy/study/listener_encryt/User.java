package com.eduzone.jpastudy.study.listener_encryt;

import com.eduzone.jpastudy.study.listener_encryt.encryt_core.impl.AES256Crypto;
import com.eduzone.jpastudy.study.listener_encryt.spring_encryt.Encrypted;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Encrypted
    private String name;

    private int age;

    @Encrypted(cryptoKey = "payment_crypto")
    private String phoneNumber;

    @Encrypted(cryptoKey = "user_crypto")
    private String address;

    public User(String name, int age, String phoneNumber, String address) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
