package adlister.dao;

import adlister.models.Ad;

import java.util.List;

public interface AdsCategory {

        void linkAdToCategory(Long adId, Long categoryId);
        void unlinkAdFromCategory(Long adId, Long categoryId);

        List<Long> getCategoriesByAdId(Long adId);
        List<Ad> getAllAdsByCategory(Long categoryId);

        List<Long> getAdsByCategory(Long categoryId);
        void deleteAdsFromCategory(Long adId);
}
