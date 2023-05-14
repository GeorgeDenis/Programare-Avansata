package com.example.Laborator11.model;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;

    public Player() {
    }

    public Player(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
