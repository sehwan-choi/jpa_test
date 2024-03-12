package com.eduzone.jpastudy.study.listener_encryt.encryt_core;

public interface Crypto {

    String encrypt(String raw);

    String decrypt(String encodedText);
}
