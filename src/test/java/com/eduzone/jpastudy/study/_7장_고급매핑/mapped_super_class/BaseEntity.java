package com.eduzone.jpastudy.study._7장_고급매핑.mapped_super_class;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    private Long id;

    private String name;

    private LocalDateTime createdAt;
}

@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
class Member extends BaseEntity {

    private String email;
}

@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
class Seller extends BaseEntity {

    private String shopName;
}