package adlister.dao;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdCategoryDao implements AdsCategory {

    private Connection connection;

    public MySQLAdCategoryDao(Config config) {
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
    public void linkAdToCategory(Long adId, Long categoryId) {
        String sql = "INSERT INTO ads_category (ad_id, category_id) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, adId);
            stmt.setLong(2, categoryId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error linking Ad to Category!", e);
        }
    }

    @Override
    public void unlinkAdFromCategory(Long adId, Long categoryId) {
        String sql = "DELETE FROM ads_category WHERE ad_id = ? AND category_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, adId);
            stmt.setLong(2, categoryId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error unlinking Ad from Category!", e);
        }
    }

    @Override
    public List<Long> getCategoriesByAdId(Long adId) {
        List<Long> categories = new ArrayList<>();
        String sql = "SELECT category_id FROM ads_category WHERE ad_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, adId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                categories.add(rs.getLong("categoryId"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving categories by Ad id.", e);
        }

        return categories;
    }

    @Override
    public List<Long> getAdsByCategory(Long categoryId) {
        List<Long> ads = new ArrayList<>();
        String sql = "SELECT ad_id FROM ads_category WHERE category_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, categoryId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                ads.add(rs.getLong("adId"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ads by Category id.", e);
        }

        return ads;
    }

    @Override
    public void deleteAdsFromCategory(Long adId) {
        String query = "DELETE FROM ads_category WHERE ad_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, adId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}