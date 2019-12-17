package xupt.se.ttms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "AccessOrigin", urlPatterns = { "/*" }, initParams = {
		@WebInitParam(name = "origin", value = "http://localhost:8080") })
public class AccessOrigin implements Filter {
	private FilterConfig config = null;

	@Override
	public void init(FilterConfig config) {
		this.config = config;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		((HttpServletResponse) response).setCharacterEncoding("UTF-8");
		((HttpServletRequest) request).setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		String origin = config.getInitParameter("origin");
		((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin", origin);
		((HttpServletResponse) response).setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS");
		((HttpServletResponse) response).setHeader("Access-Control-Allow-Headers", "Content-type");
		((HttpServletResponse) response).setHeader("Content-type","application/json");
		
	}

	@Override
	public void destroy() {

	}

}
