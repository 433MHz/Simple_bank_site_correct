package userDAO;

import java.sql.*;

import AllDAO.ConnectInfo;

public class IsUserDAO {

	public static boolean check(String login) {
		String query = "select exists(select * from users where name = '" + login + "')";
		boolean res = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(ConnectInfo.url, ConnectInfo.userName,
					ConnectInfo.password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			if (rs.getInt(1) == 1) {
				res = true;
			}
			else {
				res = false;
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
