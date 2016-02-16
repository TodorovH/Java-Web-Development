package bg.jwd.ejb;

import java.util.TreeMap;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

@Local
public interface iBankOperations {
	
	TreeMap<String, TreeMap<String, Object>> init();
	
	boolean isUsernameAndPasswordOK(String username, String password);
	
	void getAccountData(String username, HttpServletRequest request);
	
	void depositWithdraw(HttpServletRequest request);
}
