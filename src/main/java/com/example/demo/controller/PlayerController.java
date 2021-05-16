package com.example.demo.controller;

import com.example.demo.CsvUtilFile;
import com.example.demo.player.Player;
import com.example.demo.repository.PlayerReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Controller
public class PlayerController {

    @Autowired
    private PlayerReactiveRepository playerReactiveRepository;

    @GetMapping("/players-reactive")
    public String playersReactive(Model model)
    {
        Flux<Player> userFlux = playerReactiveRepository.findAll();
        model.addAttribute("players", new ReactiveDataDriverContextVariable(userFlux, 1));
        return "players";
    }

    @GetMapping("/players")
    public String playersSinMongo(Model model)
    {
        List<Player> userFlux = CsvUtilFile.getPlayers();
        model.addAttribute("players", userFlux);
        return "players";
    }
}
