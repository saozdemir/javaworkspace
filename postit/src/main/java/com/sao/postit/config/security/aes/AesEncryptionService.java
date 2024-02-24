package com.sao.postit.config.security.aes;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author saozd
 * @project com.sao.postit.config.security courseexample
 * 7.06.2023 Haz 2023
 * AES Encryption Algorithm
 */
public class AesEncryptionService {
    private static AesEncryptionService service;
    private SecretKeySpec secretKey;

    private AesEncryptionService() throws Exception {
        createKey();
    }

    private void createKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        secretKey = (SecretKeySpec) keyGenerator.generateKey();
    }

    public static AesEncryptionService getService() throws Exception {
        if (service == null) {
            synchronized (AesEncryptionService.class) {
                if (service == null) {
                    service = new AesEncryptionService();
                }
            }
        }
        return service;
    }

    public final String encrypt(String plaintext) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public final String decrypt(String ciphertext) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}
