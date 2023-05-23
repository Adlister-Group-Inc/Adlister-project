package adlister.controllers;

import adlister.dao.DaoFactory;
import adlister.models.User;
import adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("userLoginError",request.getParameter("userLoginError"));

        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/user/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        request.setAttribute("username", username);

        String password = request.getParameter("password");
        User user = DaoFactory.getUsersDao().findByUsername(username);

        if (user == null) {
            response.sendRedirect("/user/login?userLoginError=true");
            return;
        }

        boolean validAttempt = Password.check(password, user.getPassword());

        if (validAttempt) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/user/profile");
        } else {
            request.setAttribute("userLoginError", true);
            request.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(request,response);
        }
    }
}
