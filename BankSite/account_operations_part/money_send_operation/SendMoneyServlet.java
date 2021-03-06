package money_send_operation;

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

@WebServlet("/SendMoney")
public class SendMoneyServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("bankAccount.jsp");
		HttpSession session = request.getSession();

		DataHolder dataHolder = SendMoney.send((User) session.getAttribute("user"),
				request.getParameter("reciverNameMoneyTransfer"), request.getParameter("moneyAmountMoneyTransfer"));

		request.setAttribute("infoSend", dataHolder.getMessage());
		requestDispatcher.forward(request, response);
	}
}
