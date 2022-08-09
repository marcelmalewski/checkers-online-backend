package com.marcel.malewski.checkersonlinebackend.player;

import com.marcel.malewski.checkersonlinebackend.exception.PlayerNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.marcel.malewski.checkersonlinebackend.consts.ChobConstants.PLAYER_BY_ID_NOT_FOUND_MESSAGE;

@Service
public class PlayerService {
   private final PlayerDao playerDao;

   public PlayerService(PlayerDao playerDao) {
      this.playerDao = playerDao;
   }

   public List<Player> getAllPlayers() {
      return this.playerDao.selectAllPlayers();
   }

   public Player getPlayerById(int id) {
      return this.playerDao.selectPlayerById(id)
              .orElseThrow(() -> new PlayerNotFoundException(String.format(PLAYER_BY_ID_NOT_FOUND_MESSAGE, id)));
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
