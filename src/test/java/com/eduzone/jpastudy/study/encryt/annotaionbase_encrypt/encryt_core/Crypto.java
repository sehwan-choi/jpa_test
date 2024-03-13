package com.eduzone.jpastudy.study.encryt.annotaionbase_encrypt.encryt_core;

public interface Crypto {

    String encrypt(String raw);

    String decrypt(String encodedText);
}
