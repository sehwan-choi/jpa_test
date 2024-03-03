package com.eduzone.jpastudy.study._13장_영속성_관리.osiv;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class OsivService {

    private final EntityManager em;

    @Transactional
    public Long initParent() {
        Child child1 = new Child("choi");
        Child child2 = new Child("choi2");
        Child child3 = new Child("choi3");
        Parent parent = new Parent("kim");
        parent.addChild(child1)
                .addChild(child2)
                .addChild(child3);

        em.persist(parent);
        return parent.getId();
    }

    @Transactional(readOnly = true)
    public Parent getParent(Long id) {
        return em.find(Parent.class, id);
    }
}
