package com.marcel.malewski.checkersonlinebackend.player;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerRowMapper implements RowMapper<Player> {
   @Override
   public Player mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
      return new Player(
              resultSet.getInt("id"),
              resultSet.getString("nickname"),
              resultSet.getString("password"),
              resultSet.getObject("playersRoomId") == null ? null : resultSet.getInt("playersRoomId")
      );
   }
}
