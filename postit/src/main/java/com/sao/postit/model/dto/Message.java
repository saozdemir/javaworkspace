package com.sao.postit.model.dto;

import javax.persistence.*;

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
}
