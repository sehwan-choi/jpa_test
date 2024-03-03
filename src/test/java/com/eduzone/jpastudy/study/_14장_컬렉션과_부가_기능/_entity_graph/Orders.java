package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._entity_graph;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@ToString(exclude = "productOrder")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Setter
    @ManyToOne
    private ProductOrder productOrder;

    public Orders(String name) {
        this.name = name;
    }
}
