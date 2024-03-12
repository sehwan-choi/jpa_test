package com.eduzone.jpastudy.study.listener_encryt.spring_encryt;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import lombok.Setter;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.PostLoadEventListener;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringEncryptionBeanPostProcessor {

    @Setter(onMethod_ = @Autowired)
    private EntityManagerFactory entityManagerFactory;

    @Setter(onMethod_ = @Autowired, onParam_ = @Qualifier("defaultEncryptionListener"))
    private PreInsertEventListener insertEventListener;

    @Setter(onMethod_ = @Autowired, onParam_ = @Qualifier("defaultEncryptionListener"))
    private PreUpdateEventListener updateEventListener;

    @Setter(onMethod_ = @Autowired, onParam_ = @Qualifier("defaultEncryptionListener"))
    private PostLoadEventListener loadedEventListener;

    @PostConstruct
    public void registerEntityListener() {
        SessionFactoryImpl sessionFactory = entityManagerFactory.unwrap(SessionFactoryImpl.class);

        EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);

        registry.getEventListenerGroup(EventType.POST_LOAD).appendListener(loadedEventListener);
        registry.getEventListenerGroup(EventType.PRE_UPDATE).appendListener(updateEventListener);
        registry.getEventListenerGroup(EventType.PRE_INSERT).prependListener(insertEventListener);
    }
}
