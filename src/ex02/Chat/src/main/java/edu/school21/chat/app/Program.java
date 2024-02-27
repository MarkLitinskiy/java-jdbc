package edu.school21.chat.app;

import edu.school21.chat.models.*;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String currentStr = null;
            while(true) {
                System.out.println("Enter a message:");
                currentStr = scanner.next();
                if(currentStr.equals("exit")){
                    break;
                }
                saveMessageToDataBase(currentStr);

            }
        } catch (SQLException | NotSavedSubEntityException exception) {
            System.out.println(exception);
        }
    }

    private static void saveMessageToDataBase(String message) throws SQLException {
        User creator = new User(1L, "Marcus", "12345", new ArrayList(), new ArrayList());
        Chat room = new Chat(1L, "Marcus_chat", creator.getId(), new ArrayList());
        Message newMessage = new Message(null, creator.getId(), room.getId(), message, LocalDateTime.now());
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(DataSource.getConnection());
        messagesRepository.save(newMessage);
        System.out.println("ID нового сообщения в таблице: " + newMessage.getId());
    }
}