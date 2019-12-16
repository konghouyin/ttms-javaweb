package xupt.se.ttms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "optionsFilter", urlPatterns = { "/*" })
public class optionsFilter  implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(!((HttpServletRequest) request).getMethod().equals("OPTIONS")) {
			chain.doFilter(request, response);
		}
	}
}
