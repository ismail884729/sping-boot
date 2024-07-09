package com.ismail.sports.controller;

import com.ismail.sports.model.Player;
import com.ismail.sports.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return ResponseEntity.ok().body(players);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") Long id) {
        Optional<Player> player = playerService.getPlayerById(id);
        return player.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        Player savedPlayer = playerService.savePlayer(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlayer);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable("id") Long id, @RequestBody Player player) {
        Optional<Player> existingPlayerOptional = playerService.getPlayerById(id);
        if (existingPlayerOptional.isPresent()) {
            Player existingPlayer = existingPlayerOptional.get();
//            existingPlayer.setPlayerName(player.getPlayerName());
//            existingPlayer.setPosition(player.getPosition());
//            existingPlayer.setJerseyNumber(player.getJerseyNumber());
//            existingPlayer.setPlayerName(player.getPlayerName());
            Player updatedPlayer = playerService.savePlayer(existingPlayer);
            return ResponseEntity.ok().body(updatedPlayer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable("id") Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }
}
