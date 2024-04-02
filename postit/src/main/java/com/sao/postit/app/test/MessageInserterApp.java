package com.sao.postit.app.test;

import com.sao.postit.config.database.DatabaseConfigList;
import com.sao.postit.config.database.DatabaseService;
import com.sao.postit.model.dto.Message;
import org.hibernate.Hibernate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;

/**
 * @author saozd
 * @project com.sao.postit.app javaworkspace
 * @date 03 Apr 2024
 * <p>
 * @description:
 */
public class MessageInserterApp {
    public static void main(String[] args) {
        try {
            DatabaseService<Message> service = new DatabaseService<>();
            File file = new File("E:\\IdeaProjects\\javaworkspace\\postit\\src\\main\\java\\com\\sao\\postit\\config\\security\\fileencryption\\file.docx");
            long fileSize = file.length();
            InputStream inputStream = new FileInputStream(file);
            Blob blob = Hibernate.getLobCreator(service.getSession()).createBlob(inputStream, fileSize);

            Message message = new Message();
            message.setFile(blob);
            service.insertObject(message);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
