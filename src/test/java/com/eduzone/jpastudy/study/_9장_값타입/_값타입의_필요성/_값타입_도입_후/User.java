package com.eduzone.jpastudy.study._9장_값타입._값타입의_필요성._값타입_도입_후;

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
    private PhoneService phoneService;

    @Embedded
    private Address address;

    @Embedded
    // 아래 속성은 위 address와 컬럼명이 똑같이 생성되기 때문에 MappingException 이 발생한다.
    // 그렇기 때문에 컬럼명을 다르게 변경해야한다.
    @AttributeOverrides({
            @AttributeOverride(name="city", column=@Column(name = "company_city")),
            @AttributeOverride(name="street", column=@Column(name = "company_street")),
            @AttributeOverride(name="zipCode", column=@Column(name = "company_zipcode"))
    })
    private Address companyAddress;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setPhoneService(PhoneProvider provider, String phoneNumber) {
        this.phoneService = new PhoneService(provider, phoneNumber);
    }

    public void setHouseAddress(String city, String street, String zipCode) {
        this.address = createAddress(city,street,zipCode);
    }

    public void setCompanyAddress(String city, String street, String zipCode) {
        this.companyAddress = createAddress(city,street,zipCode);
    }

    private Address createAddress(String city, String street, String zipCode) {
        return new Address(city, street, zipCode);
    }
}
