package com.marcel.malewski.checkersonlinebackend.player;

import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

@Component
public class PlayerDataAccessService implements PlayerDao{
   private final JdbcTemplate jdbcTemplate;

   public PlayerDataAccessService(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
   }

   @Override
   public List<Player> selectAllPlayers() {
      return null;
   }

   @Override
   public int insertPlayer(Player player) {
      return 0;
   }

   @Override
   public int deletePlayer(int id) {
      return 0;
   }

   @Override
   public Optional<Player> selectPlayerById(int id) {
      return Optional.empty();
   }
}
