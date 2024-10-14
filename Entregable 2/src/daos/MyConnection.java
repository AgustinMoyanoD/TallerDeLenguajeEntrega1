package daos;

import java.sql.*;

public class MyConnection {
	private static Connection conn = null;
	
	static {
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:./src/BASE_ENTREGABLE.db");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() {
		return conn;
	}
	
	private MyConnection() {
		
	}
	
	public void close() {
		if (conn == null) {
			System.out.printf("Ya está cerrado!.\n");
		} else {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	public String getPath() {
		return this.path;
	}
	
	public Connection getConnection() {
		return this.conn;
	}
}
