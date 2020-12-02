package used_by_all;


import operations_history.OperationsHistory;

public class User {
	private String name;
	private String password;
	private float money;
	private OperationsHistory operationsHistory = new OperationsHistory();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public OperationsHistory getOperationsHistory() {
		return operationsHistory;
	}

	public void setOperationsHistory(OperationsHistory operationsHistory) {
		this.operationsHistory = operationsHistory;
	}
}
