package com.sao.postit.app;

import com.sao.postit.config.database.DatabaseService;
import com.sao.postit.config.security.aes.AesEncryptionService;
import com.sao.postit.config.security.bcrypt.BcryptEncryptionService;
import com.sao.postit.config.security.sha256.SHA256EncryptionService;
import com.sao.postit.model.dto.Team;
import com.sao.postit.model.dto.User;
import org.mindrot.bcrypt.BCrypt;

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

        try {
            securityChecker();
            passwordCheckerBcrypt();
        } catch (Exception e) {
            System.out.println("Şifre kontrollerinde hata");
            e.printStackTrace();
        }

    }

    private static void passwordCheckerBcrypt() throws Exception {
        //Bcrypt ile sadece kullanıcı adı kontrolleri yapılacak
        String password1 = "Ahmet123";

        String encryptedPassword1DB = BcryptEncryptionService.getService().encryptPassword(password1);
        System.out.println(encryptedPassword1DB);

        String password2 = "Ahmet123";

        if(BcryptEncryptionService.getService().checkPassword(password2,encryptedPassword1DB)){
            System.out.println(BcryptEncryptionService.getService().encryptPassword(password2));
            System.out.println("Eşleşti");
        } else{
            System.out.println("Eşleşmedi");
        }



    }

    private static void securityChecker() {
        String message = "Yeni bir mesaj içeriği için yazılmış";

        try {
            String encryptedMessage = AesEncryptionService.getService().encrypt(message);
            System.out.println(encryptedMessage);

            String decryptedMessage = AesEncryptionService.getService().decrypt(encryptedMessage);
            System.out.println(decryptedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }

        String password1 = "Deneme123";
        String password2 = "Deneme1234";
        String password3 = "Deneme123";

        try {
            System.out.println(SHA256EncryptionService.getService().encryptPassword(password1));
            System.out.println(SHA256EncryptionService.getService().encryptPassword(password2));
            System.out.println(SHA256EncryptionService.getService().encryptPassword(password3));

            if (SHA256EncryptionService.getService().encryptPassword(password1).
                    equals(SHA256EncryptionService.getService().encryptPassword(password3))) {
                System.out.println("PASS");
            } else {
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
