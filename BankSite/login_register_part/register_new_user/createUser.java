package register_new_user;

import used_by_all.DataHolder;
import used_by_all.User;
import userDAO.AddUserDAO;
import userDAO.IsUserDAO;

public class createUser {
	public static DataHolder addNew(String login, String password) {
		User user = new User();
		DataHolder dataHolder = new DataHolder();

		if (login.length() >= 6) {
			if (login.length() <= 30) {
				if (password.length() >= 6) {
					if (password.length() <= 30) {
						if (!IsUserDAO.check(login)) {
							user.setName(login);
							user.setPassword(password);
							user.setMoney(0);
							AddUserDAO.add(user);
							dataHolder.set("User created", true);
							return dataHolder;
						} else {
							dataHolder.set("User name is already taken", false);
							return dataHolder;
						}
					} else {
						dataHolder.set("Password must be shorter than 31 digits", false);
						return dataHolder;
					}
				} else {
					dataHolder.set("Password must be longer than 5 digits", false);
					return dataHolder;
				}
			} else {
				dataHolder.set("Login must be shorter than 31 digits", false);
				return dataHolder;
			}
		} else {
			dataHolder.set("Login must be longer than 5 digits", false);
			return dataHolder;
		}
	}
}
