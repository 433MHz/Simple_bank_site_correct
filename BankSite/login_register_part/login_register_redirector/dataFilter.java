package login_register_redirector;

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

import used_by_all.User;
import userDAO.AddUserDAO;
import userDAO.GetUserDAO;
import userDAO.IsUserDAO;

/**
 * Servlet Filter implementation class loginLengthFilter
 */
@WebFilter("/LoginRegisterRedirectorServlet")
public class dataFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String login = req.getParameter("loginText");
		String password = req.getParameter("passwordText");
		String info = null;
		boolean register = false;

		if (request.getParameter("LoginButton") != null) {
			register = false;
		} else if ((request.getParameter("RegisterButton") != null)) {
			register = true;
		}

		if (register == true) {
			if (login.length() >= 6) {
				if (login.length() <= 30) {
					if (password.length() >= 6) {
						if (password.length() <= 30) {
							if (!IsUserDAO.check(login)) {
								req.setAttribute("redirectToRegister", register);
								chain.doFilter(req, response);
								return;
							} else {
								info = "User name is already taken";
							}
						} else {
							info = "Password must be shorter than 31 digits";
						}
					} else {
						info = "Password must be longer than 5 digits";
					}
				} else {
					info = "Login must be shorter than 31 digits";
				}
			} else {
				info = "Login must be longer than 5 digits";
			}
		} else {
			if (IsUserDAO.check(login)) {
				User user = GetUserDAO.get(login);
				if (user.getPassword().equals(password)) {
					req.setAttribute("redirectToRegister", register);
					req.setAttribute("user", user);
					chain.doFilter(req, response);
					return;
				}

				else {
					info = "Password is incorrect";
				}
			}

			else {
				info = "This login is not registered";
			}
		}

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
		req.setAttribute("indexInfo", info);
		requestDispatcher.forward(req, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
