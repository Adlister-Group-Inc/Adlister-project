package adlister.controllers;

import adlister.dao.DaoFactory;
import adlister.models.Ad;
import adlister.models.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ads/category")
public class CategorySearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("category");
        req.setAttribute("category", search);
        Long catId = DaoFactory.getCategoriesDao().searchCategory(search);
        List<Ad> results = DaoFactory.getAdCategoriesDao().getAllAdsByCategory(catId);
        req.setAttribute("results", results);
        req.getRequestDispatcher("/WEB-INF/ads/category.jsp").forward(req,resp);
    }
}
