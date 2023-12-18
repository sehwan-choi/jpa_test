package com.eduzone.jpastudy.study._7장_고급매핑.비식별관계맵핑.id_class;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@IdClass(ParentId.class)
public class Parent {

    @Id
    @Column(name = "parent_id1")
    private String id1;

    @Id
    @Column(name = "parent_id2")
    private String id2;

    private String name;

    private int age;
}

@Entity
@Data
class Child {

    @Id
    private String id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="id1", referencedColumnName="parent_id1"),
            @JoinColumn(name="id2", referencedColumnName="parent_id2")
    })
    private Parent parent;
}

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
class ParentId implements Serializable {

    private String id1;

    private String id2;
}