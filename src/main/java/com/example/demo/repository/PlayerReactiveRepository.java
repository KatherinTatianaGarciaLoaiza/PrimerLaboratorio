package com.example.demo.repository;

import com.example.demo.player.Player;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PlayerReactiveRepository extends ReactiveCrudRepository<Player, String>{
}