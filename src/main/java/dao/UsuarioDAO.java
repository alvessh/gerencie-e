package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

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

	public void atualizar(Usuario usuario) {
		String sql = "UPDATE usuario SET email = ?, senha = ?, id_empresa = ? WHERE id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getSenha());
			ps.setString(3, usuario.getIdEmpresa());
			ps.setString(4, usuario.getId());
			ps.executeUpdate();

			System.out.println("Usuário atualizado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao atualizar usuário: " + e.getMessage());
		}
	}

	public List<Usuario> listar() {
		List<Usuario> usuarios = new ArrayList<>();
		String sql = "SELECT * FROM usuario";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			var rs = ps.executeQuery();

			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getString("id"));
				u.setEmail(rs.getString("email"));
				u.setSenha(rs.getString("senha"));
				u.setIdEmpresa(rs.getString("id_empresa"));

				usuarios.add(u);
			}
		} catch (Exception e) {
			System.out.println("Erro ao listar usuários: " + e.getMessage());
		}
		return usuarios;
	}


	public Usuario listarPorId(String id) {
		String sql = "SELECT * FROM usuario WHERE id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			var rs = ps.executeQuery();

			if (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getString("id"));
				u.setEmail(rs.getString("email"));
				u.setSenha(rs.getString("senha"));
				u.setIdEmpresa(rs.getString("id_empresa"));

				return u;
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar usuário por ID: " + e.getMessage());
		}
		return null;
	}

	public void inativar(String id) {
		String sql = "UPDATE usuario SET ativo = false WHERE id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();

			System.out.println("Usuário inativado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao inativar usuário: " + e.getMessage());
		}
	}
	
	public Usuario buscarPorEmailESenha(String email, String senha) {
		String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, senha);
			var rs = ps.executeQuery();

			if (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getString("id"));
				u.setEmail(rs.getString("email"));
				u.setSenha(rs.getString("senha"));
				u.setIdEmpresa(rs.getString("id_empresa"));
				return u;
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar usuário: " + e.getMessage());
		}
		return null;
	}
}