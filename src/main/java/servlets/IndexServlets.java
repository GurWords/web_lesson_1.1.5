package servlets;

import service.UserImplService.UsersService;
import dao.userdao.UserJdbcDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlets extends HttpServlet {
    @Override
    public void init() throws ServletException {
        UserJdbcDAO userJdbcDAO = new UserJdbcDAO();
        userJdbcDAO.createTable();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String role = UsersService.getInstance().getRoleByName(req.getParameter("name"));
        httpSession.setAttribute("name",req.getParameter("name"));
        httpSession.setAttribute("role",role);
        if (role != null && role.equals("admin")){
            resp.sendRedirect(req.getContextPath()+"/admin");
            //getServletContext().getRequestDispatcher("/admin").forward(req,resp);
        }
        if (role != null && role.equals("user")){
            resp.sendRedirect(req.getContextPath()+"/user");
            //req.getRequestDispatcher("/user").forward(req,resp);
        }
    }
}
