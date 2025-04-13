package test;

import java.sql.Connection;

import connection.DatabaseConnection;
import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioTest {
	public static void main(String[] args) {
		Connection conn = DatabaseConnection.getConnection();

		Usuario usuario = new Usuario();
		usuario.setEmail("usuario@empresa.com");
		usuario.setSenha("123456");
		usuario.setIdEmpresa("dfjaskdfjalsdjfk");

		UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
		usuarioDAO.cadastrar(usuario);
	}
}
