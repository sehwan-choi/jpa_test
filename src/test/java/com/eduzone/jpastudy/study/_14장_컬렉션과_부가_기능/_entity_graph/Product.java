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
@ToString
@NamedEntityGraph(attributeNodes = {
        @NamedAttributeNode(value = "productOrders", subgraph = "productOrders")
    },
        subgraphs = @NamedSubgraph(name = "productOrders", attributeNodes = {
                @NamedAttributeNode("orders")
        })
)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<ProductOrder> productOrders = new ArrayList<>();

    public Product(String name) {
        this.name = name;
    }

    public void addChild(ProductOrder po) {
        productOrders.add(po);
        po.setProduct(this);
    }
}
