CREATE TABLE player
(
    id       BIGSERIAL PRIMARY KEY,
    nickname TEXT NOT NULL,
    password TEXT NOT NULL,
    usersRoomId INT NOT NULL,
    unique (nickname)
);