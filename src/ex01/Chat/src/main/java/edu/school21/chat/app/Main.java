package edu.school21.chat.app;

import edu.school21.chat.models.ConnectionData;
import edu.school21.chat.models.DataSource;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String currentStr = null;
            Long id = null;
            while(true) {
                System.out.println("Enter a message ID:");
                currentStr = scanner.next();
                if(currentStr.equals("exit")){
                    break;
                } else {
                    id = Long.parseLong(currentStr);
                }
                MessagesRepositoryJdbcImpl messagesRepositoryJdbc = new MessagesRepositoryJdbcImpl(DataSource.getConnection());
                messagesRepositoryJdbc.findById(id);
            }
        } catch (SQLException | InputMismatchException | NumberFormatException exception) {
            System.err.println(exception.getMessage());
        }
    }
}