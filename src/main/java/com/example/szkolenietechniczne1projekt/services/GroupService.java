package com.example.szkolenietechniczne1projekt.services;


import com.example.szkolenietechniczne1projekt.services.main.MainService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GroupService extends MainService {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("unit");


}