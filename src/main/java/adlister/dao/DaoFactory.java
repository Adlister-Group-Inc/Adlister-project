package adlister.dao;
import adlister.dao.Config;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static AdsCategory adsCategoriesDao;
    private static Categories categoriesDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }

    public static AdsCategory getAdCategoriesDao() {
        if (adsCategoriesDao == null) {
            adsCategoriesDao = new MySQLAdCategoryDao(config);
        }
        return adsCategoriesDao;
    }

    public static Categories getCategoriesDao() {
        if (categoriesDao == null){
            categoriesDao = new MySQLCategoriesDao(config);
        }
        return categoriesDao;
    }
}
