CREATE TABLE player
(
    id       BIGSERIAL PRIMARY KEY,
    nickname TEXT NOT NULL,
    password TEXT NOT NULL,
    playersRoomId INT NOT NULL,
    unique (nickname)
);