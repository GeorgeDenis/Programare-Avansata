package com.example.Laborator11.controller;

import com.example.Laborator11.dto.GameResponseDto;
import com.example.Laborator11.service.GraphService;
import com.example.Laborator11.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/graph")
public class GraphController {
    private final GraphService graphService;
    private final PlayerService playerService;

    public GraphController(GraphService graphService, PlayerService playerService) {
        this.graphService = graphService;
        this.playerService = playerService;
    }
    @GetMapping
    public ResponseEntity<String> getGames(){
        graphService.setNrPlayers(playerService.count());
        System.out.println(playerService.count());
        return ResponseEntity.ok("da");

    }
}
