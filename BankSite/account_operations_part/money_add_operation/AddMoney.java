package money_add_operation;

import operations_history.OperationsHistory;
import used_by_all.DataHolder;
import used_by_all.User;

public class AddMoney {
	public static DataHolder add(String value, User user) {

		float money;
		DataHolder dataHolder = new DataHolder();
		OperationsHistory operationHistory;

		try {
			money = Float.parseFloat(value);
		} catch (Exception e) {
			dataHolder.set("Value must be a number", false);
			return dataHolder;
		}

		if (money <= 0) {
			dataHolder.set("Value cannot be negative", false);
			return dataHolder;
		} else {
			if (money >= 1000000000) {
				dataHolder.set("Value cannot be greater than 1.000.000.000 USD", false);
				return dataHolder;
			} else {
				float userMoney = user.getMoney();
				userMoney = userMoney + money;
				user.setMoney(userMoney);
				operationHistory = user.getOperationsHistory();
				operationHistory.putIn(userMoney);
				dataHolder.set("Added", true);
				return dataHolder;
			}
		}
	}
}
