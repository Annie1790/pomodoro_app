package pomodoro_app.Database;

import java.sql.*;

public class Database {
    Connection connection = null;

    public void connectToDatabase() throws SQLException {
        try {
            // db create if not exist
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            Statement statement = connection.createStatement();

            // create table
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS pomodoro(id INTEGER PRIMARY KEY AUTOINCREMENT, length INTEGER NOT NULL, date DATE DEFAULT CURRENT_DATE )");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertToDatabase(int length) throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            Statement statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO pomodoro (length, date) VALUES (" + length + " ,date('now'))");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void queryDatabase() throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            Statement statement = connection.createStatement();

            statement.executeQuery("SELECT * FROM pomodoro");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
