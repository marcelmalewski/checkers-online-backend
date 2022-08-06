package com.marcel.malewski.checkersonlinebackend.player;

public record Player(Integer id,
                     String nickname,
                     String password,
                     Integer playersRoomId) {
}
