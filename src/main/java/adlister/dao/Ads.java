package adlister.dao;

import adlister.models.Ad;

import java.sql.SQLException;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    Ad findById(long id);
    List<Ad> searchAds(String search);

    List<Ad> findByUserId(Long userId);

    Ad updateAd(int adId, String newTitle, String newDescription) throws SQLException;
    Ad searchAdsById(Long searchId);

    Ad deleteAd(int adId);
}
