package pomodoro_app.Database;

import java.sql.*;
import java.text.ParseException;

public class Database {
    Connection connection = null;

    public Database() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        // if connection can't write the file, throws an exception and the value of
        // connection remains null.
        // this.connect() won't execute
        this.connect();
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private void connect() throws SQLException {
        try {
            // db create if not exist
            Statement statement = connection.createStatement();

            // create table
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS pomodoro(id INTEGER PRIMARY KEY AUTOINCREMENT, length INTEGER NOT NULL, date DATE DEFAULT CURRENT_DATE )");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insert(int length) throws SQLException {
        try {
            Statement statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO pomodoro (length, date) VALUES (" + length + " ,date('now'))");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Test
    public void query() throws SQLException, ParseException {
        try {
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM pomodoro");
            while (result.next()) {
                System.out.println(result.getInt("id") + "\t" +
                        result.getInt("length") + "\t" +
                        result.getString("date"));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String getSelectedTime(String arg) throws SQLException, ParseException {
        try {
            int selectedTimeInt = 0;
            Statement statement = connection.createStatement();

            ResultSet result = statement
                    .executeQuery("SELECT * FROM pomodoro WHERE date BETWEEN date('" + arg + "') AND date('now')");
            while (result.next()) {
                System.out.println(result.getInt("id") + "\t" +
                        result.getInt("length") + "\t" +
                        result.getString("date"));
                selectedTimeInt += result.getInt("length");
            }
            return formatSec(selectedTimeInt);
        } catch (SQLException e) {
            System.out.println(e);
            return "Selected time query error: \n" + e;
        }
    }

    public String getAllTime() throws SQLException, ParseException {
        try {
            int allTimeInt = 0;
            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM pomodoro");
            while (result.next()) {
                allTimeInt += result.getInt("length");
            }
            return formatSec(allTimeInt);
        } catch (SQLException e) {
            System.out.println(e);
            return "All time query error: \n" + e;
        }
    }

    private String formatSec(int seconds) {
        double hours = Math.ceil(seconds * 0.000277778);
        return String.format("%s", hours);
    }

}
