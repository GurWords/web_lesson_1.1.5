package servlets;

import model.User;
import service.UserImplService.UsersService;
import dao.userdao.UserJdbcDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/admin")
public class AdminServlets extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        UserJdbcDAO userJdbcDAO = new UserJdbcDAO();
        userJdbcDAO.createTable();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = UsersService.getInstance().selectAllUsers();
        req.setAttribute("userlist",userList);
        //resp.sendRedirect(req.getContextPath()+"/admin.jsp");
        getServletContext().getRequestDispatcher("/admin.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/admin.jsp").forward(req,resp);
        //resp.sendRedirect(req.getContextPath()+"/admin.jsp");

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserJdbcDAO userJdbcDAO = new UserJdbcDAO();
        userJdbcDAO.createTable();
    }
}
