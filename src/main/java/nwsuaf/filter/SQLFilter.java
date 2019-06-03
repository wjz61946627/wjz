package nwsuaf.filter;


import nwsuaf.util.Utils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * @auther LazyMan
 * @date 2019-03-16
 * @describe 过滤脚本字符
 */
public class SQLFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        for (String[] params : servletRequest.getParameterMap().values()) {
            for (String param : params) {
                if (checkError(param)) {
                    return;
                }
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean checkError(String param) {
        if (param.contains("=")) {
            return true;
        }

        return false;
    }
}
