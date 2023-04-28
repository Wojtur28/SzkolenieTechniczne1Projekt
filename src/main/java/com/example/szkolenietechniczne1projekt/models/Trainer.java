/*
package com.example.szkolenietechniczne1projekt.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trainers")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
    private List<Group> groups;


}
*/
