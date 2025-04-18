package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/example"
			+ "?allowPublicKeyRetrieval=true&useSSL=false";
	private static final String USER = "example";
	private static final String PASSWORD = "example";

	public static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conexão com o banco de dados estabelecida com sucesso! hehe");
			return conn;
		} catch (SQLException e) {
			System.out.println("Falha ao conectar ao banco de dados: " + e.getMessage());
			return null;
		}
	}
}