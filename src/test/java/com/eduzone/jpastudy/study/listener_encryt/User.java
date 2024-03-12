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

    @PostLoad
    public void postLoad() {
        System.out.println("postLoad");
//        AES256Crypto crypto = new AES256Crypto("A957D12D8F5B1265DB1E9CE46CB33123");
//        this.name = crypto.decrypt(name);
//        this.phoneNumber = crypto.decrypt(phoneNumber);
//        this.address = crypto.decrypt(address);
    }

    @PrePersist
    public void prePersist() {
        System.out.println("prePersist");
//        AES256Crypto crypto = new AES256Crypto("A957D12D8F5B1265DB1E9CE46CB33123");
//        this.name = crypto.encrypt(name);
//        this.phoneNumber = crypto.encrypt(phoneNumber);
//        this.address = crypto.encrypt(address);
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println("preUpdate");
//        AES256Crypto crypto = new AES256Crypto("A957D12D8F5B1265DB1E9CE46CB33123");
//        this.name = crypto.encrypt(name);
//        this.phoneNumber = crypto.encrypt(phoneNumber);
//        this.address = crypto.encrypt(address);
    }
}
