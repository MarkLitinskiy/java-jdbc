DROP SCHEMA IF EXISTS chat_database cascade;
CREATE SCHEMA IF NOT EXISTS chat_database;
CREATE TABLE chat_database.Users
(
    id serial PRIMARY KEY,
    user_login varchar (40) UNIQUE,
    user_password varchar (40) UNIQUE
);

CREATE TABLE chat_database.Chatroom
(
    id                             serial PRIMARY KEY,
    chatroom_name                  varchar(40) UNIQUE,
    chatroom_owner_id                 INTEGER,
    CONSTRAINT fk_owner FOREIGN KEY (chatroom_owner_id) REFERENCES chat_database.Users (id)
);

CREATE TABLE chat_database.Message
(
    id           serial PRIMARY KEY,
    author_id       INTEGER,
    room_id         INTEGER,
    message_text varchar(255),
    data_time    timestamp,
    CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES chat_database.Users (id),
    CONSTRAINT fk_room FOREIGN KEY (room_id) REFERENCES chat_database.Chatroom (id)
);

CREATE TABLE chat_database.list_of_created_rooms (
    id SERIAL PRIMARY KEY,
    chatroom_owner_id INT,
    chatroom_id INT,
    chatroom_name varchar(40),
    CONSTRAINT fk_owner_id FOREIGN KEY (chatroom_owner_id) REFERENCES chat_database.Users(id),
    CONSTRAINT fk_chatroom_id FOREIGN KEY (chatroom_id) REFERENCES chat_database.Chatroom(id),
    CONSTRAINT fk_chatroom_name FOREIGN KEY (chatroom_name) REFERENCES chat_database.Chatroom(chatroom_name)
);
