package com.example.Laborator11.controller;

import com.example.Laborator11.model.Player;
import com.example.Laborator11.service.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping()
    public List<Player> getPlayer(){
        return playerService.findAll();
    }
}
