package cn.hxzy.servlet;

import cn.hxzy.service.RoleService;
import cn.hxzy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/RoleDelete")
public class RoleDeleteServlet extends HttpServlet {
    RoleService roleService = new RoleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            roleService.deleteById(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("role");
    }
}
