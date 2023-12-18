package com.eduzone.jpastudy.study._7장_고급매핑.mapped_super_class_attribute_override;

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
@AttributeOverrides({
        @AttributeOverride(name="id", column= @Column(name = "MEMBER_ID")),
        @AttributeOverride(name="name", column= @Column(name = "MEMBER_NAME")),
        @AttributeOverride(name="createdAt", column= @Column(name = "MEMBER_CREATED_AT"))
})
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