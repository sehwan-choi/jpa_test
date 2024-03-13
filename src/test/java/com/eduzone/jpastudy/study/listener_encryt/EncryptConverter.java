package com.eduzone.jpastudy.study.listener_encryt;

import jakarta.persistence.AttributeConverter;
import org.springframework.beans.factory.annotation.Value;

public class EncryptConverter implements AttributeConverter<String, String> {

    @Value("${common.aes.key}")
    private String aesKey;

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return AES256CryptoHelper.encrypt(attribute, aesKey);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return AES256CryptoHelper.decrypt(dbData, aesKey);
    }
}
