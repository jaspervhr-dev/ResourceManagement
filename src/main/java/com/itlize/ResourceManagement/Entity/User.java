package com.itlize.ResourceManagement.Entity;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class User {

    @Id
    private String username;

    private String password;

    private String title;

    private String role;

    private String email;

    private String phoneNumber;

    @Timestamp
    private LocalDateTime timeCreated;

    @Timestamp
    private LocalDateTime lastUpdated;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Project> projectSet;

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public LocalDateTime getTimeCreated() {return timeCreated;}

    public LocalDateTime getLastUpdated() {return lastUpdated;}

    public Set<Project> getProjectSet() {return projectSet;}

    public void setTimeCreated(LocalDateTime timeCreated) {this.timeCreated = timeCreated;}

    public void setLastUpdated(LocalDateTime lastUpdated) {this.lastUpdated = lastUpdated;}

    public void setProjectSet(Set<Project> projectSet) {this.projectSet = projectSet;}
}
