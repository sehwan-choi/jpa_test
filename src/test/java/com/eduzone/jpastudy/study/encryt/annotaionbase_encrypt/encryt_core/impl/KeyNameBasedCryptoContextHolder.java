package com.eduzone.jpastudy.study.encryt.annotaionbase_encrypt.encryt_core.impl;

import com.eduzone.jpastudy.study.encryt.annotaionbase_encrypt.encryt_core.*;
import com.eduzone.jpastudy.study.encryt.annotaionbase_encrypt.encryt_core.exception.CryptoException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class KeyNameBasedCryptoContextHolder implements CryptoContextHolder {

    private final Map<String, Crypto> cryptoContextMap = new HashMap<>();

    private final Crypto defaultCrypto;

    public KeyNameBasedCryptoContextHolder(Crypto defaultCrypto) {
        this.defaultCrypto = defaultCrypto;
    }

    @Override
    public Optional<Crypto> getCryptoWithOptional(String cryptoKeyName) {
        return Optional.ofNullable(cryptoContextMap.get(cryptoKeyName));
    }

    @Override
    public Crypto getCrypto(String cryptoKey) {
        return getCryptoWithOptional(cryptoKey)
                .orElseThrow(() -> new CryptoException("No encrypt key was found! cryptoKey : \"" + cryptoKey + "\""));
    }

    @Override
    public Crypto getCryptoIfNullGetDefault(String cryptoKey) {
        return this.getCryptoWithOptional(cryptoKey).orElseGet(this::getDefaultCrypto);
    }

    @Override
    public Crypto getDefaultCrypto() {
        return this.defaultCrypto;
    }

    @Override
    public CryptoContextHolder addCryptoContext(String cryptoKeyName, Crypto context) {
        this.cryptoContextMap.put(cryptoKeyName, context);
        return this;
    }
}
