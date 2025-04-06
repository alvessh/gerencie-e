package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DatabaseConnection;
import model.Usuario;

public class UsuarioDAO {

	public void cadastrar(Usuario usuario) {
		String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";

		try {

			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
		}
	}

	public List<Usuario> listar() {
		List<Usuario> usuarios = new ArrayList<>();
		String sql = "SELECT * FROM usuarios";

		try {

			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuarios.add(usuario);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao listar usuários: " + e.getMessage());
		}

		return usuarios;
	}

	public Usuario buscarPorId(int id) {
		Usuario usuario = null;
		String sql = "SELECT * FROM usuarios WHERE id = ?";

		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
			}

		} catch (SQLException e) {
			System.out.println("Erro ao buscar usuário por ID: " + e.getMessage());
		}

		return usuario;
	}

	public void atualizar(Usuario usuario) {
		String sql = "UPDATE usuarios SET nome = ?, email = ?, senha = ? WHERE id = ?";

		try {
			
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.setInt(4, usuario.getId());
			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar usuário: " + e.getMessage());
		}
	}

	public void excluir(int id) {
		String sql = "DELETE FROM usuarios WHERE id = ?";

		try {
			
			Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro ao excluir usuário: " + e.getMessage());
		}
	}
}