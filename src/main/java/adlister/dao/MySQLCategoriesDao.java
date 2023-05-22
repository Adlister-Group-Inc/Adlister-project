package adlister.dao;

import adlister.models.Ad;
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
            throw new RuntimeException("Error retrieving all categories.", e);
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
    public Long searchCategory(String search) {
        String query = "SELECT * FROM categories WHERE category LIKE ?";
        PreparedStatement stmt = null;
        Category newCategories = null;
        try{
            stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, '%'+ search + '%');
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                newCategories = extractCategories(rs);
            }
            return newCategories.getId();
        } catch (SQLException e){
            throw new RuntimeException("Error retrieving searched category.", e);
        }
    }


    @Override
    public Category updateCategory(int adId, String newTitle, String newDescription, String newCategory) throws SQLException {
        return null;
    }
}
