package com.eduzone.jpastudy.study.encryt.annotaionbase_encrypt.spring_encryt;

public interface FieldCrypto {

    void encrypt(Object[] state, String[] propertyNames, Object entity);

    void decrypt(Object entity);
}
