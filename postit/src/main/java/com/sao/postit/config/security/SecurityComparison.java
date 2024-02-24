package com.sao.postit.config.security;

import com.sao.postit.config.security.aes.AesEncryptionService;
import com.sao.postit.config.security.bcrypt.BcryptEncryptionService;
import com.sao.postit.config.security.sha256.SHA256EncryptionService;

/**
 * @author saozd
 * @project com.sao.postit.config.security javaworkspace
 * @date 13 Ara 2023
 * <p>
 * @description:
 */
public class SecurityComparison {
    private static final String INPUT_TEXT = "abc1234";
    private static Long startTime;
    private static Long endTime;
    private static Long duration;
    public static void main(String[] args) {
        try {
            //AES
            startTime = System.nanoTime();
            String aes = AesEncryptionService.getService().encrypt(INPUT_TEXT);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            System.out.println("AES Şifreleme Giriş Metni: " + INPUT_TEXT);
            System.out.println("AES İle Şifrelenmiş Metin: " + aes);
            System.out.println("AES Şifreleme Süresi: " + duration + " ms");

            //SHA 256
            startTime = System.nanoTime();
            String sha256 = SHA256EncryptionService.getService().encryptPassword(INPUT_TEXT);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            System.out.println("SHA 256 Şifreleme Giriş Metni: " + INPUT_TEXT);
            System.out.println("SHA 256 İle Şifrelenmiş Metin: " + sha256);
            System.out.println("SHA 256 Şifreleme Süresi: " + duration + " ms");

            //Bcrypt
            startTime = System.nanoTime();
            String bcrypt = BcryptEncryptionService.getService().encryptPassword(INPUT_TEXT);
            endTime = System.nanoTime();
            duration = (endTime - startTime) / 1000000;
            System.out.println("Bcrypt Şifreleme Giriş Metni: " + INPUT_TEXT);
            System.out.println("Bcrypt İle Şifrelenmiş Metin: " + bcrypt);
            System.out.println("Bcrypt Şifreleme Süresi: " + duration + " ms");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
