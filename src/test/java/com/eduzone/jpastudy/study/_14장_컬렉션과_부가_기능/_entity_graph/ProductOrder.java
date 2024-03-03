package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._entity_graph;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@ToString(exclude = {"product"})
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "productOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Orders> orders = new ArrayList<>();

    @Setter
    @ManyToOne
    private Product product;

    public ProductOrder(String name) {
        this.name = name;
    }

    public void addChild(Orders order) {
        orders.add(order);
        order.setProductOrder(this);
    }
}
