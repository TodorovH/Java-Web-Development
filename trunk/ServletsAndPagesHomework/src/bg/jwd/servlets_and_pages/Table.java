package bg.jwd.servlets_and_pages;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Table")
public class Table extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Table() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().println(formatTable());
	}
	
	private String formatTable() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<table border='1'>");
		sb.append("<thead>");
		sb.append("<tr>");
		sb.append("<th>Topic</th>");
		sb.append("<th>Date</th>");
		sb.append("</tr>");
		sb.append("</thead>");
		sb.append("<tbody>");
		sb.append("<tr>");
		sb.append("<td>Web Basics</td>");
		sb.append("<td>" + new Date() + "</td>");
		sb.append("</tr>");
		sb.append("</tbody>");
		sb.append("</table>");
		
		return sb.toString();
	}
}
