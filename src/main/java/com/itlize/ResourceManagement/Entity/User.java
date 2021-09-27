package com.itlize.ResourceManagement.Entity;

import jdk.jfr.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private String user_name;

    private String password;

    private String title;

    private String role;

    @Timestamp
    private int time_created;

    @Timestamp
    private int last_updated;
}
