package com.marcel.malewski.checkersonlinebackend.player;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
   public PlayerService() {
   }

   public List<Player> findAllPlayers() {
//        return this.playerRepository.findAll();
      return null;
   }

   public Player findPlayerById(Long id) {
//        return this.playerRepository.findById(id)
//                .orElseThrow(() -> new PlayerNotFoundException(String.format(PLAYER_BY_ID_NOT_FOUND_MESSAGE, id)));
      return null;
   }

   public Player savePlayer(Player player) {
//        return this.playerRepository.save(player);
      return null;
   }

   public Player updatePlayer(Player player) {
//        return this.playerRepository.save(player);
      return null;
   }

   public void deletePlayerById(Long id) {
//        this.playerRepository.deleteById(id);
   }
}
