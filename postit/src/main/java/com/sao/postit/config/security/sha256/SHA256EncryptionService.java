package com.sao.postit.config.security.sha256;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @author saozd
 * @project com.sao.postit.config.security courseexample
 * 7.06.2023 Haz 2023
 * SHA-256 Encryption Algorithm
 */
public class SHA256EncryptionService{
    private static SHA256EncryptionService service;
    MessageDigest digest;

    private SHA256EncryptionService() throws Exception {
        createDigest();
    }

    private void createDigest() throws Exception {
        digest = MessageDigest.getInstance("SHA-256");
    }

    public static SHA256EncryptionService getService() throws Exception {
        if (service == null) {
            synchronized (SHA256EncryptionService.class) {
                if (service == null) {
                    service = new SHA256EncryptionService();
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
