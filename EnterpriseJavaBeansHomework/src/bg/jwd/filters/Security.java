package bg.jwd.filters;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bg.jwd.ejb.iBankOperations;
import bg.jwd.ejb.BankOperations;

@WebFilter("/pages/HomePage.jsp")
public class Security implements Filter {
	
	@EJB
	private iBankOperations iBankOperations;

    public Security() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		iBankOperations.init();
		
		if (username != null && password != null){
			if (iBankOperations.isUsernameAndPasswordOK(username, password) == true){
				((HttpServletRequest) request).getSession().setAttribute("username", username);
				((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/home");
			} else {
				((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/login");
			}
		} else {
			String userName = (String)((HttpServletRequest) request).getSession().getAttribute("username");
			if (userName == null){
				((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/login");
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
