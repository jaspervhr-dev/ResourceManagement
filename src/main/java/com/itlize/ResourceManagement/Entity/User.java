package com.itlize.ResourceManagement.Entity;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "user_name")
    private String username;

    private String password;

    private String title;

    private String role;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Timestamp
    @Column(name = "time_created")
    private LocalDateTime timeCreated;

    @Timestamp
    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "owner",cascade = CascadeType.ALL)
    private Set<Project> projectSet;

    public String getUsername() {return userName;}

    public void setUsername(String username) {this.userName = username;}

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
