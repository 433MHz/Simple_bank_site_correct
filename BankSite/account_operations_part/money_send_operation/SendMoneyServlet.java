package money_send_operation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import used_by_all.User;
import userDAO.GetUserDAO;
import userDAO.UpdateMoneyDAO;

@WebServlet("/SendMoney")
public class SendMoneyServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("bankAccount.jsp");
		HttpSession session = request.getSession();

		String reciverName = (request.getParameter("reciverNameMoneyTransfer"));
		User reciver = GetUserDAO.get(reciverName);
		User sender = (User) session.getAttribute("user");
		float money = Float.parseFloat(request.getParameter("moneyAmountMoneyTransfer"));

		sender.setMoney(sender.getMoney() - money);
		reciver.setMoney(reciver.getMoney() + money);

		request.setAttribute("infoSend", "Sended");

		try {
			UpdateMoneyDAO.update(sender);
			UpdateMoneyDAO.update(reciver);
		} catch (Exception e) {
			request.setAttribute("infoSend", "Error");
		}

		requestDispatcher.forward(request, response);
	}
}
