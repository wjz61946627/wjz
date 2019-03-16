package nwsuaf.filter;


import nwsuaf.util.UtilConfig;
import nwsuaf.util.Utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @auther LazyMan
 * @date 2019-03-16
 * @describe 过滤黑名单ip
 */
public class IPFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        for(String ip : clientsIp(servletRequest)){
            if(Utils.ipMatchSet(ip, UtilConfig.IP_BLACK_SET)){
                ((HttpServletResponse) servletResponse).sendRedirect("/forbid/ip");
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private Set<String> clientsIp(ServletRequest servletRequest) {
        Set<String> result = new HashSet<String>();
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String ip = request.getHeader("x-forwarded-for");
        if (ip != null) {
            result.addAll(Arrays.asList(ip.split(",")));
        }

        ip = request.getHeader("Proxy-Client-IP");
        if(ip != null){
            result.add(ip);
        }

        ip = request.getHeader("WL-Proxy-Client-IP");
        if(ip != null){
            result.add(ip);
        }

        ip = request.getRemoteAddr();
        if(ip != null){
            result.add(ip);
        }

        return result;
    }

}
