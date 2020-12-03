package money_send_operation;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import used_by_all.User;
import userDAO.GetUserDAO;
import userDAO.IsUserDAO;

@WebFilter("/SendMoney")
public class moneySendFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("bankAccount.jsp");

		User sender = (User) session.getAttribute("user");
		sender = GetUserDAO.get(sender.getName());
		
		float money = 0;
		String value = req.getParameter("moneyAmountMoneyTransfer");
		String reciverName = req.getParameter("reciverNameMoneyTransfer");
		String info = null;

		if (IsUserDAO.check(reciverName)) {
			try {
				money = Float.parseFloat(value);
			} catch (Exception e) {
				info = "Value must be a number";
				req.setAttribute("infoSend", info);
				requestDispatcher.forward(req, response);
				return;
			}

			if (sender.getMoney() >= money) {
				if (money >= 0) {
					if (money >= 1000000000) {
						info = "Value cannot be greater than 1.000.000.000 USD";
					} else {
						chain.doFilter(request, response);
						return;
					}
				} else {
					info = "You can't send negative value";
				}
			} else {
				info = "You don't have enought money";
			}

		} else {
			info = "Reciver name don't exist";
		}
		req.setAttribute("infoSend", info);
		requestDispatcher.forward(req, response);
		return;
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
