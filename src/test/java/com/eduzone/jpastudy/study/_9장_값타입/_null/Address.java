package com.eduzone.jpastudy.study._9장_값타입._null;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class Address {

    private String city;
    private String street;
    private String zipCode;
}
