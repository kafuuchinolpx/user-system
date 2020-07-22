package cn.hxzy.servlet;

import cn.hxzy.entity.Role;
import cn.hxzy.service.RoleService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/roleEdit")
public class RoleEditServlet extends HttpServlet {
    private RoleService roleService = new RoleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            if (id != null && id != "") {
                Role byId = roleService.findById(Integer.parseInt(id));
                req.setAttribute("role",byId);
            }
            List<Role> all = roleService.findAll();
            req.setAttribute("roleList", all);
            req.getRequestDispatcher("/WEB-INF/jsp/roleEdit.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String remark = req.getParameter("remark");
            if (id != null && id != "") {
                Role role = new Role(name, remark);
                role.setId(Integer.parseInt(id));
                roleService.update(role);
            } else {
                roleService.add(new Role(name, remark));
            }
            resp.sendRedirect("role");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}