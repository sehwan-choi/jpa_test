package com.eduzone.jpastudy.study._7장_고급매핑.조인테이블._1_1_조인테이블;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "child")
class Parent {

    @Id
    @Column(name = "PARENT_ID")
    private Long id;

    private String name;

    @OneToOne
    /**
     * joinColumns, inverseJoinColumns 생략가능
     * 생략하면 자동으로 PK랑 연결이된다
     */
    @JoinTable(name = "PARENT_CHILD",                           // 매핑할 조인 테이블 이름
        joinColumns = @JoinColumn(name = "PARENT_ID"),          //  현재 엔티티를 참조하는 외래 키
        inverseJoinColumns = @JoinColumn(name = "CHILD_ID"))    // 반대방향 엔티티를 참조하는 외래키
    private Child child;
}

@Entity
@Data
@ToString
class Child {

    @Id
    @Column(name = "CHILD_ID")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "child")
    private Parent parent;
}
