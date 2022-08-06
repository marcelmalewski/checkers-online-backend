package com.marcel.malewski.checkersonlinebackend.player;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
   private final PlayerDao playerDao;

   public PlayerService(PlayerDao playerDao) {
      this.playerDao = playerDao;
   }

   public List<Player> getAllPlayers() {
      return this.playerDao.selectAllPlayers();
   }

   public Player getPlayerById(Long id) {
//        return this.playerRepository.findById(id)
//                .orElseThrow(() -> new PlayerNotFoundException(String.format(PLAYER_BY_ID_NOT_FOUND_MESSAGE, id)));
      return null;
   }

   public Player postPlayer(Player player) {
        int result = this.playerDao.insertPlayer(player);
        return player;
   }

   public Player putPlayer(Player player) {
//        return this.playerRepository.save(player);
      return null;
   }

   public void deletePlayerById(Long id) {
//        this.playerRepository.deleteById(id);
   }
}
