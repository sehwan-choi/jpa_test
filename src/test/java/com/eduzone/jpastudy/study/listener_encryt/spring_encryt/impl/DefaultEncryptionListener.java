package com.eduzone.jpastudy.study.listener_encryt.spring_encryt.impl;

import com.eduzone.jpastudy.study.listener_encryt.spring_encryt.FieldCrypto;
import lombok.RequiredArgsConstructor;
import org.hibernate.event.spi.*;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultEncryptionListener implements PreInsertEventListener, PreUpdateEventListener, PostLoadEventListener {

    private final FieldCrypto fieldCrypto;

    @Override
    public void onPostLoad(PostLoadEvent event) {
        fieldCrypto.decrypt(event.getEntity());
    }

    @Override
    public boolean onPreInsert(PreInsertEvent event) {
        fieldCrypto.encrypt(event.getState(), event.getPersister().getPropertyNames(), event.getEntity());
        return false;
    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent event) {
        fieldCrypto.encrypt(event.getState(), event.getPersister().getPropertyNames(), event.getEntity());
        return false;
    }
}
