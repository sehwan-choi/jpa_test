package com.eduzone.jpastudy.study._9장_값타입._값타입_컬렉션;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * 값타입 컬렉션은 기본적으로 영속성 전이(Cascade) + 고아 객체 제거(Orphan Remove) 기능을 필수로 가지고 있다.
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    /*
    @CollectionTable(name = "")이 없는경우
        테이블의 이름은 해당 객체이름(User) + 프로퍼티명으로 지어진다
        ex). USER_FAVORITE_FOODS

    @CollectionTable(joinColumns = @JoinColumn(name = "")이 없는경우
        해당 객체이름(User) + 해당 객체 PK 프로퍼티명으로 지어진다.
        ex). USER_ID
    */
    @ElementCollection
    @CollectionTable(
            name = "favorite_foods",
            joinColumns = @JoinColumn(name = "memmber_id")
    )
    // @Column이 없다면 기본 컬럼명은 프로퍼티명으로 지어진다
    // favorite_fodds
    @Column(name = "user_food")
    private Set<String> favoriteFoods = new HashSet<>();

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addFood(String food) {
        favoriteFoods.add(food);
    }

    public void foodClear() {
        favoriteFoods.clear();
    }
}
