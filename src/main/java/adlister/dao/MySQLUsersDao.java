package adlister.dao;

import adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.lang.annotation.Documented;
import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password")
        );
    }
    @Override
    public User updateUser(Long id, String newUsername, String newPassword, String newEmail) throws SQLException {
        String query = "UPDATE users SET username = ?, password = ?, email = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newUsername);
            stmt.setString(2, newPassword);
            stmt.setString(3, newEmail);
            stmt.setLong(4, id);

            int updatedRows = stmt.executeUpdate();
            if (updatedRows > 0) {
                // If the update was successful, return the updated User
                return findByUsername(newUsername);
            } else {
                // If no rows were updated, the User with the provided id doesn't exist
                return null;
            }
        } catch (SQLException ex) {
            throw new SQLException("Error while updating user with id: " + id, ex);
        }
    }

    @Override
    public User updateUser(Long id, String newUsername, String newEmail) throws SQLException {
        String query = "UPDATE users SET username = ?, email = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newUsername);
            stmt.setString(2, newEmail);
            stmt.setLong(3, id);

            int updatedRows = stmt.executeUpdate();
            if (updatedRows > 0) {
                // If the update was successful, return the updated User
                return findByUsername(newUsername);
            } else {
                // If no rows were updated, the User with the provided id doesn't exist
                return null;
            }
        } catch (SQLException ex) {
            throw new SQLException("Error while updating user with id: " + id, ex);
        }
    }

}
