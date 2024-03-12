package com.eduzone.jpastudy.study.listener_encryt.spring_encryt.impl;


import com.eduzone.jpastudy.study.listener_encryt.encryt_core.Crypto;
import com.eduzone.jpastudy.study.listener_encryt.encryt_core.CryptoContextHolder;
import com.eduzone.jpastudy.study.listener_encryt.encryt_core.exception.CryptoException;
import com.eduzone.jpastudy.study.listener_encryt.spring_encryt.Encrypted;
import com.eduzone.jpastudy.study.listener_encryt.spring_encryt.FieldDecrypter;
import com.eduzone.jpastudy.study.listener_encryt.spring_encryt.FieldCrypto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

@Component
@RequiredArgsConstructor
public class FieldAnnotationBasedCrypto implements FieldCrypto {

    private final CryptoContextHolder cryptoContextHolder;

    @Override
    public void decrypt(Object entity) {
        ReflectionUtils.doWithFields(entity.getClass(), field -> decryptField(field, entity), (field) -> true);
    }

    @Override
    public void encrypt(Object[] state, String[] propertyNames, Object entity) {
        ReflectionUtils.doWithFields(entity.getClass(), field -> encryptField(field, state, propertyNames, entity), (field) -> true);
    }

    public int getPropertyIndex(String name, String[] propertyNames) {
        for (int i = 0; i < propertyNames.length; i ++) {
            if (name.equals(propertyNames[i])) {
                return i;
            }
        }
        throw new CryptoException("No property was found for name \"" + name + "\"");
    }

    private void decryptField(Field field, Object entity) {
        Encrypted encryptedOption = AnnotationUtils.findAnnotation(field, Encrypted.class);
        if (encryptedOption != null) {
            field.setAccessible(true);
            Object value = ReflectionUtils.getField(field, entity);

            if (value != null) {
                if (!(value instanceof String)) {
                    throw new CryptoException("\"" + field.getName() + "\" is non-string field.");
                }

                Crypto crypto = getCrypto(encryptedOption.cryptoKey());

                ReflectionUtils.setField(field, entity, crypto.decrypt(value.toString()));
            }
        }
    }

    private void encryptField(Field field, Object[] state, String[] propertyNames, Object entity) {
        Encrypted encryptedOption = AnnotationUtils.findAnnotation(field, Encrypted.class);
        if (encryptedOption != null) {
            int propertyIndex = getPropertyIndex(field.getName(), propertyNames);
            Object currentValue = state[propertyIndex];

            if (currentValue != null) {
                if (!(currentValue instanceof String)) {
                    throw new IllegalStateException("\"" + field.getName() + "\" is non-string field.");
                }

                Crypto crypto = getCrypto(encryptedOption.cryptoKey());

                String encrypt = crypto.encrypt(currentValue.toString());
                state[propertyIndex] = encrypt;

                field.setAccessible(true);
                ReflectionUtils.setField(field, entity, encrypt);
            }
        }
    }

    private Crypto getCrypto(String cryptoKey) {
        return StringUtils.hasText(cryptoKey) ?
                cryptoContextHolder.getCrypto(cryptoKey) :
                cryptoContextHolder.getDefaultCrypto();
    }
}
