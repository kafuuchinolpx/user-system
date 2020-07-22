package cn.hxzy.filter;

import cn.hxzy.entity.Resource;
import cn.hxzy.entity.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取请求的uri  如：/项目名（contextPath）/user
        String requestURI = request.getRequestURI();
        if (requestURI.endsWith("login") || requestURI.endsWith("verify") || requestURI.endsWith("logout") || request.getRequestURI().endsWith(".css") || request.getRequestURI().endsWith(".js")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        //从session里面获取用户的角色
        Object loginRole = request.getSession().getAttribute("loginRole");
        if (loginRole != null) {//登录了
            Role role = (Role) loginRole;
            String[] split = requestURI.split("/");
            List<Resource> resources = role.getResources();
            String url = "/" + split[split.length - 1];
            System.out.println(url);
            //取出所拥有的资源的url
            List<String> collect = resources.stream().map(Resource::getUrl).collect(Collectors.toList());
            if (collect.contains(url)) {//资源的url集合是否包含当前的请求地址
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                response.sendRedirect("index");
            }

        } else {//未登录
            response.sendRedirect("login");
        }
    }

    @Override
    public void destroy() {

    }
}
