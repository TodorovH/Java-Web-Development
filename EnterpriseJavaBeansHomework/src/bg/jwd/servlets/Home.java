package bg.jwd.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import bg.jwd.ejb.iBankOperations;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Home() {
        super();
    }
    
    @EJB
    private iBankOperations iBankOperations;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String)((HttpServletRequest) request).getSession().getAttribute("username");
		
		iBankOperations.getAccountData(username, request);
		
		iBankOperations.depositWithdraw(request);
		
		iBankOperations.getAccountData(username, request);
		
		request.getRequestDispatcher("/pages/HomePage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
