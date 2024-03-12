package com.eduzone.jpastudy.study.listener_encryt.encryt_core;

import java.util.Optional;

public interface CryptoContextHolder {

    Optional<Crypto> getCryptoWithOptional(String cryptoKey);

    Crypto getCrypto(String cryptoKey);

    Crypto getCryptoIfNullGetDefault(String cryptoKey);

    Crypto getDefaultCrypto();

    CryptoContextHolder addCryptoContext(String cryptoKey, Crypto context);
}
