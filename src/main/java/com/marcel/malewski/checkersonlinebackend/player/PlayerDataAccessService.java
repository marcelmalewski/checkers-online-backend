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
      var sql = """
              SELECT id, nickname, password, playersRoomId
              FROM player
              LIMIT 100;
              """;
      return jdbcTemplate.query(sql, new PlayerRowMapper());
   }

   @Override
   public int insertPlayer(Player player) {
      var sql = """
              INSERT INTO player(nickname, password, playersRoomId)
              VALUES (?, ?, ?);
              """;
      return jdbcTemplate.update(sql, player.nickname(), player.password(), player.playersRoomId());
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
