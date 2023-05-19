package adlister.dao;

import adlister.models.User;

import java.sql.SQLException;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    User updateUser(Long id, String newUsername, String newPassword, String newEmail) throws SQLException;
    User updateUser(Long id, String newUsername, String newEmail) throws SQLException;
}
