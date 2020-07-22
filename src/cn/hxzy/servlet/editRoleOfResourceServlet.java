package cn.hxzy.servlet;

import cn.hxzy.entity.Resource;
import cn.hxzy.entity.Role;
import cn.hxzy.service.ResourceService;
import cn.hxzy.service.RoleService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/editRoleOfResource")
public class editRoleOfResourceServlet extends HttpServlet {
    RoleService roleService = new RoleService();
    ResourceService resourceService = new ResourceService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            if (id != null && id != "") {
                Role role = roleService.findByIdWithResource(Integer.parseInt(id));
                req.setAttribute("role", role);
                List<Resource> list = resourceService.findByRoleIdNotHave(Integer.parseInt(id));
                req.setAttribute("notHaveResources", list);
            }
            req.getRequestDispatcher("WEB-INF/jsp/editRoleOfResource.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
