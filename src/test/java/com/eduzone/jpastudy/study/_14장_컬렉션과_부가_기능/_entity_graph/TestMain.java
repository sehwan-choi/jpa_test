package com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._entity_graph;

import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Subgraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "com.eduzone.jpastudy.study._14장_컬렉션과_부가_기능._entity_graph")
@Rollback(value = false)
public class TestMain {

    @Autowired
    private EntityManager em;

    @Autowired
    private ProductRepository repository;

    @BeforeEach
    @Transactional
    void init() {
        ProductOrder po = new ProductOrder("po");
        Orders or = new Orders("or");
        Product pr = new Product("pr");

        pr.addChild(po);
        po.addChild(or);
        em.persist(pr);

        em.flush();
        em.clear();
    }

    @Test
    @Transactional
    void test() {
        EntityGraph<Product> graph = em.createEntityGraph(Product.class);
        graph.addAttributeNodes("productOrders");

        HashMap<String, Object> hint = new HashMap<>();
        hint.put("javax.persistence.fetchgraph", graph);

        Product product1 = em.find(Product.class, 1L, hint);
        System.out.println("product1 = " + product1);
    }

    @Test
    @Transactional
    void test2() {
        EntityGraph<Product> graph = em.createEntityGraph(Product.class);
        graph.addSubgraph("productOrder")
            .addAttributeNodes("orders");

        HashMap<String, Object> hint = new HashMap<>();
        hint.put("jakarta.persistence.fetchgraph", graph);

        Product product1 = em.find(Product.class, 1L, hint);
        System.out.println("product1 = " + product1);
    }

    @Test
    @Transactional
    void test3() {

        EntityGraph<Product> entityGraph  = em.createEntityGraph(Product.class);
        entityGraph .addAttributeNodes("productOrders");
        Subgraph<ProductOrder> orderItems = entityGraph .addSubgraph("productOrders");
        orderItems.addAttributeNodes("orders");

        Map hints = new HashMap();
        hints.put("javax.persistence.fetchgraph", entityGraph);

        Product product = em.find(Product.class, 1, hints);
        System.out.println("product = " + product);
    }

    @Test
    @Transactional
    void test4() {
        Product product = repository.findGraphById(1L).get();
        System.out.println("product = " + product);
    }
}
