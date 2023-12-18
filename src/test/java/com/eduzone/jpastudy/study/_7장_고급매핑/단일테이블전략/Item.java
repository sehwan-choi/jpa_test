package com.eduzone.jpastudy.study._7장_고급매핑.단일테이블전략;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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
@DiscriminatorValue("ALBUM")
@Data
class Album extends Item{

    private String artist;
}

@Entity
@DiscriminatorValue("BOOK")
@Data
@ToString(callSuper = true)
@PrimaryKeyJoinColumn(name = "BOOK_ID")
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