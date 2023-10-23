package com.sao.postit.config.security;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author saozd
 * @project com.sao.postit.config.security courseexample
 * 7.06.2023 Haz 2023
 * AES Encryption Algorithm
 */
public class DataEncryptionService {
    private static DataEncryptionService service;
    private SecretKeySpec secretKey;

    private DataEncryptionService() throws Exception {
        createKey();
    }

    private void createKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        secretKey = (SecretKeySpec) keyGenerator.generateKey();
    }

    public static DataEncryptionService getService() throws Exception {
        if (service == null) {
            synchronized (DataEncryptionService.class) {
                if (service == null) {
                    service = new DataEncryptionService();
                }
            }
        }
        return service;
    }

    public String encrypt(String plaintext) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt(String ciphertext) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}
