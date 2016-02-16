package bg.jwd.listeners;

import java.util.Date;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestLogger implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent requestEvent) {
	}

	@Override
	public void requestInitialized(ServletRequestEvent requestEvent) {
		
		String ipAddress = requestEvent.getServletRequest().getLocalAddr();
		String sessionId = ((HttpServletRequest) requestEvent.getServletRequest()).getSession().getId();
		String requestType = ((HttpServletRequest) requestEvent.getServletRequest()).getMethod();
		String dateAndTime = (new Date()).toString();
		
		System.out.println("IP Address: " + ipAddress);
		System.out.println("Session ID: " + sessionId);
		System.out.println("Request Type: " + requestType);
		System.out.println("Date and time: " + dateAndTime);
	}

}
