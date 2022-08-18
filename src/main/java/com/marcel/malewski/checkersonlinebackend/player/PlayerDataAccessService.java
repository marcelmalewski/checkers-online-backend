package com.marcel.malewski.checkersonlinebackend.player;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class PlayerDataAccessService implements PlayerDao{
   private final JdbcTemplate jdbcTemplate;

   public PlayerDataAccessService(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
   }

   @Override
   public List<Player> selectAllPlayers() {
      String sql = """
              SELECT id, nickname, password, playersRoomId
              FROM player
              LIMIT 100;
              """;
      return jdbcTemplate.query(sql, new PlayerRowMapper());
   }

   @Override
   public long insertPlayer(Player player) {
      String sql = """
              INSERT INTO player(nickname, password, playersRoomId)
              VALUES (?, ?, ?);
              """;
      KeyHolder keyHolder = new GeneratedKeyHolder();

      jdbcTemplate.update(connection -> {
         PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         ps.setString(1, player.getNickname());
         ps.setString(2, player.getPassword());

         if(Objects.isNull(player.getPlayersRoomId())) {
            ps.setNull(3, Types.NULL);
         } else {
            ps.setLong(3, player.getPlayersRoomId());
         }

         return ps;
      }, keyHolder);

      return (long) Objects.requireNonNull(keyHolder.getKeys()).get("id");
   }

   @Override
   public long deletePlayer(long id) {
      return 0;
   }

   @Override
   public Optional<Player> selectPlayerById(long id) {
      return Optional.empty();
   }
}
