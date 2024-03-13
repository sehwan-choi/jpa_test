package com.eduzone.jpastudy.study.encryt.annotaionbase_encrypt.encryt_core.exception;

public class CryptoException extends RuntimeException {

    public CryptoException(String message, Throwable cause) {
        super(message, cause);
    }

    public CryptoException(String message) {
        super(message);
    }
}
