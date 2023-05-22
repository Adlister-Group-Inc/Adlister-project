package adlister.controllers;

import adlister.dao.DaoFactory;
import adlister.models.Ad;
import adlister.models.User;
import adlister.util.InputValidation;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getAttribute("titleError");
        request.getAttribute("descriptionError");
        request.getAttribute("categoryError");
        if(request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            // add a return statement to exit out of the entire method.
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User loggedInUser = (User) request.getSession().getAttribute("user");

        String title = request.getParameter("title");
        String description = request.getParameter("description");

        boolean titleError = InputValidation.adTitleError(title);
        boolean descriptionError = InputValidation.adDescError(description);

        boolean inputHasErrors =
                titleError
                || descriptionError;

        if (inputHasErrors){
            request.setAttribute("titleError", titleError);
            request.setAttribute("descriptionError", descriptionError);
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request,response);
            return;
        }

        String[] categories = request.getParameterValues("category");

        if (categories == null) {
            request.setAttribute("categoryError", true);
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request,response);
            return;
        }

        Ad ad = new Ad(
            loggedInUser.getId(),
            request.getParameter("title"),
            request.getParameter("description")
        );

        Long adId = DaoFactory.getAdsDao().insert(ad);

        for (String categoryIdStr : categories) {
            Long categoryId = Long.parseLong(categoryIdStr);
            DaoFactory.getAdCategoriesDao().linkAdToCategory(adId, categoryId);
        }

        response.sendRedirect("/ads");
    }
}
