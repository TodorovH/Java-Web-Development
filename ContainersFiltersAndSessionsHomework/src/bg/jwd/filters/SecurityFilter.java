package bg.jwd.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/pages/HomePage.jsp")
public class SecurityFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if (userName != null && password != null){
			if (userName.equals("admin") && password.equals("admin")){
				httpRequest.getSession().setAttribute("loggedUser", userName);
				httpResponse.sendRedirect("/ContainersFiltersAndSessionsHomework/pages/HomePage.jsp");
			} else {
				httpResponse.sendRedirect("/ContainersFiltersAndSessionsHomework/pages/LoginForm.jsp");
			}
		} else {
			String user = (String) httpRequest.getSession().getAttribute("loggedUser");
			if (user == null){
				httpResponse.sendRedirect("/ContainersFiltersAndSessionsHomework/pages/LoginForm.jsp");
			}
			
		}
		
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
