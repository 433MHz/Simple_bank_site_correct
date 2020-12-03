package register_new_user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import used_by_all.User;
import userDAO.AddUserDAO;

@WebServlet("/RegisterServlet")
public class RegisterSerlvet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");

		String login = request.getParameter("loginText"); 
		String password = request.getParameter("passwordText");
		
		User user = new User();
		
		user.setName(login);
		user.setPassword(password);
		user.setMoney(0);
		AddUserDAO.add(user);
		
		request.setAttribute("indexInfo", "User created");
		requestDispatcher.forward(request, response);
	}
}
