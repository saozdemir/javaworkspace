package com.sao.postit.app;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.sao.postit.config.database.DatabaseService;
import com.sao.postit.config.security.DataEncryptionService;
import com.sao.postit.config.security.PasswordEncryptionService;
import com.sao.postit.model.dto.Team;
import com.sao.postit.model.dto.User;
import com.sao.postit.view.password.FrmPassword;
import org.hibernate.boot.archive.scan.internal.ScanResultImpl;

import javax.crypto.*;
import javax.swing.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author saozd
 * @project com.sao.postit.app courseexample
 * 3.06.2023 Haz 2023
 */
public class PostItApp {
    public static void main(String[] args) {
//        try {
//            UIManager.setLookAndFeel(new FlatMacLightLaf());
//        } catch (UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new FrmPassword();
//
//            }
//        });

        //insertUpdateChecker(); pass
        //listChecker(); pass

        securityChecker();

    }

    private static void securityChecker() {
        String message = "Yeni bir mesaj içeriği için yazılmış";

        try {
            String encryptedMessage = DataEncryptionService.getService().encrypt(message);
            System.out.println(encryptedMessage);

            String decryptedMessage = DataEncryptionService.getService().decrypt(encryptedMessage);
            System.out.println(decryptedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }

        String password1 = "Deneme123";
        String password2 = "Deneme1234";
        String password3 = "Deneme123";

        try {
            System.out.println(PasswordEncryptionService.getService().encryptPassword(password1));
            System.out.println(PasswordEncryptionService.getService().encryptPassword(password2));
            System.out.println(PasswordEncryptionService.getService().encryptPassword(password3));

            if(PasswordEncryptionService.getService().encryptPassword(password1).
                    equals(PasswordEncryptionService.getService().encryptPassword(password3))){
                System.out.println("PASS");
            }else {
                System.out.println("FAIL");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


//            String decryptedText = new String(decryptedBytes);

//            System.out.println("Şifrelenmiş Metin: " + new String(encryptedBytes));
//            System.out.println("Şifre Çözülmüş Metin: " + decryptedText);

    }

    private static void listChecker() {
        DatabaseService<Team> service = new DatabaseService();
        Team group = new Team();
        List<Team> teamList = service.queryList(Team.class, group);
    }

    private static void insertUpdateChecker() {
        User user = new User();
        user.setName("Ahmet");
        user.setSurname("Özdemir");
        user.setUserName("AOZDEMIR3");
        user.setPassword("1234");

//        Team group = new Team();
//        group.setName("Deneme");


//        Team group2 = new Team();
//        group2.setName("GUBİK");
//        user.getGroups().add(group2);


        //Yeni Grup Ekleme
        DatabaseService<User> service = new DatabaseService();
//        group2.getMembers().add(service.queryObject(User.class, 1L));
//        service.insertObject(group2);

        user = service.queryObject(User.class, 52L);
        user.setSurname("ÖZDEMİR");
        service.updateObject(user, 52L);

        ///////2
//        user.getGroups().add(group2);
//        service.insertObject(user);
        /////////
//        service.updateObject(user);
//        if (service.insertObject(user)) {
//            service.insertObject(group);
//            System.out.println("Başarılı");
//        } else {
//            System.out.println("Olmadı :(");
//        }

//        User newUser = service.queryObject(User.class, 52L);
//        System.out.println("User name: " + newUser.getUserName());
//        System.out.println(newUser.getGroups().size());
////
//        newUser.setName("Seyit");
//        service.updateObject(newUser);
//        User newUser2 = service.queryObject(User.class, 102L);
//        System.out.println(newUser2.getName());
    }
}
