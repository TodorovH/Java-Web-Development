package bg.jwd.ejb;

import java.math.BigDecimal;
import java.util.TreeMap;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import javax.ejb.Singleton;

@Singleton
public class BankOperations implements iBankOperations{
	TreeMap<String, TreeMap<String, Object>> accounts = new TreeMap<String, TreeMap<String, Object>>();
	BigDecimal sessionAmount = BigDecimal.ZERO;
	boolean wasDepositBeforeWithdraw = false;
	
	@Override
	public TreeMap<String, TreeMap<String, Object>> init() {
		
		accounts.put("admin",new TreeMap<String, Object>());
		
		accounts.get("admin").put("password", "admin");
		accounts.get("admin").put("amount", new BigDecimal(3000));
		accounts.get("admin").put("currency", "bgn");
		
		accounts.put("user",new TreeMap<String, Object>());
		
		accounts.get("user").put("password", "user");
		accounts.get("user").put("amount", new BigDecimal(53000));
		accounts.get("user").put("currency", "euro");
		
		return accounts;
	}

	@Override
	public boolean isUsernameAndPasswordOK(String username, String password) {
		if (accounts.containsKey(username) && accounts.get(username).get("password").equals(password)){
			return true;
		}
		return false;
	}
	
	@Override
	public void getAccountData(String username, HttpServletRequest request){
		BigDecimal account_amount = (BigDecimal) accounts.get(username).get("amount");
		BigDecimal halfAmount = account_amount.divide(new BigDecimal(2));
		String account_currency = (String) accounts.get(username).get("currency");
		
		request.getSession().setAttribute("account_amount", String.format("%.2f", account_amount));
		if (account_currency.equals("bgn")){
			request.getSession().setAttribute("account_currency", account_currency.toUpperCase());
		} else {
			request.getSession().setAttribute("account_currency", account_currency);
		}
		if (request.getSession().getAttribute("half_amount") == null || wasDepositBeforeWithdraw == true){
			request.getSession().setAttribute("half_amount", halfAmount.toString());
		}
	}

	@Override
	public void depositWithdraw(HttpServletRequest request){
		String operation = request.getParameter("operation");
		String currency = request.getParameter("currency");
		BigDecimal amountToChange = BigDecimal.ZERO;
		BigDecimal amount = new BigDecimal((String)request.getSession().getAttribute("account_amount"));
		BigDecimal halfAmount = new BigDecimal((String)request.getSession().getAttribute("half_amount"));
		String amount_currency = ((String)request.getSession().getAttribute("account_currency")).toLowerCase();
		String user = (String)request.getSession().getAttribute("username");
		
		if (request.getParameter("amount_to_change") != null){
			try {
				amountToChange = new BigDecimal(request.getParameter("amount_to_change"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (amountToChange.compareTo(BigDecimal.ZERO) > 0){
				if (operation.equals("deposit")){
					if (!currency.equals(amount_currency)){
						switch (amount_currency){
							case "bgn": 
								if (currency.equals("$")){
									amountToChange = amountToChange.multiply(new BigDecimal(1.74));
								} else {
									amountToChange = amountToChange.multiply(new BigDecimal(1.95));
								}
								break;
							case "&dollar;": 
								if (currency.equals("bgn")){
									amountToChange = amountToChange.multiply(new BigDecimal(0.58));
								} else {
									amountToChange = amountToChange.multiply(new BigDecimal(1.12));
								}
								break;
							default: 
								if (currency.equals("bgn")){
									amountToChange = amountToChange.multiply(new BigDecimal(0.51));
								} else {
									amountToChange = amountToChange.multiply(new BigDecimal(0.89));
								}
								break;
						}
					}
					amount = amount.add(amountToChange);
					wasDepositBeforeWithdraw = true;
					
					accounts.get(user).put("amount", amount);
					
				} else if (operation.equals("withdraw") && amount.compareTo(BigDecimal.ZERO) > 0){
					if (!currency.equals(amount_currency)){
						switch (amount_currency){
							case "bgn": 
								if (currency.equals("$")){
									amountToChange = amountToChange.multiply(new BigDecimal(1.74));
								} else {
									amountToChange = amountToChange.multiply(new BigDecimal(1.95));
								}
								break;
							case "&dollar;": 
								if (currency.equals("bgn")){
									amountToChange = amountToChange.multiply(new BigDecimal(0.58));
								} else {
									amountToChange = amountToChange.multiply(new BigDecimal(1.12));
								}
								break;
							default: 
								if (currency.equals("bgn")){
									amountToChange = amountToChange.multiply(new BigDecimal(0.51));
								} else {
									amountToChange = amountToChange.multiply(new BigDecimal(0.89));
								}
								break;
						}
					}
					
					if (amountToChange.compareTo(halfAmount) <= 0 && sessionAmount.compareTo(halfAmount) < 0 && sessionAmount.add(amountToChange).compareTo(halfAmount) <= 0){
						amount = amount.subtract(amountToChange);
						sessionAmount = sessionAmount.add(amountToChange);
						wasDepositBeforeWithdraw = false;
						
						accounts.get(user).put("amount", amount);
					}
				}
			}
		}

	}
}
