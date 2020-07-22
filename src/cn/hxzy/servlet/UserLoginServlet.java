package cn.hxzy.servlet;

import cn.hxzy.dao.UserDao;
import cn.hxzy.entity.Role;
import cn.hxzy.entity.User;
import cn.hxzy.service.RoleService;
import cn.hxzy.service.UserService;
import cn.hxzy.util.VerifyUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    @Override()
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoleService roleService=new RoleService();
        UserService userService = new UserService();
        try {
            String verify = req.getParameter("verify");
            if (verify != null && verify != "") {
                Object attribute = req.getSession().getAttribute(VerifyUtil.RANDOMCODEKEY);
                if (verify.equals(attribute)) {
                    String loginName = req.getParameter("loginName");
                    String loginPassword = req.getParameter("loginPassword");
                    User user = userService.login(loginName, loginPassword);
                    if (user != null) {
                        req.getSession().setAttribute("loginUser", user);
                        Role role = roleService.findByIdWithResource(user.getRoleId());
                        req.getSession().setAttribute("loginRole", role);
                        resp.sendRedirect("index");
                        System.out.println("有用户登录,账户名:" + user.getName());
                        return;
                    }
                }
                req.setAttribute("prompt","账号或密码错误,请检查您的账号或密码");
                req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
            }
            resp.sendRedirect("/WEB-INF/jsp/login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
