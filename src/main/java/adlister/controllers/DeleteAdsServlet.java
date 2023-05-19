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
        // when user presses delete button delete ad by id
        System.out.println("Inside deleteAdsServlet doPut");
        try {
            HttpSession session = req.getSession();
            User currentUser = (User) session.getAttribute("user");
            System.out.println(currentUser.getUsername());
            // Parse the ad id, new title and new description from the request body
            int adId = Integer.parseInt(req.getParameter("id"));
            System.out.println(adId);
            // Get the ad to be updated
            Ads ads = DaoFactory.getAdsDao();
            Ad adToBeDeleted = ads.findById(adId);

            if (adToBeDeleted.getUserId() == currentUser.getId()) {
                System.out.println("ads user and current user are the same");
                DaoFactory.getAdsDao().deleteAd(adId);
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.sendRedirect("/profile");
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

