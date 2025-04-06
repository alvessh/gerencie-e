package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Empresa;

public class EmpresaDAO {
	private Connection conn;
	
	public EmpresaDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void cadastrar(Empresa empresa) {
		String sql = "INSERT INTO empresa (id, nomerazao, apelidofantasia, cpfCnpj, "
				+ "bairro, cep, cidade, pais, estado, logradouro, contato01, "
				+ "contato02, email, emailFinanceiro)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, empresa.getId());
			ps.setString(2, empresa.getNomeRazao());
			ps.setString(3, empresa.getApelidoFantasia());
			ps.setString(4, empresa.getCpfCnpj());
			ps.setString(5, empresa.getBairro());
			ps.setString(6, empresa.getCep());
			ps.setString(7, empresa.getCidade());
			ps.setString(8, empresa.getPais());
			ps.setString(9, empresa.getEstado());
			ps.setString(10, empresa.getLogradouro());
			ps.setString(11, empresa.getContato01());
			ps.setString(12, empresa.getContato02());
			ps.setString(13, empresa.getEmail());
			ps.setString(14, empresa.getEmailFinanceiro());
			
			ps.executeUpdate();
			
			System.out.println("Empresa cadastrada com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar empresa: " + e.getMessage());
		}
	}
}