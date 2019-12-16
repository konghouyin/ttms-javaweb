package xupt.se.ttms.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "optionsFilter", urlPatterns = { "/*" })
public class optionsFilter  implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(!((HttpServletRequest) request).getMethod().equals("OPTIONS")) {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {

	}
}
