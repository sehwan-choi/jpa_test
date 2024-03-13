package com.eduzone.jpastudy.study.encryt.annotaionbase_encrypt;

import com.eduzone.jpastudy.study.encryt.annotaionbase_encrypt.spring_encryt.Encrypted;
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
public class EncryptUser {

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

    public EncryptUser(String name, int age, String phoneNumber, String address) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
