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
import java.sql.SQLException;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null){
            req.getRequestDispatcher("/WEB-INF/updateUser.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String newUsername = req.getParameter("updateUsername");
        String newPassword = req.getParameter("updatePassword");
        String newPasswordConfirm = req.getParameter("updatePasswordConfirm");
        String newEmail = req.getParameter("updateEmail");
        Long userId = user.getId();
        boolean inputHasErrors = false;

        // validate input
        if (newPassword.isEmpty()){
            inputHasErrors = newUsername.isEmpty()
                    || newEmail.isEmpty();
            if (inputHasErrors) {
                resp.sendRedirect("/updateUser");
                return;
            }
            User updatedUser = null;
            try {
                updatedUser = DaoFactory.getUsersDao().updateUser(userId, newUsername, newEmail);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("user: " + updatedUser.getUsername() + " updated.");
            req.getSession().setAttribute("user", updatedUser );
            resp.sendRedirect("/profile");
        } else {
            inputHasErrors = newUsername.isEmpty()
                    || newEmail.isEmpty()
                    || newPassword.isEmpty()
                    || (! newPassword.equals(newPasswordConfirm));
            if (inputHasErrors) {
                resp.sendRedirect("/updateUser");
                return;
            }
            newPassword = Password.hash(newPassword);
            User updatedUser = null;
            try {
                updatedUser = DaoFactory.getUsersDao().updateUser(userId, newUsername, newPassword, newEmail);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("user: " + updatedUser.getUsername() + " updated.");
            req.getSession().setAttribute("user", updatedUser );
            resp.sendRedirect("/profile");
        }
    }
}
