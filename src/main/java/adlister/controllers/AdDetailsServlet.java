package adlister.controllers;

import adlister.dao.DaoFactory;
import adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdsDetailsServlet", urlPatterns = "/ads/adDetails")
public class AdDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adId = request.getParameter("id");

        Long parsedAdId = null;
        try {
            parsedAdId = Long.parseLong(adId);
        } catch (NumberFormatException e) {
        }

        Ad adById = DaoFactory.getAdsDao().searchAdsById(parsedAdId);
        request.setAttribute("ad", adById);
        request.getRequestDispatcher("/WEB-INF/ads/adDetails.jsp").forward(request, response);
    }
}