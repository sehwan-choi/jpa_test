package com.eduzone.jpastudy.study._9장_값타입._값타입의_필요성._값타입_도입_후;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class PhoneProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phoneProviderName;

    private String nationalCode;
    private String areaCode;

    public PhoneProvider(String phoneProviderName, String nationalCode, String areaCode) {
        this.phoneProviderName = phoneProviderName;
        this.nationalCode = nationalCode;
        this.areaCode = areaCode;
    }
}
