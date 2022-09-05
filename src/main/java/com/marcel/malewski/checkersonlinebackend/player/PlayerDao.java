package com.marcel.malewski.checkersonlinebackend.player;

import java.util.List;
import java.util.Optional;

public interface PlayerDao {
   //Data Access Object
   List<Player> getAllPlayers();
   Optional<Player> getPlayerById(long id);
   long postPlayer(Player player);
   void deletePlayer(long id);
}
