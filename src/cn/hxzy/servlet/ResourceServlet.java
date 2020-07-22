package cn.hxzy.servlet;

import cn.hxzy.entity.Resource;
import cn.hxzy.service.ResourceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/resource")
public class ResourceServlet extends HttpServlet {

    ResourceService resourceService = new ResourceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            if (id != null && id != "") {
                resourceService.deleteById(Integer.parseInt(id));
            }
            List<Resource> all = resourceService.findAll();
            req.setAttribute("resourceList", all);
            req.getRequestDispatcher("WEB-INF/jsp/resource.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
