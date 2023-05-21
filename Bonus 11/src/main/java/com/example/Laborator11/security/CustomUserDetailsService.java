package com.example.Laborator11.security;

import com.example.Laborator11.model.Player;
import com.example.Laborator11.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class CustomUserDetailsService implements UserDetailsService {
    private final PlayerRepository usersRepository;

    @Autowired
    public CustomUserDetailsService(PlayerRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Player loadUserByUsername(String name) throws UsernameNotFoundException {
        Player user = usersRepository.getByName(name);
        if (user == null)
            throw new UsernameNotFoundException("Username not found");
        return new Player(user.getName(), user.getPassword());
    }
}
