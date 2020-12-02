package money_send_operation;

import operations_history.OperationsHistory;
import used_by_all.DataHolder;
import used_by_all.User;
import userDAO.GetUserDAO;
import userDAO.IsUserDAO;

public class SendMoney {

	public static DataHolder send(User sender, String reciverName, String value) {
		DataHolder dataHolder = new DataHolder();
		OperationsHistory operationHistory;
		User reciver;
		float money;
		if (IsUserDAO.check(reciverName)) {
			reciver = GetUserDAO.get(reciverName);

			try {
				money = Float.parseFloat(value);
			} catch (Exception e) {
				dataHolder.set("Value must be a number", false);
				return dataHolder;
			}

			if (sender.getMoney() >= money) {
				if (money >= 0) {
					if (money >= 1000000000) {
						dataHolder.set("Value cannot be greater than 1.000.000.000 USD", false);
						return dataHolder;
					} else {
						sender.setMoney(sender.getMoney() - money);
						reciver.setMoney(reciver.getMoney() + money);
						operationHistory = sender.getOperationsHistory();
						operationHistory.putIn(sender.getName(), reciver.getName(), money, "SEND");
						operationHistory = reciver.getOperationsHistory();
						operationHistory.putIn(sender.getName(), reciver.getName(), money, "GET");
						dataHolder.set("Sended", true);
						return dataHolder;
					}
				} else {
					dataHolder.set("You can't send negative value", false);
					return dataHolder;
				}
			} else {
				dataHolder.set("You don't have enought money", false);
				return dataHolder;
			}

		} else {
			dataHolder.set("Reciver name don't exist", false);
			return dataHolder;
		}
	}
}
