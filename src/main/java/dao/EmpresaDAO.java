package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

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

	public void atualizar(Empresa empresa) {
		String sql = "UPDATE empresa SET nomerazao = ?, apelidofantasia = ?, cpfCnpj = ?, "
				+ "bairro = ?, cep = ?, cidade = ?, pais = ?, estado = ?, logradouro = ?, "
				+ "contato01 = ?, contato02 = ?, email = ?, emailFinanceiro = ? WHERE id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, empresa.getNomeRazao());
			ps.setString(2, empresa.getApelidoFantasia());
			ps.setString(3, empresa.getCpfCnpj());
			ps.setString(4, empresa.getBairro());
			ps.setString(5, empresa.getCep());
			ps.setString(6, empresa.getCidade());
			ps.setString(7, empresa.getPais());
			ps.setString(8, empresa.getEstado());
			ps.setString(9, empresa.getLogradouro());
			ps.setString(10, empresa.getContato01());
			ps.setString(11, empresa.getContato02());
			ps.setString(12, empresa.getEmail());
			ps.setString(13, empresa.getEmailFinanceiro());
			ps.setString(14, empresa.getId());

			ps.executeUpdate();
			System.out.println("Empresa atualizada com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao atualizar empresa: " + e.getMessage());
		}
	}

	public List<Empresa> listar() {
		List<Empresa> empresas = new ArrayList<>();
		String sql = "SELECT * FROM empresa";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			var rs = ps.executeQuery();

			while (rs.next()) {
				Empresa e = new Empresa();
				e.setId(rs.getString("id"));
				e.setNomeRazao(rs.getString("nomerazao"));
				e.setApelidoFantasia(rs.getString("apelidofantasia"));
				e.setCpfCnpj(rs.getString("cpfCnpj"));
				e.setBairro(rs.getString("bairro"));
				e.setCep(rs.getString("cep"));
				e.setCidade(rs.getString("cidade"));
				e.setPais(rs.getString("pais"));
				e.setEstado(rs.getString("estado"));
				e.setLogradouro(rs.getString("logradouro"));
				e.setContato01(rs.getString("contato01"));
				e.setContato02(rs.getString("contato02"));
				e.setEmail(rs.getString("email"));
				e.setEmailFinanceiro(rs.getString("emailFinanceiro"));

				empresas.add(e);
			}
		} catch (Exception e) {
			System.out.println("Erro ao listar empresas: " + e.getMessage());
		}
		return empresas;
	}

	public Empresa listarPorId(String id) {
		String sql = "SELECT * FROM empresa WHERE id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			var rs = ps.executeQuery();

			if (rs.next()) {
				Empresa e = new Empresa();
				e.setId(rs.getString("id"));
				e.setNomeRazao(rs.getString("nomerazao"));
				e.setApelidoFantasia(rs.getString("apelidofantasia"));
				e.setCpfCnpj(rs.getString("cpfCnpj"));
				e.setBairro(rs.getString("bairro"));
				e.setCep(rs.getString("cep"));
				e.setCidade(rs.getString("cidade"));
				e.setPais(rs.getString("pais"));
				e.setEstado(rs.getString("estado"));
				e.setLogradouro(rs.getString("logradouro"));
				e.setContato01(rs.getString("contato01"));
				e.setContato02(rs.getString("contato02"));
				e.setEmail(rs.getString("email"));
				e.setEmailFinanceiro(rs.getString("emailFinanceiro"));

				return e;
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar empresa por ID: " + e.getMessage());
		}
		return null;
	}


	public void inativar(String id) {
		String sql = "UPDATE empresa SET ativo = false WHERE id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();

			System.out.println("Empresa inativada com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao inativar empresa: " + e.getMessage());
		}
	}
}