package com.example.userapi.entity;

import jakarta.persistence.*;

import java.util.Scanner;

@Entity
@Table(name = "role")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String name;

    public Authority(){}

    public Authority(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
