package com.marcel.malewski.checkersonlinebackend.player;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Player {
   private Long id;
   private String nickname;
   private String password;
   private Integer playersRoomId;

   public Player(Long id, String nickname, String password, Integer playersRoomId) {
      this.id = id;
      this.nickname = nickname;
      this.password = password;
      this.playersRoomId = playersRoomId;
   }
}
