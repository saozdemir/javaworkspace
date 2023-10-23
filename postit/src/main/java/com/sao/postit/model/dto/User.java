package com.sao.postit.model.dto;

import javax.persistence.*;
import java.util.*;

/**
 * @author saozd
 * @project com.sao.postit.model.dto courseexample
 * 3.06.2023 Haz 2023
 */
@Entity
@Table(name = "USER")
public class User {
    @SequenceGenerator(name = "user", sequenceName = "USER_ID_SEQ")
    @Id
    @GeneratedValue(generator = "user", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "USERNAME")//, unique = true
    private String userName;
    @Column(name = "PASSWORD")
    private String password;
    //    @OneToMany(
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL,
//            targetEntity = Group.class)
//    @JoinTable(
//            name = "GROUP_USER",
//            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
//            inverseJoinColumns = @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID")
//    )
//    //@MapKeyClass(Group.class)
//    @MapKeyColumn(name = "groups_key")
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            mappedBy = "members"
    )
    private Set<Team> teams = new HashSet<>();
    //private Map<Group, Integer> groups = new HashMap<>();


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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Team> getGroups() {
        return teams;
    }

    public void setGroups(Set<Team> groups) {
        this.teams = groups;
    }
}
