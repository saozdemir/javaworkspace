package com.sao.postit.config.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author saozd
 * @project com.sao.postit.config.security courseexample
 * 7.06.2023 Haz 2023
 * SHA-256 Encryption Algorithm
 */
public class PasswordEncryptionService {
    private static PasswordEncryptionService service;
    MessageDigest digest;

    private PasswordEncryptionService() throws Exception {
        createDigest();
    }

    private void createDigest() throws Exception {
        digest = MessageDigest.getInstance("SHA-256");
    }

    public static PasswordEncryptionService getService() throws Exception {
        if (service == null) {
            synchronized (DataEncryptionService.class) {
                if (service == null) {
                    service = new PasswordEncryptionService();
                }
            }
        }
        return service;
    }

    public String encryptPassword(String password) {
        byte[] hashBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        String encryptedPassword = bytesToHex(hashBytes);
        return encryptedPassword;
    }

    private String bytesToHex(byte[] hashBytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : hashBytes) {
            result.append(String.format("%02X", b));
        }
        return result.toString();
    }


}
