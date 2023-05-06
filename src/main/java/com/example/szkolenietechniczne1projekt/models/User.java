package com.example.szkolenietechniczne1projekt.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column (name = "password")
    private String password;
    @Column(name = "hall_id")
    private Long hallId;
    @Column(name = "group_id")
    private Long groupId;
    @Column(name = "trainer_id")
    private Long trainerId;
    @Column(name = "role")
    private Role role;

    public User() {
    }

    public User(String username, String password, Long hallId, Long groupId, Long trainerId, Role role) {
        this.username = username;
        this.password = password;
        this.hallId = hallId;
        this.groupId = groupId;
        this.trainerId = trainerId;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }

}
