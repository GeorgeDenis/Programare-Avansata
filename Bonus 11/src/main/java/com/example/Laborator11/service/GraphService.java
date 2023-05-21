package com.example.Laborator11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GraphService {
    private int nrPlayers;


    public void setNrPlayers(int nrPlayers){
        this.nrPlayers = nrPlayers;
    }
}
