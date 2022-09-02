package com.marcel.malewski.checkersonlinebackend.player;

import java.util.List;
import java.util.Optional;

public interface PlayerDao {
   //Data Access Object
   List<Player> getAllPlayers();
   long postPlayer(Player player);
   long deletePlayer(long id);
   Optional<Player> selectPlayerById(long id);
}
