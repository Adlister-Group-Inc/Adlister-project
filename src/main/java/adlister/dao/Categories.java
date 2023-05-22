package adlister.dao;

import adlister.models.Category;

import java.sql.SQLException;
import java.util.List;

public interface Categories {
    List<Category> all();
    List<Category> searchCategory(String search);
    Category updateCategory(int adId, String newTitle, String newDescription, String newCategory) throws SQLException;

}
