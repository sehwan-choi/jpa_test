package com.eduzone.jpastudy.study._13장_영속성_관리.osiv;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Parent(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Child> childList = new ArrayList<>();

    public Parent addChild(Child child) {
        childList.add(child);
        child.setParent(this);
        return this;
    }

    public void deleteChild(Child child) {
        childList.removeIf(f -> f.getId().equals(child.getId()));
    }
}
