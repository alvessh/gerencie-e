package test;

import java.sql.Connection;

import connection.DatabaseConnection;

public class TestDatabaseConnection {
	public static void main(String[] args) {
		Connection conn = DatabaseConnection.getConnection();

		if (conn != null) {
			System.out.println("Teste de conexão concluído com sucesso!");
			try {
				conn.close();
				System.out.println("Conexão encerrada.");
			} catch (Exception e) {
				System.out.println("Erro ao fechar conexão: " + e.getMessage());
			}
		} else {
			System.out.println("Não foi possível realizar a conexão.");
		}
	}
}
