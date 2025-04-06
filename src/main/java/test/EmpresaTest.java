package test;

import java.sql.Connection;

import connection.DatabaseConnection;
import dao.EmpresaDAO;
import model.Empresa;

public class EmpresaTest {
	public static void main(String[] args) {
		Connection conn = DatabaseConnection.getConnection();
		
		Empresa empresa = new Empresa();
		empresa.setNomeRazao("Arroz");
		empresa.setApelidoFantasia("Batata");
		empresa.setCpfCnpj("75.923.047/0001-26");
		empresa.setBairro("Sla");
		empresa.setCep("76970-000");
		empresa.setCidade("Pimenta Bueno");
		empresa.setEstado("RO");
		empresa.setLogradouro("Rua sla, numero 14");
		empresa.setContato01("3451-3451");
		empresa.setEmail("arroba@gmail.com");
		empresa.setPais("Brasil");
		
		EmpresaDAO empresaDAO = new EmpresaDAO(conn);
		empresaDAO.cadastrar(empresa);
	}
}
