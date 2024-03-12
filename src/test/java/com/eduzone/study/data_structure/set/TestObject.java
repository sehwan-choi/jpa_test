package com.eduzone.study.data_structure.set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestObject {

    private String name;

    private int age;

    @Override
    public boolean equals(Object o) {
        System.out.println("TestObject::equals object = " + o);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestObject that = (TestObject) o;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hash(name, age);
        System.out.println("TestObject::hashCode hash = " + hash);
        return hash;
    }
}
