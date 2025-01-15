package org.example;

import java.sql.*;

public class JdbcApp {

    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        try {
            connect();
            //createTableEx();
            //insertEx();
            readEx();
//            deleteEx();
//            System.out.println("After delete:");
//            readEx();
//            clearTableEx();
            psBatchEx();
            transactionEx();
            readEx();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static void connect() throws SQLException {
        System.out.println("Открывается соединение с БД");
        connection = DriverManager.getConnection("jdbc:sqlite:javadb.db");
        statement = connection.createStatement();
    }

    private static void disconnect() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Соединение закрыто");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTableEx() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS students (\n" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                " name TEXT,\n" +
                " score INTEGER\n" +
                " );");
    }

    private static void dropTableEx() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS students;");
    }

    private static void readEx() throws SQLException {
        try (ResultSet rs = statement.executeQuery("SELECT * FROM students;")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " +
                        rs.getInt(3));
            }
        }
    }

    private static void clearTableEx() throws SQLException {
        statement.executeUpdate("DELETE FROM students;");
    }

    private static void deleteEx() throws SQLException {
        statement.executeUpdate("DELETE FROM students WHERE name = 'Bob4';");
    }

    private static void insertEx() throws SQLException {
        statement.executeUpdate("INSERT INTO students (name,score) VALUES ('Bob4', 60);");
        statement.executeUpdate("INSERT INTO students (name,score) VALUES ('Jane4', 50);");
        statement.executeUpdate("INSERT INTO students (name,score) VALUES ('Ira4', 30);");
        statement.executeUpdate("INSERT INTO students (name,score) VALUES ('Petr4', 20);");
    }

    private static void psBatchEx() {
        try (PreparedStatement prepInsert = connection.prepareStatement("INSERT INTO students(name,score) VALUES(?,?)")) {
            for (int i = 1; i <= 10; i++) {
                prepInsert.setString(1, "Bob" + i);
                prepInsert.setInt(2, i * 10 % 100);
                prepInsert.addBatch();
            }
            int[] result = prepInsert.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void transactionEx() throws SQLException {
        connection.setAutoCommit(false);
        try {
            statement.execute("INSERT INTO students (name, score) values ('Walentin', 56)");
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        }
    }

}