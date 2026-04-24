package relationaldatabases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionTest {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Admin";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println("Connection established: " + conn);

            // Si quieres crear una DB nueva, hazlo aparte y con un nombre concreto.
            // createDatabase("mi_basedatos");

            dropTable(conn);
            createTable(conn);

            insertUsers(conn);

            selectByName(conn, "Pablo");
            deleteByName(conn, "Jorge");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void dropTable(Connection conn) throws SQLException {
        String sql = "DROP TABLE IF EXISTS users";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.executeUpdate();
        }
    }

    private static void createTable(Connection conn) throws SQLException {
        String sql = """
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER NOT NULL,
                username VARCHAR(255),
                psw VARCHAR(255),
                isVIP BOOLEAN,
                balance NUMERIC,
                PRIMARY KEY (id)
            )
            """;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.executeUpdate();
        }
    }

    private static void insertUsers(Connection conn) throws SQLException {
        String sql = "INSERT INTO users (id, username, psw, isVIP, balance) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, 19);
            ps.setString(2, "Pablo");
            ps.setString(3, "1243");
            ps.setBoolean(4, true);
            ps.setBigDecimal(5, new java.math.BigDecimal("224.5"));
            ps.executeUpdate();
        }

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, 20);
            ps.setString(2, "Alex");
            ps.setString(3, "121");
            ps.setBoolean(4, false);
            ps.setBigDecimal(5, new java.math.BigDecimal("234.9"));
            ps.executeUpdate();
        }
    }

    private static void selectByName(Connection conn, String name) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("username") + " | " +
                        rs.getString("psw") + " | " +
                        rs.getBoolean("isVIP") + " | " +
                        rs.getBigDecimal("balance")
                    );
                }
            }
        }
    }

    private static void deleteByName(Connection conn, String name) throws SQLException {
        String sql = "DELETE FROM users WHERE username = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            System.out.println("Deleted rows: " + ps.executeUpdate());
        }
    }

    /*
    private static void createDatabase(String dbName) {
        String sql = "CREATE DATABASE " + dbName;
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */
}