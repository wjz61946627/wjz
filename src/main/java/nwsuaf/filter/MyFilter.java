package nwsuaf.filter;

import nwsuaf.model.User;
import nwsuaf.util.UtilConfig;
import nwsuaf.util.Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @auther LazyMan
 * @date 2019-06-03
 * @describe
 */
public class MyFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (!(servletRequest instanceof HttpServletRequest) || !(servletResponse instanceof HttpServletResponse)) {
            success(servletRequest, servletResponse, filterChain);
            return;
        }

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI();
        if (StringUtils.equals(uri, "/error.jsp")) {
            success(servletRequest, servletResponse, filterChain);
            return;
        }

        if (checkIp(request)) {
            response.sendRedirect("error.jsp");
            return;
        }

        if (StringUtils.equals(uri, "/") || StringUtils.equals("/user/sign", uri) || uri.startsWith("/resource")) {
            success(servletRequest, servletResponse, filterChain);
            return;
        }

        if (checkSession(request)) {
            error(response);
            return;
        }

        if (checkParam(request)) {
            error(response);
            return;
        }


        success(servletRequest, servletResponse, filterChain);
    }

    private void success(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void error(HttpServletResponse response) throws IOException {
        response.sendRedirect("/");
    }

    private boolean checkSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session == null) {
            return true;
        }

        if (session.getAttribute("user") == null) {
            return true;
        }

        return false;
    }

    private boolean checkParam(HttpServletRequest request) {
        for (String[] params : request.getParameterMap().values()) {
            for (String param : params) {
                if (param != null && param.matches("(=|<|>)+")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkIp(HttpServletRequest request) {
        for (String ip : clientsIp(request)) {
            if (Utils.ipMatchSet(ip, UtilConfig.IP_BLACK_SET)) {
                return true;
            }
        }

        return false;
    }

    private Set<String> clientsIp(HttpServletRequest request) {
        Set<String> result = new HashSet<String>();

        String ip = request.getHeader("x-forwarded-for");
        if (ip != null) {
            result.addAll(Arrays.asList(ip.split(",")));
        }

        ip = request.getHeader("Proxy-Client-IP");
        if (ip != null) {
            result.add(ip);
        }

        ip = request.getHeader("WL-Proxy-Client-IP");
        if (ip != null) {
            result.add(ip);
        }

        ip = request.getRemoteAddr();
        if (ip != null) {
            result.add(ip);
        }

        return result;
    }
}
