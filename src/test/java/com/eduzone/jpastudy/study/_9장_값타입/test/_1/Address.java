package com.eduzone.jpastudy.study._9장_값타입.test._1;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode
public class Address {

    private String detail;
    private String street;
    private String zipCode;
}
