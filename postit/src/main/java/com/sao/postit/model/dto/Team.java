package com.sao.postit.model.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author saozd
 * @project com.sao.postit.model.dto courseexample
 * 3.06.2023 Haz 2023
 */
@Entity
@Table(name = "TEAM")
public class Team {
    @SequenceGenerator(name = "team", sequenceName = "TEAM_ID_SEQ")
    @Id
    @GeneratedValue(generator = "team", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            targetEntity = User.class)
    private Set members = new HashSet();
//    @OneToMany(
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL,
//            targetEntity = Message.class)
//    private List<Message> messages;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set getMembers() {
        return members;
    }

    public void setMembers(Set members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return name;
    }
}
