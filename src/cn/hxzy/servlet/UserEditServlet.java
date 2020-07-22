package cn.hxzy.servlet;

import cn.hxzy.entity.Role;
import cn.hxzy.entity.User;
import cn.hxzy.service.RoleService;
import cn.hxzy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userEdit")
public class UserEditServlet extends HttpServlet {
    private RoleService roleService = new RoleService();
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            if (id != null && id != "") {
                req.setAttribute("user", userService.findById(Integer.parseInt(id)));
            }
            List<Role> all = roleService.findAll();
            req.setAttribute("userList", all);
            req.getRequestDispatcher("/WEB-INF/jsp/userEdit.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String loginName = req.getParameter("loginName");
            String loginPassword = req.getParameter("loginPassword");
            String roleId = req.getParameter("roleId");
            if (id != null && id != "") {
                User user = new User(name, loginName, loginPassword, Integer.parseInt(roleId), "");
                user.setId(Integer.parseInt(id));
                userService.update(user);
            } else {
                userService.add(new User(name, loginName, loginPassword, Integer.parseInt(roleId), ""));
            }
            resp.sendRedirect("user");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}