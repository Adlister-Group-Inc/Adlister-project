package adlister.dao;

import adlister.models.Ad;
import java.sql.DriverManager;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
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
    public List<Ad> findByUserId(Long userId) {
        String query = "SELECT * FROM ads WHERE user_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, userId);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }


        @Override
        public Ad findById(long id) {
            String query = "SELECT * FROM ads WHERE id = ?";

            try (PreparedStatement stmt = connection.prepareStatement(query)) {
              stmt.setLong(1, id);

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    return extractAd(rs);
                } else {
                    return null;
                }
            } catch (SQLException ex) {
                }
            return null;
        }



    public Ad updateAd(int id, String newTitle, String newDescription) throws SQLException {
        String query = "UPDATE ads SET title = ?, description = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newTitle);
            stmt.setString(2, newDescription);
            stmt.setInt(3, id);

            int updatedRows = stmt.executeUpdate();

            if (updatedRows > 0) {
                // If the update was successful, return the updated Ad
                return findById(id);
            } else {
                // If no rows were updated, the Ad with the provided id doesn't exist
                return null;
            }
        } catch (SQLException ex) {
            throw new SQLException("Error while updating ad with id: " + id, ex);
        }
    }

//    @Override
//    public void deleteAd(int adId) {
//        String query = "DELETE FROM ads WHERE id = ?";
//        try (PreparedStatement stmt = connection.prepareStatement(query)) {
//            stmt.setInt(1, adId);
//            stmt.executeUpdate();
//        } catch (SQLException ex) {
//            throw new RuntimeException("Error while deleting ad with id: " + adId, ex);
//        }
//    }

    public Ad deleteAd(int adId) {
        String query = "DELETE FROM ads WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, adId);
            stmt.executeUpdate();
            return findById(adId);
        } catch (SQLException ex) {
            throw new RuntimeException("Error while deleting ad with id: " + adId, ex);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    //-------------------------------------------------------------------------------
    @Override
    public List<Ad> searchAds(String search) {

        List<Ad> results = new ArrayList<>();
        String query = "SELECT * FROM ads WHERE title LIKE ?";
        PreparedStatement stmt = null;

        try{
            stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, '%'+ search + '%');
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
               Ad newAd = extractAd(rs);
                results.add(newAd);
            }
            return results;
        } catch (SQLException e){
            throw new RuntimeException("Error retrieving searched ads.", e);
        }
    }

    @Override
    public Ad searchAdsById(Long searchId) {

        String query = "SELECT * FROM ads WHERE id = ?;";
        PreparedStatement stmt = null;

        try{
            stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, searchId);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return extractAd(rs);
            } else {
                throw new RuntimeException("No ad found with the specified ID.");
            }
        } catch (SQLException e){
            throw new RuntimeException("Error retrieving searched ad.", e);
        }
    }

}
