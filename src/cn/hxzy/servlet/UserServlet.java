package cn.hxzy.servlet;

import cn.hxzy.entity.User;
import cn.hxzy.entity.vo.PageObj;
import cn.hxzy.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        try {
            String id = req.getParameter("id");
            if (id != null && id != "") {
                userService.deleteById(Integer.parseInt(id));
            }
            String name = req.getParameter("name");
            PageObj<User> pageObj = new PageObj<>();
            String page = req.getParameter("page");
            String size = req.getParameter("size");
            if (page != null && page != "") {
                pageObj.setPage(Integer.parseInt(page));
            }
            if (size != null && size != "") {
                pageObj.setSize(Integer.parseInt(size));
            }
            PageObj<User> all = userService.findAll(pageObj, name);
            req.setAttribute("users", all);
            req.getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
