package com.eduzone.jpastudy.study.listener_encryt.encryt_core;


import com.eduzone.jpastudy.study.listener_encryt.encryt_core.impl.AES256Crypto;
import com.eduzone.jpastudy.study.listener_encryt.encryt_core.impl.KeyNameBasedCryptoContextHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCryptoConfiguration {

    private final String aesKey = "A957D12D8F5B1265DB1E9CE46CB33123";

    public static final String USER_CRYPTO_NAME = "user_crypto";

    public static final String PAYMENT_CRYPTO_NAME = "payment_crypto";

    @Bean
    public CryptoContextHolder inMemoryFixedKeyContextHolder() {

        AES256Crypto defaultCrypto = new AES256Crypto(aesKey);
        AES256Crypto userCrypto = new AES256Crypto(aesKey);
        AES256Crypto paymentCrypto = new AES256Crypto(aesKey);

        return new KeyNameBasedCryptoContextHolder(defaultCrypto)
                .addCryptoContext(USER_CRYPTO_NAME, userCrypto)
                .addCryptoContext(PAYMENT_CRYPTO_NAME, paymentCrypto);


    }

}
