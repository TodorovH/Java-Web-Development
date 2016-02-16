package bg.jwd.servlets_and_pages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Form")
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Form() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().println(createForm());
	}

    private String createForm() {
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append("<html>");
    	sb.append("<head><title>").append("Form Servlet").append("</title></head>");
    	sb.append("<body><form>");
    	sb.append("<input placeholder='Id...' style='width: 300;' /><br>");
    	sb.append("<input placeholder='Topic...' style='width: 300;' /><br>");
    	sb.append("<input placeholder='Date...' style='width: 300;' /><br>");
    	sb.append("<button style='width: 150; height: 30;'>Submit</button>").append("<button style='width: 150; height: 30;'>Cancel</button>");
    	sb.append("</form></body></html>");
    	
    	return sb.toString();
    }
}
