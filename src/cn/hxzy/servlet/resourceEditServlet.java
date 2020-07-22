package cn.hxzy.servlet;

import cn.hxzy.entity.Resource;
import cn.hxzy.service.ResourceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/resourceEdit")
public class resourceEditServlet extends HttpServlet {
    ResourceService resourceService=new ResourceService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            if (id!=null&&id!=""){
                Resource byId = resourceService.findById(Integer.parseInt(id));
                req.setAttribute("resource",byId);
            }
            req.setAttribute("resourceList",resourceService.findAll());
            req.getRequestDispatcher("WEB-INF/jsp/resourceEdit.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String url = req.getParameter("url");
            String pid = req.getParameter("pid");
            if (id!=null&&id!=""){
                Resource resource = new Resource(name,url,Integer.parseInt(pid));
                resource.setId(Integer.parseInt(id));
                resourceService.update(resource);
            }else {
                resourceService.add(new Resource(name,url,Integer.parseInt(pid)));
            }
            resp.sendRedirect("resource");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
