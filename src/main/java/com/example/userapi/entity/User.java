package com.example.userapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.mapstruct.control.MappingControl;

import javax.management.relation.Role;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    @NotBlank(message = "Password is Required")
    private String password;
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Authority role;

    public User(){}

    public User(long id, String username, String password, boolean isActive, Authority role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Authority getRole() {
        return role;
    }

    public void setRole(Authority role) {
        this.role = role;
    }
}
