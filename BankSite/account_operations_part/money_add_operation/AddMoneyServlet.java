package money_add_operation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import used_by_all.DataHolder;
import used_by_all.User;

@WebServlet("/AddMoney")
public class AddMoneyServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("bankAccount.jsp");
		HttpSession session = request.getSession();
		DataHolder dataHolder;
		dataHolder = AddMoney.add(request.getParameter("moneyAddTextArea"), (User) session.getAttribute("user"));

		request.setAttribute("infoAdd", dataHolder.getMessage());
		requestDispatcher.forward(request, response);
	}
}
