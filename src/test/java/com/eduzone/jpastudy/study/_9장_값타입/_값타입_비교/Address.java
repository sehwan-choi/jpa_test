package com.eduzone.jpastudy.study._9장_값타입._값타입_비교;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode
public class Address {

    private String detail;
    private String street;
    private String zipCode;
}
