package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

	private static Connection conn;
	
	public static Connection getConnection() {

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(
					System.getenv("dburl"),
					System.getenv("dbusername"),
					System.getenv("password")
					);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
}