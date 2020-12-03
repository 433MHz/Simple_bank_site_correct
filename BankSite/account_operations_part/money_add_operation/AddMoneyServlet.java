package money_add_operation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import used_by_all.User;
import userDAO.UpdateMoneyDAO;

@WebServlet("/AddMoney")
public class AddMoneyServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("bankAccount.jsp");
		HttpSession session = request.getSession();
		float money = Float.parseFloat(request.getParameter("moneyAddTextArea"));
		User user = (User) session.getAttribute("user");

		float userMoney = user.getMoney();
		userMoney = userMoney + money;
		user.setMoney(userMoney);
		request.setAttribute("infoAdd", "Added");
		
		try {
			UpdateMoneyDAO.update(user);
		} catch (Exception e) {
			request.setAttribute("infoAdd", "Error");
		}
		
		requestDispatcher.forward(request, response);
	}
}
