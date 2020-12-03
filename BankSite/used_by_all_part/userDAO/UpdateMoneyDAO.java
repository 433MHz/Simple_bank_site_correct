package userDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import AllDAO.ConnectInfo;
import used_by_all.User;

public class UpdateMoneyDAO {
	public static void update(User user) throws Exception {
		String query = "UPDATE users SET money = " + user.getMoney() + "WHERE name = '" + user.getName() + "'"; 
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(ConnectInfo.url, ConnectInfo.userName, ConnectInfo.password);
		Statement st = con.createStatement();
		st.execute(query);
		
		st.close();
		con.close();
	}
}
