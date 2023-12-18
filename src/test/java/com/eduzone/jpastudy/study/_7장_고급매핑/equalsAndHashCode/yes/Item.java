package com.eduzone.jpastudy.study._7장_고급매핑.equalsAndHashCode.yes;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
@Data
public abstract class Item {

    @Id
    private Long id;

    private String name;

    private int price;
}

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("A")
@Data
@ToString(callSuper = true)
class Album extends Item{

    private String artist;
}

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("B")
@Data
@ToString(callSuper = true)
class Book extends Item{

    private String author;

    private String isbn;
}

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("M")
@Data
@ToString(callSuper = true)
class Movie extends Item{

    private String director;

    private String actor;
}