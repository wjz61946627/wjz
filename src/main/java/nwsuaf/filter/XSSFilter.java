package nwsuaf.filter;


import org.apache.commons.text.StringEscapeUtils;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @auther LazyMan
 * @date 2019-03-16
 * @describe 过滤脚本字符
 */
public class XSSFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 过滤所有字符类参数
        Enumeration<String> names = servletRequest.getAttributeNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            Object value = servletRequest.getAttribute(name);
            if (value instanceof String) {
                value = convertString(String.valueOf(value));
                servletRequest.setAttribute(name, value);
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String convertString(String param) {
        String result = param;
        result = StringEscapeUtils.escapeHtml3(result);
        result = StringEscapeUtils.escapeHtml4(result);

        result = StringEscapeUtils.escapeXml10(result);
        result = StringEscapeUtils.escapeXml11(result);
        result = StringEscapeUtils.escapeXSI(result);

        result = StringEscapeUtils.escapeEcmaScript(result);
        result = StringEscapeUtils.escapeJava(result);

        return result;
    }
}
