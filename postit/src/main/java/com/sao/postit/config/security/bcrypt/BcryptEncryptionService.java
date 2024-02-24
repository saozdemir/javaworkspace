package com.sao.postit.config.security.bcrypt;

import org.mindrot.bcrypt.BCrypt;

/**
 * @author saozd
 * @project com.sao.postit.config.security.bcrypt javaworkspace
 * @date 10.11.2023 Kas 2023
 * <p>
 * @description:
 */
public class BcryptEncryptionService {
    private static BcryptEncryptionService service;

    private BcryptEncryptionService() {
    }

    public static BcryptEncryptionService getService() throws Exception {
        if (service == null) {
            synchronized (BcryptEncryptionService.class) {
                if (service == null) {
                    service = new BcryptEncryptionService();
                }
            }
        }
        return service;
    }

    public final String encryptPassword(String password) {
        String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        return encryptedPassword;
    }

    public final boolean checkPassword(String password, String encryptedPassword) {
        if (BCrypt.checkpw(password, encryptedPassword)) {
            return true;
        }
        return false;
    }
}
