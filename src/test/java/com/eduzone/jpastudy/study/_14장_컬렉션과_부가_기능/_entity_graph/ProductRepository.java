package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._entity_graph;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @EntityGraph(attributePaths = {"productOrders"})
    Optional<Product> findGraphById(Long id);
}
