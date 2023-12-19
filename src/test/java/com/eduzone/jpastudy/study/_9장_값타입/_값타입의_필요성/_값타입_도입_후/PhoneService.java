package com.eduzone.jpastudy.study._9장_값타입._값타입의_필요성._값타입_도입_후;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class PhoneService {

    @Embedded
    private PhoneNumber phoneNumber;
    @OneToOne
    @JoinColumn
    private PhoneProvider provider;

    public PhoneService(PhoneProvider provider, String phoneNumber) {
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.provider = provider;
    }
}
