package com.marcel.malewski.checkersonlinebackend.player;

import com.marcel.malewski.checkersonlinebackend.exception.NicknameIsAlreadyUsed;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.marcel.malewski.checkersonlinebackend.consts.ChobConstants.NICKNAME_IS_ALREADY_USED_MESSAGE;

@Repository
public class PlayerDataAccessService implements PlayerDao{
   private final JdbcTemplate jdbcTemplate;

   public PlayerDataAccessService(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
   }

   @Override
   public List<Player> getAllPlayers() {
      String sql = """
              SELECT id, nickname, password, playersRoomId
              FROM player
              LIMIT 100;
              """;
      return jdbcTemplate.query(sql, new PlayerRowMapper());
   }

   @Override
   public Optional<Player> getPlayerById(long id) {
      String sql = """
              SELECT id, nickname, password, playersRoomId
              FROM player
              WHERE id = ?
              """;
      return jdbcTemplate.query(sql, new PlayerRowMapper(), id)
              .stream()
              .findFirst();
   }

   @Override
   public long postPlayer(Player player) {
      String sql = """
              INSERT INTO player(nickname, password, playersRoomId)
              VALUES (?, ?, ?);
              """;
      KeyHolder keyHolder = new GeneratedKeyHolder();

      try {
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
      } catch (DuplicateKeyException e) {
         throw new NicknameIsAlreadyUsed(String.format(NICKNAME_IS_ALREADY_USED_MESSAGE, player.getNickname()));
      }

      return (long) Objects.requireNonNull(keyHolder.getKeys()).get("id");
   }

   @Override
   public void deletePlayer(long id) {
      String sql = """
              DELETE FROM player
              WHERE id = ?
              """;
      //query is for get data from table
      //if we wany to modify we say update()
      //this will return number of rows affected
      jdbcTemplate.update(sql, id);
   }
}
