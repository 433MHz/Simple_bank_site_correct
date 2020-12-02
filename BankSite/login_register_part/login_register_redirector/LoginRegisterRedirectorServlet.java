package login_register_redirector;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginRegisterRedirectorServlet")
public class LoginRegisterRedirectorServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		/*
		 * If login button was clicked in index.jsp then go to LogInServlet. If register
		 * button then go to RegisterServlet.
		 */
		if (request.getParameter("LoginButton") != null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("LogInServlet");
			requestDispatcher.forward(request, response);
		} else if (request.getParameter("RegisterButton") != null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("RegisterServlet");
			requestDispatcher.forward(request, response);
		}
	}

}
