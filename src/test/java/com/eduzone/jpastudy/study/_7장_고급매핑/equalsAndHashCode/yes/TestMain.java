package com.eduzone.jpastudy.study._7장_고급매핑.equalsAndHashCode.yes;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.HashSet;

@SpringBootTest
@SpringBootApplication(scanBasePackages = {"com.eduzone.jpastudy.study._7장_고급매핑.equalsAndHashCode.yes"})
@Rollback(value = false)
public class TestMain {

    @Autowired
    EntityManager em;

    @BeforeEach
    @Transactional
    void beforeEach() {
        Album album = new Album();
        album.setId(1L);
        album.setName("aaa");
        album.setPrice(10000);
        album.setArtist("Art");

        Album album2 = new Album();
        album2.setId(2L);
        album2.setName("bbb");
        album2.setPrice(20000);
        album2.setArtist("Art");

        Album album3 = new Album();
        album3.setId(3L);
        album3.setName("ccc");
        album3.setPrice(30000);
        album3.setArtist("Art");

        em.persist(album);
        em.persist(album2);
        em.persist(album3);

        em.flush();
        em.clear();
    }

    @Test
    @Transactional
    void hashcodeTest() {
        Album album = em.find(Album.class, 1L);

        Album album2 = em.find(Album.class, 2L);

        Album album3 = em.find(Album.class, 3L);
        System.out.println("album = " + album);
        System.out.println("album2 = " + album2);
        System.out.println("album3 = " + album3);

        System.out.println("album.hashCode() = " + album.hashCode());
        System.out.println("album2.hashCode() = " + album2.hashCode());
        System.out.println("album3.hashCode() = " + album3.hashCode());
    }

    @Test
    @Transactional
    void hashcodeTest2() {
        Album album = em.find(Album.class, 1L);

        Album album2 = em.find(Album.class, 2L);

        Album album3 = em.find(Album.class, 3L);
        System.out.println("album = " + album);
        System.out.println("album2 = " + album2);
        System.out.println("album3 = " + album3);

        System.out.println("album.hashCode() = " + album.hashCode());
        System.out.println("album2.hashCode() = " + album2.hashCode());
        System.out.println("album3.hashCode() = " + album3.hashCode());

        HashSet<Album> hashSet = new HashSet<>();
        hashSet.add(album);
        hashSet.add(album2);
        hashSet.add(album3);

        System.out.println("hashSet.size() = " + hashSet.size());
    }

    @Test
    @Transactional
    void hashcodeTest3() {
        Album album = em.find(Album.class, 1L);

        Album album2 = em.find(Album.class, 2L);

        Album album3 = em.find(Album.class, 3L);
        System.out.println("album = " + album);
        System.out.println("album2 = " + album2);
        System.out.println("album3 = " + album3);

        System.out.println("album.hashCode() = " + album.hashCode());
        System.out.println("album2.hashCode() = " + album2.hashCode());
        System.out.println("album3.hashCode() = " + album3.hashCode());

        HashMap<Long, Album> hashMap = new HashMap<>();
        hashMap.put(album.getId(), album);
        hashMap.put(album2.getId(), album2);
        hashMap.put(album3.getId(), album3);

        System.out.println("hashMap.size() = " + hashMap.size());
    }

    @Test
    @Transactional
    void hashcodeTest4() {
        Album album = em.find(Album.class, 1L);

        Album album2 = em.find(Album.class, 2L);

        Album album3 = em.find(Album.class, 3L);
        System.out.println("album = " + album);
        System.out.println("album2 = " + album2);
        System.out.println("album3 = " + album3);

        System.out.println("album.hashCode() = " + album.hashCode());
        System.out.println("album2.hashCode() = " + album2.hashCode());
        System.out.println("album3.hashCode() = " + album3.hashCode());

        HashMap<Album, Album> hashMap = new HashMap<>();
        hashMap.put(album, album);
        hashMap.put(album2, album2);
        hashMap.put(album3, album3);

        System.out.println("hashMap.size() = " + hashMap.size());
    }

    @Test
    @Transactional
    void equalsTest() {
        Album album = em.find(Album.class, 1L);

        Album album2 = em.find(Album.class, 2L);

        Album album3 = em.find(Album.class, 3L);
        System.out.println("album = " + album);
        System.out.println("album2 = " + album2);
        System.out.println("album3 = " + album3);


        System.out.println("album.equals(album2) = " + album.equals(album2));
        System.out.println("album2.equals(album3) = " + album2.equals(album3));
        System.out.println("album3.equals(album) = " + album3.equals(album));
    }
}
