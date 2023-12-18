package com.eduzone.jpastudy.study._7장_고급매핑.조인테이블._1_N_조인테이블;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
class Parent {

    @Id
    @Column(name = "PARENT_ID")
    private Long id;

    private String name;

    @OneToMany
    /**
     * joinColumns, inverseJoinColumns 생략가능
     * 생략하면 자동으로 PK랑 연결이된다
     */
    @JoinTable(name = "PARENT_CHILD",                           // 매핑할 조인 테이블 이름
            joinColumns = @JoinColumn(name = "PARENT_ID"),          //  현재 엔티티를 참조하는 외래 키
            inverseJoinColumns = @JoinColumn(name = "CHILD_ID"))    // 반대방향 엔티티를 참조하는 외래키
    private List<Child> childList = new ArrayList<>();
}

@Entity
@Data
class Child {

    @Id
    @Column(name = "CHILD_ID")
    private Long id;

    private String name;
}
