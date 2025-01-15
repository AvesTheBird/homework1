package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Homework {

    public static void main(String[] args) {
        //createDatabaseAndTable();

        insertData();

        selectData();

        updateData();
    }

    private static void createDatabaseAndTable() {
        String url = "jdbc:postgresql://localhost:5434/";
        String user = "postgres";
        String password = "qwerty";
        String dbName = "postgres1";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE DATABASE " + dbName);
            System.out.println("Database created successfully.");

            // Подключение к созданной базе данных
            String dbUrl = "jdbc:postgresql://localhost:5434/" + dbName;
            try (Connection dbConn = DriverManager.getConnection(dbUrl, user, password)) {
                Statement dbStmt = dbConn.createStatement();
                String createTableSQL = "CREATE TABLE your_table_name (" +
                        "id SERIAL PRIMARY KEY, " +
                        "column1 VARCHAR(255), " +
                        "column2 INT)";
                dbStmt.executeUpdate(createTableSQL);
                System.out.println("Table created successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertData() {
        String url = "jdbc:postgresql://localhost:5434/";
        String user = "postgres";
        String password = "qwerty";

        String sql = "INSERT INTO your_table_name (column1, column2) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "Value1");
            pstmt.setInt(2, 123);
            pstmt.executeUpdate();
            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод для выборки данных из таблицы
    private static void selectData() {
        String url = "jdbc:postgresql://localhost:5434/";
        String user = "postgres";
        String password = "qwerty";

        String query = "SELECT * FROM your_table_name";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println(rs.getString("column1") + " " + rs.getInt("column2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateData() {
        String url = "jdbc:postgresql://localhost:5434/";
        String user = "postgres";
        String password = "qwerty";

        String sql = "UPDATE your_table_name SET column1 = ?, column2 = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "UpdatedValue");
            pstmt.setInt(2, 456);
            pstmt.setInt(3, 1);
            pstmt.executeUpdate();
            System.out.println("Data updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
