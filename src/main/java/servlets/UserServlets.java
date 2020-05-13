package servlets;


import model.User;
import service.UserImplService.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = UsersService.getInstance().getUserByName((String)req.getSession().getAttribute("name"));
        req.setAttribute("user",user);
        req.getRequestDispatcher("user.jsp").forward(req,resp);
    }
}
