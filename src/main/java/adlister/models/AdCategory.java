package adlister.models;

public class AdCategory {
    private Long adId;
    private Long categoryId;

    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public AdCategory() {
    }

    public AdCategory(Long adId, Long categoryId) {
        this.adId = adId;
        this.categoryId = categoryId;
    }
}
