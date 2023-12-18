package com.eduzone.jpastudy.study._7장_고급매핑.equalsAndHashCode;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.Objects;

public class EHTest {

    @Test
    void noEqualsAndHashCode() {
        ParentId parentId = new ParentId("1", "2");
        ParentId parentId2 = new ParentId("1", "2");

        System.out.println("parentId.equals(parentId2) = " + parentId.equals(parentId2));
    }

    @Test
    void yesEqualsAndHashCode() {
        EqualsAndHashcodeParentId parentId = new EqualsAndHashcodeParentId("1", "2");
        EqualsAndHashcodeParentId parentId2 = new EqualsAndHashcodeParentId("1", "2");

        System.out.println("parentId.equals(parentId2) = " + parentId.equals(parentId2));
    }

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    static class ParentId implements Serializable {

        @Column(name = "parent_id1")
        private String id1;

        @Column(name = "parent_id2")
        private String id2;
    }

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    static class EqualsAndHashcodeParentId implements Serializable {

        @Column(name = "parent_id1")
        private String id1;

        @Column(name = "parent_id2")
        private String id2;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            EqualsAndHashcodeParentId that = (EqualsAndHashcodeParentId) o;
            return Objects.equals(id1, that.id1) && Objects.equals(id2, that.id2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id1, id2);
        }
    }
}
