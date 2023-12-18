package com.eduzone.jpastudy.study._7장_고급매핑.구현클래스마다전략;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@SpringBootApplication(scanBasePackages = {"com.eduzone.jpastudy.study._7장_고급매핑.구현클래스마다전략"})
@Rollback(value = false)
public class TestMain {

    @Autowired
    EntityManager em;

    @BeforeEach
    @Transactional
    void beforeEach() {
        Album album = new Album();
        album.setId(1L);
        album.setArtist("Art");
        album.setName("aaa");
        album.setPrice(10000);

        em.persist(album);

        Book book = new Book();
        book.setId(2L);
        book.setName("book");
        book.setPrice(12500);
        book.setIsbn("1483490184");
        book.setAuthor("sehwan");

        em.persist(book);

        Movie movie = new Movie();
        movie.setId(3L);
        movie.setName("movie");
        movie.setPrice(50000);
        movie.setActor("sehwan");
        movie.setDirector("choi");

        em.persist(movie);

        em.flush();
        em.clear();
    }

    @Test
    @Transactional
    void test() {
        Album album = em.find(Album.class, 1L);

        Book book = em.find(Book.class, 2L);

        Movie movie = em.find(Movie.class, 3L);
        System.out.println("album = " + album);
        System.out.println("book = " + book);
        System.out.println("movie = " + movie);
    }

    @Test
    @Transactional
    void test2() {
        Item singleResult = (Item)em.createQuery("select i from Item i where name = 'book'")
                .getSingleResult();

        System.out.println("singleResult = " + singleResult);
    }
}
