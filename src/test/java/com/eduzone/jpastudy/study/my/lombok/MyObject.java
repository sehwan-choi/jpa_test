package com.eduzone.jpastudy.study.my.lombok;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@EqualsAndHashCode
@ToString
@Builder(builderClassName = "Builder")
public class MyObject {
    private Long id;
    private String name;

    static class Builder {
        MyObject build() {
            if (Objects.isNull(id) || id < 0) {
                throw new RuntimeException("Invaid id");
            }
            if (Objects.isNull(name)) {
                throw new RuntimeException("name is null");
            }
            return new MyObject(id, name);
        }
    }
}
