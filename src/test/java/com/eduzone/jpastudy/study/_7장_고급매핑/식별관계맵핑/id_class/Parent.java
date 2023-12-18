package com.eduzone.jpastudy.study._7장_고급매핑.식별관계맵핑.id_class;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
public class Parent {

    @Id
    @Column(name = "parent_id1")
    private String id1;

    private String name;

    private int age;
}

@Entity
@Data
@IdClass(ChildId.class)
class Child {

    @Id
    @ManyToOne
    @JoinColumn
    private Parent parent;

    @Id
    private String childId;
}

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
class ChildId implements Serializable {

    private String parent;

    private String childId;
}

@Entity
@IdClass(GrandChildId.class)
@Data
class GrandChild {

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn,
            @JoinColumn
    })
    private Child child;

    @Id
    @Column
    private String grandChildId;
}

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
class GrandChildId implements Serializable {

    private ChildId child;

    private String grandChildId;
}