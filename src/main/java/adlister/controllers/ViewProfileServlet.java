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
import java.util.List;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }

        request.setAttribute("ads",DaoFactory.getAdsDao().findByUserId(user.getId()) );
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Inside profileServlet doPut");
        try {
            HttpSession session = req.getSession();
            User currentUser = (User) session.getAttribute("user");
            // Parse the ad id, new title and new description from the request body
            int adId = Integer.parseInt(req.getParameter("id"));
            String newTitle = req.getParameter("title");
            String newDescription = req.getParameter("description");
            Ads ads = DaoFactory.getAdsDao();
            Ad adToBeUpdated = ads.findById(adId);


            if (adToBeUpdated.getUserId() == currentUser.getId()) {
                DaoFactory.getAdsDao().updateAd(adId, newTitle, newDescription);
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.sendRedirect("/profile");
            } else {
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "You do not have permission to edit this ad.");
            }
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ad id.");
        } catch (NullPointerException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request body or session attributes.");
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request.");
        }

    }
}