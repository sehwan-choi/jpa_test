package com.eduzone.jpastudy.study._9장_값타입._값타입_공유._수정전;

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
