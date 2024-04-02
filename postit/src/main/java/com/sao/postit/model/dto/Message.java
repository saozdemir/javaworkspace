package com.sao.postit.model.dto;

import javax.persistence.*;
import java.sql.Blob;

/**
 * @author saozd
 * @project com.sao.postit.model.dto courseexample
 * 3.06.2023 Haz 2023
 */
@Entity
@Table(name = "MESSAGE")
public class Message {
    @SequenceGenerator(name = "message", sequenceName = "MESSAGE_ID")
    @Id
    @GeneratedValue(generator = "message", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Lob
    @Column(name = "FILE")
    private Blob file;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Blob getFile() {
        return file;
    }

    public void setFile(Blob file) {
        this.file = file;
    }
}
