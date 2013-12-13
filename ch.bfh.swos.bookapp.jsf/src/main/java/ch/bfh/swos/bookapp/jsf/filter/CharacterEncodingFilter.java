package ch.bfh.swos.bookapp.jsf.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.Serializable;

public class CharacterEncodingFilter implements Filter, Serializable {
    private static final long serialVersionUID = -4246457499875267088L;

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void destroy() {
    }

}
