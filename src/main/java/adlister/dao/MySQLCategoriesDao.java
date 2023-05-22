package adlister.dao;

import adlister.models.Category;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDao implements Categories{
    private Connection connection;
    public MySQLCategoriesDao(Config config) {
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
    public List<Category> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM categories");
            ResultSet rs = stmt.executeQuery();
            return createCategoriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }
    private List<Category> createCategoriesFromResults(ResultSet rs) throws SQLException {
        List<Category> categories = new ArrayList<>();
        while (rs.next()) {
            categories.add(extractCategories(rs));
        }
        return categories;
    }
    private Category extractCategories(ResultSet rs) throws SQLException {
        return new Category(
                rs.getLong("id"),
                rs.getString("category")
        );
    }

    @Override
    public List<Category> searchCategory(String search) {
        return null;
    }

    @Override
    public Category updateCategory(int adId, String newTitle, String newDescription, String newCategory) throws SQLException {
        return null;
    }
}
