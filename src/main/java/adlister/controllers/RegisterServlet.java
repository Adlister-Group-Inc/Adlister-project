package adlister.controllers;

import adlister.dao.DaoFactory;
import adlister.models.User;
import adlister.util.InputValidation;
import adlister.util.Password;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("usernameError",request.getParameter("usernameError"));
        request.setAttribute("passwordError",request.getParameter("passwordError"));
        request.setAttribute("emailError",request.getParameter("emailError"));

        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        request.setAttribute("username", username);

        String email = request.getParameter("email");
        request.setAttribute("email", email);

        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input
        boolean inputHasErrors = InputValidation.usernameError(username)
                || InputValidation.passwordError(password, passwordConfirmation)
                || InputValidation.emailError(email);

        boolean usernameError = InputValidation.usernameError(username);
        boolean passwordError = InputValidation.passwordError(password, passwordConfirmation);
        boolean emailError =  InputValidation.emailError(email);

        if (inputHasErrors) {
            request.setAttribute("usernameError", usernameError);
            request.setAttribute("passwordError", passwordError);
            request.setAttribute("emailError", emailError);
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);
            return;
        }

        // create and save a new user
        User user = new User(username, email, password);

        // hash the password
        String hash = Password.hash(user.getPassword());

        user.setPassword(hash);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}
