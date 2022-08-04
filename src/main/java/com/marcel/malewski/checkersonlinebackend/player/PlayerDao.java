package com.marcel.malewski.checkersonlinebackend.player;

import java.util.List;
import java.util.Optional;

public interface PlayerDao {
   //Data Access Object
   List<Player> selectAllPlayers();
   int insertPlayer(Player player);
   int deletePlayer(int id);
   Optional<Player> selectPlayerById(int id);
}
