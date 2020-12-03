package money_add_operation;

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

/**
 * Servlet Filter implementation class moneyAddFilter
 */
@WebFilter("/AddMoney")
public class moneyAddFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("bankAccount.jsp");

		float money;
		String value = req.getParameter("moneyAddTextArea");
		User user = (User) session.getAttribute("user");
		String info = null;

		try {
			money = Float.parseFloat(value);
		} catch (Exception e) {
			info = "Value must be a number";
			req.setAttribute("infoAdd", info);
			requestDispatcher.forward(req, response);
			return;
		}

		if (money <= 0) {
			info = "Value cannot be negative";
		} else {
			if (money >= 1000000000) {
				info = "Value cannot be greater than 1.000.000.000 USD";
			} else {
				chain.doFilter(request, response);
				return;
			}
		}
		
		req.setAttribute("infoAdd", info);
		requestDispatcher.forward(req, response);
		return;
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
