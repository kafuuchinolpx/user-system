package cn.hxzy.servlet;

import cn.hxzy.entity.Role;
import cn.hxzy.entity.User;
import cn.hxzy.entity.vo.PageObj;
import cn.hxzy.service.RoleService;
import cn.hxzy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/role")
public class RoleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoleService roleService = new RoleService();
        try {
            String id = req.getParameter("id");
            if (id != null && id != "") {
                roleService.deleteById(Integer.parseInt(id));
            }
            List<Role> all = roleService.findAll();
            req.setAttribute("role", all);
            req.getRequestDispatcher("/WEB-INF/jsp/role.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
