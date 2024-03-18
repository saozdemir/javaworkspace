package com.sao.postit.config.security.fileencryption;

/**
 * @author saozd
 * @project com.sao.postit.config.security.fileencryption javaworkspace
 * @date 05 Mar 2024
 * <p>
 * @description:
 */

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileEncryption {

    public static void main(String[] args) throws Exception {
        String key = "128_BitKeyForAES";
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");

        String originalFile = "E:\\IdeaProjects\\javaworkspace\\postit\\src\\main\\java\\com\\sao\\postit\\config\\security\\fileencryption\\file.docx";
        String encryptedFile = "E:\\IdeaProjects\\javaworkspace\\postit\\src\\main\\java\\com\\sao\\postit\\config\\security\\fileencryption\\file_encrypt.cry";
        String decryptedFile = "E:\\IdeaProjects\\javaworkspace\\postit\\src\\main\\java\\com\\sao\\postit\\config\\security\\fileencryption\\file_decrypt.docx";

        encryptFile(secretKey, originalFile, encryptedFile);
        decryptFile(secretKey, encryptedFile, decryptedFile);
    }

    public static void encryptFile(SecretKeySpec keySpec, String inputFile, String outputFile) throws Exception {
        cipherFile(Cipher.ENCRYPT_MODE, keySpec, inputFile, outputFile);
    }

    public static void decryptFile(SecretKeySpec keySpec, String inputFile, String outputFile) throws Exception {
        cipherFile(Cipher.DECRYPT_MODE, keySpec, inputFile, outputFile);
    }

    private static void cipherFile(int cipherMode, SecretKeySpec keySpec, String inputFile, String outputFile) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(cipherMode, keySpec);

        try (FileInputStream input = new FileInputStream(inputFile);
             FileOutputStream output = new FileOutputStream(outputFile)) {
            if (cipherMode == Cipher.ENCRYPT_MODE) {
                try (CipherOutputStream cipherOut = new CipherOutputStream(output, cipher)) {
                    copy(input, cipherOut);
                }
            } else if (cipherMode == Cipher.DECRYPT_MODE) {
                try (CipherInputStream cipherIn = new CipherInputStream(input, cipher)) {
                    copy(cipherIn, output);
                }
            }
        }
    }

    private static void copy(InputStream in, OutputStream out) throws Exception {
        byte[] buffer = new byte[1024];
        int numRead;
        while ((numRead = in.read(buffer)) >= 0) {
            out.write(buffer, 0, numRead);
        }
    }
}

