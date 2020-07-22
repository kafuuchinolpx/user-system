package cn.hxzy.servlet;

import cn.hxzy.service.RoleService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/authorize")
public class RoleAuthorizeServlet extends HttpServlet {
    RoleService roleService = new RoleService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String resourceId = req.getParameter("resourceId");
            String roleId = req.getParameter("roleId");
            roleService.authorize(resourceId, roleId);
            PrintWriter writer = resp.getWriter();
            Map map = new HashMap();
            map.put("code", 200);
            map.put("msg", "成功!");
            writer.write(JSON.toJSONString(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
