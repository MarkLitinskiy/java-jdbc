INSERT INTO chat_database.Users (user_login, user_password) VALUES ('Marcus', '12345');
INSERT INTO chat_database.Users (user_login, user_password) VALUES ('Ranis', 'qwerty');
INSERT INTO chat_database.Users (user_login, user_password) VALUES ('Sasha', 'zxcvbn');
INSERT INTO chat_database.Users (user_login, user_password) VALUES ('Misha', 'wsgdvdb');
INSERT INTO chat_database.Users (user_login, user_password) VALUES ('Renal', '000000');
INSERT INTO chat_database.Users (user_login, user_password) VALUES ('Natasha', 'Natasha2001');

INSERT INTO chat_database.Chatroom (chatroom_name, chatroom_owner_id) VALUES ('Marcus_chat', 1);
INSERT INTO chat_database.Chatroom (chatroom_name, chatroom_owner_id) VALUES ('Kitchen', 3);
INSERT INTO chat_database.Chatroom (chatroom_name, chatroom_owner_id) VALUES ('Board_Games', 4);
INSERT INTO chat_database.Chatroom (chatroom_name, chatroom_owner_id) VALUES ('Hi-Hi-Ha-Ha', 5);
INSERT INTO chat_database.Chatroom (chatroom_name, chatroom_owner_id) VALUES ('Java_Bootcamp', 2);
INSERT INTO chat_database.Chatroom (chatroom_name, chatroom_owner_id) VALUES ('Tennis-pool', 6);

INSERT INTO chat_database.Message (author_id, room_id, message_text, data_time) VALUES (1, 1, 'Ahahaha, its me', current_timestamp);
INSERT INTO chat_database.Message (author_id, room_id, message_text, data_time) VALUES (2, 5, 'Java fire', current_timestamp);
INSERT INTO chat_database.Message (author_id, room_id, message_text, data_time) VALUES (3, 2, '5 season, 2 seria', current_timestamp);
INSERT INTO chat_database.Message (author_id, room_id, message_text, data_time) VALUES (4, 3, 'Teckets to ride', current_timestamp);
INSERT INTO chat_database.Message (author_id, room_id, message_text, data_time) VALUES (5, 4, 'Lol, I love python', current_timestamp);

INSERT INTO chat_database.list_of_created_rooms (chatroom_id, chatroom_owner_id, chatroom_name) VALUES (1, 1, 'Marcus_chat');
INSERT INTO chat_database.list_of_created_rooms (chatroom_id, chatroom_owner_id, chatroom_name) VALUES (2, 3, 'Kitchen');
INSERT INTO chat_database.list_of_created_rooms (chatroom_id, chatroom_owner_id, chatroom_name) VALUES (3, 4, 'Board_Games');
INSERT INTO chat_database.list_of_created_rooms (chatroom_id, chatroom_owner_id, chatroom_name) VALUES (4, 5, 'Hi-Hi-Ha-Ha');
INSERT INTO chat_database.list_of_created_rooms (chatroom_id, chatroom_owner_id, chatroom_name) VALUES (5, 2, 'Java_Bootcamp');