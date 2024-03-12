package com.eduzone.jpastudy.study.listener_encryt.spring_encryt;

public interface FieldCrypto {

    void encrypt(Object[] state, String[] propertyNames, Object entity);

    void decrypt(Object entity);
}
