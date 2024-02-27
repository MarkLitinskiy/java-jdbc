package edu.school21.chat.repositories;

import edu.school21.chat.models.Chat;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private Connection connection;

    public MessagesRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    public Optional<Message> findById(Long id) throws SQLException {
        String query = "select * from chat_database.message where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String messageText = resultSet.getString("message_text");
            Timestamp timestamp = resultSet.getTimestamp("data_time");
            LocalDateTime dataTime = timestamp.toLocalDateTime();
            Long authorID = resultSet.getLong("author_id");
            System.out.println("Message : {" + "\n" +
                    "  id=" + id + ",\n" +
                    "  author=" + findByAuthorId(authorID) + ",\n" +
                    "  room=" + findByRoomId(authorID) + ",\n" +
                    "  text=\"" + messageText + "\",\n" +
                    "  dataTime=" + dataTime + "\n" + "}");

            return Optional.of(new Message(id, findByAuthorId(authorID).getId(), findByRoomId(authorID).getId(), messageText, dataTime));
        } catch (SQLException exception) {
            throw new SQLException(exception);
        }
    }

    private User findByAuthorId(Long id) throws SQLException {
        String query = "select * from chat_database.users where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Long authorId = resultSet.getLong("id");
            String user_login = resultSet.getString("user_login");
            String user_password = resultSet.getString("user_password");
            return new User(authorId, user_login, user_password, new ArrayList<>(), new ArrayList<>());
        } catch (SQLException exception) {
            throw new SQLException(exception);
        }
    }

    private Chat findByRoomId(Long id) throws SQLException {
        String query = "select * from chat_database.chatroom where chatroom_owner_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Long chatId = resultSet.getLong("id");
            String chatroom_name = resultSet.getString("chatroom_name");
            Long chatroom_owner_id = resultSet.getLong("chatroom_owner_id");
            return new Chat(chatId, chatroom_name, null, null);
        } catch (SQLException exception) {
            throw new SQLException(exception);
        }
    }

}
