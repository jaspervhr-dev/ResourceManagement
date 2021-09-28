package com.itlize.ResourceManagement.Entity;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class User {

    @Id
    private String user_name;

    private String password;

    private String title;

    private String role;

    private String email;

    private String phone_number;

    @Timestamp
    private LocalDateTime time_created;

    @Timestamp
    private LocalDateTime last_updated;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Project> projectSet;

    public String getUsername() {return user_name;}

    public void setUsername(String username) {this.user_name = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPhoneNumber() {return phone_number;}

    public void setPhoneNumber(String phoneNumber) {this.phone_number = phoneNumber;}

    public LocalDateTime getTimeCreated() {return time_created;}

    public LocalDateTime getLastUpdated() {return last_updated;}

    public Set<Project> getProjectSet() {return projectSet;}

    public void setTimeCreated(LocalDateTime timeCreated) {this.time_created = timeCreated;}

    public void setLastUpdated(LocalDateTime lastUpdated) {this.last_updated = lastUpdated;}

    public void setProjectSet(Set<Project> projectSet) {this.projectSet = projectSet;}
}
