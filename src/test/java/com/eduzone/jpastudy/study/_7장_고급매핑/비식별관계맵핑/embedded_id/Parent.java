package com.eduzone.jpastudy.study._7장_고급매핑.비식별관계맵핑.embedded_id;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
public class Parent {

    @EmbeddedId
    private ParentId id;

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

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
class ParentId implements Serializable {

    @Column(name = "parent_id1")
    private String id1;

    @Column(name = "parent_id2")
    private String id2;
}