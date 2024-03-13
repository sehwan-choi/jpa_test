package com.eduzone.jpastudy.study.encryt.convert_encrypt;

import com.eduzone.jpastudy.study.encryt.annotaionbase_encrypt.encryt_core.exception.CryptoException;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AES256CryptoHelper {

    public static String encrypt(String raw, String aesKey) {
        if (raw == null || raw.isBlank() || raw.isEmpty()) {
            throw new CryptoException("AESHexEncrypt input raw text is empty(blank) or null");
        }
        try {
            byte[] keyBytes = Hex.decodeHex(aesKey.toCharArray());

            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] encrypted = cipher.doFinal(raw.getBytes());

            StringBuilder sb = new StringBuilder(encrypted.length * 2);
            String hexNumber;

            for (byte b : encrypted) {
                hexNumber = "0" + Integer.toHexString(0xff & b);
                sb.append(hexNumber.substring(hexNumber.length() - 2));
            }

            return sb.toString();
        } catch (DecoderException | NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException | InvalidKeyException e) {
            throw new CryptoException("AESHexEncrypt throws exception " + e.getMessage(), e);
        }
    }

    public static String decrypt(String encodedText, String aesKey) {
        if (encodedText == null || encodedText.isEmpty() || encodedText.isBlank()) {
            throw new CryptoException("AESHexDecrypt input encoded text is empty(blank) or null");
        }
        try {
            byte[] keyBytes = Hex.decodeHex(aesKey.toCharArray());

            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

            //16진수 문자열을 byte로 변환
            byte[] byteArray = new byte[encodedText.length() /2 ];

            for(int i=0; i<byteArray.length; i++){
                byteArray[i] = (byte) Integer.parseInt(encodedText.substring(2 * i, 2*i+2), 16);
            }

            byte[] original = cipher.doFinal(byteArray);

            return new String(original);
        } catch (DecoderException | NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | InvalidKeyException | BadPaddingException e) {
            throw new CryptoException("AESHexDecrypt throws exception " + e.getMessage(), e);
        }
    }
}
