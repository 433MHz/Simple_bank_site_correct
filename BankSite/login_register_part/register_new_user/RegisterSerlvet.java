package register_new_user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import used_by_all.DataHolder;

@WebServlet("/RegisterServlet")
public class RegisterSerlvet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");

		DataHolder dataHolder = createUser.addNew(request.getParameter("loginText"),
				request.getParameter("passwordText"));
		request.setAttribute("indexInfo", dataHolder.getMessage());
		requestDispatcher.forward(request, response);
	}
}
