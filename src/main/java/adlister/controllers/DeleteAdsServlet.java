package adlister.controllers;

import adlister.dao.Ads;
import adlister.dao.DaoFactory;
import adlister.models.Ad;
import adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ads/adDelete")
public class DeleteAdsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            User currentUser = (User) session.getAttribute("user");
            int adId = Integer.parseInt(req.getParameter("id"));
            Long longAdId = Long.parseLong(req.getParameter("id"));
            Ads ads = DaoFactory.getAdsDao();
            Ad adToBeDeleted = ads.findById(adId);

            if (adToBeDeleted.getUserId() == currentUser.getId()) {
                DaoFactory.getAdCategoriesDao().deleteAdsFromCategory(longAdId);
                resp.setStatus(HttpServletResponse.SC_OK);
            } else {
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "You do not have permission to delete this ad.");
            }

            if (adToBeDeleted.getUserId() == currentUser.getId()) {
                DaoFactory.getAdsDao().deleteAd(adId);
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.sendRedirect("/user/profile");
            } else {
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "You do not have permission to delete this ad.");
            }

        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ad id.");
        } catch (NullPointerException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ad id.");
        }
    }
}

