package com.eduzone.jpastudy.study._7장_고급매핑.조인전략.dtype_change;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ITEM_TYPE")
@Data
public abstract class Item {

    @Id
    private Long id;

    private String name;

    private int price;
}

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("ALBUM")
@Data
class Album extends Item{

    private String artist;
}

@Entity
@DiscriminatorValue("BOOK")
@Data
@ToString(callSuper = true)
class Book extends Item{

    private String author;

    private String isbn;
}

@Entity
@DiscriminatorValue("MOVIE")
@Data
@ToString(callSuper = true)
class Movie extends Item{

    private String director;

    private String actor;
}