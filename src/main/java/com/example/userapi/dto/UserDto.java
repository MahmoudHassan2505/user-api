package com.example.userapi.dto;

public class UserDto {

    private long id;
    private String username;
    private boolean isActive;
    private boolean isAdmin;

    public UserDto(){}

    public UserDto(long id, String username, boolean isActive, boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.isActive = isActive;
        this.isAdmin = isAdmin;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
