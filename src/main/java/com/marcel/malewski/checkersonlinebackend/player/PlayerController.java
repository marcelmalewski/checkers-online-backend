package com.marcel.malewski.checkersonlinebackend.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/v1/players")
public class PlayerController {
   //filtruje z haseł czy kiedykolwiek do czegoś potrzebuje hasła
   private final PlayerService playerService;

   @Autowired
   public PlayerController(PlayerService playerService) {
      this.playerService = playerService;
   }

   @GetMapping
   public ResponseEntity<List<Player>> findAllPlayers() {
      List<Player> players =  this.playerService.findAllPlayers();
      return new ResponseEntity<>(players, HttpStatus.OK);
   }

   @GetMapping(path = "/{id}")
   public ResponseEntity<Player> findPlayerById(@PathVariable("id") Long id) {
      Player player = this.playerService.findPlayerById(id);
      return new ResponseEntity<>(player, HttpStatus.OK);
   }

   @PostMapping
   public ResponseEntity<Player> savePlayer(@RequestBody Player player) {
      Player savedPlayer = this.playerService.savePlayer(player);
      return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
   }

   @PutMapping
   public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
      Player updatedPlayer = this.playerService.updatePlayer(player);
      return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
   }

   @DeleteMapping(path = "/{id}")
   public ResponseEntity<Player> deletePlayer(@PathVariable("id") Long id) {
      this.playerService.deletePlayerById(id);
      return new ResponseEntity<>(HttpStatus.OK);
   }
}
