package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Usuario;

public class UsuarioDAO {
	private Connection conn;

	public UsuarioDAO(Connection conn) {
		this.conn = conn;
	}

	public void cadastrar(Usuario usuario) {
		String sql = "INSERT INTO usuario (id, email, senha, id_empresa) VALUES (?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getId());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getIdEmpresa());
			ps.executeUpdate();
			
			System.out.println("Usuário cadastrado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
		}
	}
}