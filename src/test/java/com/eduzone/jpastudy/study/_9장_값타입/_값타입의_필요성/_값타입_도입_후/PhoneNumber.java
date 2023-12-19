package com.eduzone.jpastudy.study._9장_값타입._값타입의_필요성._값타입_도입_후;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class PhoneNumber {

    private String phoneNumber;
    private String phoneNumberFirst;
    private String phoneNumberMiddle;
    private String phoneNumberLast;

    public PhoneNumber(String phoneNumber) {
        String[] split = phoneNumber.split("-");
        this.phoneNumberFirst = split[0];
        this.phoneNumberMiddle = split[1];
        this.phoneNumberLast = split[2];
        this.phoneNumber = phoneNumber;
    }
}
