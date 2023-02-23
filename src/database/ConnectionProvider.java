package database;

import java.sql.*;

public class ConnectionProvider {
	public static Connection getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:sqlserver://examinationportal.database.windows.net:1433;database=qems",
					"TeamTitans@examinationportal", "Titans@22");
			return con;

		} catch (Exception e) {
			System.out.println("Failed");
			return null;
		}
	}
}
