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
      return this.playerDao.getAllPlayers();
   }

   public Player getPlayerById(long id) {
      return this.playerDao.getPlayerById(id)
              .orElseThrow(() -> new PlayerNotFoundException(String.format(PLAYER_BY_ID_NOT_FOUND_MESSAGE, id)));
   }

   public Player postPlayer(Player player) {
      long newPlayerId = this.playerDao.postPlayer(player);
      //co jest jak dane są niepoprawne
      //testowanie parametrow ? playera ? chyba bez sensu
      player.setId(newPlayerId);

      return player;
   }

   public Player putPlayer(Player player) {
      //czy to sprawdzanie jest potrzebne ?
//      if(this.playerDao.getPlayerById(player.getId()).isEmpty())
//         throw new PlayerNotFoundException(String.format(PLAYER_BY_ID_NOT_FOUND_MESSAGE, player.getId()));
      return null;
   }

   public void deletePlayerById(long id) {
      if(this.playerDao.getPlayerById(id).isEmpty())
         throw new PlayerNotFoundException(String.format(PLAYER_BY_ID_NOT_FOUND_MESSAGE, id));

      this.playerDao.deletePlayer(id);
   }
}
