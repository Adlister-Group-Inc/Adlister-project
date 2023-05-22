package adlister.dao;

import java.util.List;

public interface AdsCategory {

        void linkAdToCategory(Long adId, Long categoryId);
        void unlinkAdFromCategory(Long adId, Long categoryId);

        List<Long> getCategoriesByAdId(Long adId);

        List<Long> getAdsByCategory(Long categoryId);
}
