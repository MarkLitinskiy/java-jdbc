package edu.school21.chat.repositories;

import edu.school21.chat.models.Chat;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.NotSavedSubEntityException;
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

    @Override
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
            System.err.println(exception);
        }
        return null;
    }

    private Chat findByRoomId(Long id) throws SQLException {
        String query = "select * from chat_database.chatroom where chatroom_owner_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Long chatId = resultSet.getLong("id");
            String chatroom_name = resultSet.getString("chatroom_name");
            return new Chat(chatId, chatroom_name, null, null);
        } catch (SQLException exception) {
            System.err.println(exception);
        }
        return null;
    }

    @Override
    public void save(Message message) throws SQLException {
        String query = "insert into chat_database.message values (DEFAULT, ?, ?, ?, ?)";
        checkThrows(message);
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             Statement selectUsersStatement = connection.createStatement()) {
            preparedStatement.setLong(1, message.getAuthorId());
            preparedStatement.setLong(2, message.getRoomId());
            preparedStatement.setString(3, message.getMessageText());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(message.getDataTime()));
            preparedStatement.executeUpdate();
            ResultSet resultSet = selectUsersStatement.executeQuery("Select id from chat_database.message order by id desc limit 1;");
            resultSet.next();
            message.setId(resultSet.getLong("id"));
        } catch (SQLException exception) {
            throw new SQLException(exception);
        }
    }

    private void checkThrows(Message message) throws SQLException {
        if (message.getAuthorId() == null || message.getRoomId() == null)
        {
            throw new NotSavedSubEntityException("Отсутствуют ID комнаты или юзера!");
        } else if (message.getId() != null){
            throw new NotSavedSubEntityException("Невозможно создать сообщение с заданным ID!");
        } else if (findByAuthorId(message.getAuthorId()) == null || findByRoomId(message.getRoomId()) == null){
            throw new NotSavedSubEntityException("ID комнаты или юзера не существуют в базе данных!");
        }
    }

    @Override
    public void update(Message message) throws SQLException {
        String updateQuery = "update chat_database.message set" +
                " author_id = " + message.getAuthorId() +
                ", room_id = " + message.getRoomId() +
                ", message_text = '" + message.getMessageText() +
                "', data_time = '" + message.getDataTime() +
                "' where id = " + message.getId();
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("Select id from chat_database.message order by id desc limit 1;");
            resultSet.next();
            if (resultSet.getLong("id") >= message.getId()){
            statement.executeUpdate(updateQuery);
            } else {
                throw new NotSavedSubEntityException("Такой ID сообщения отсутствует!");
            }
        } catch (SQLException exception){
            throw new SQLException(exception);
        }
    }
}
