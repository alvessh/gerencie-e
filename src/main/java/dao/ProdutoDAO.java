package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Produto;

public class ProdutoDAO {
	private Connection conn;

	public ProdutoDAO(Connection conn) {
		this.conn = conn;
	}

	public void cadastrar(Produto produto) {
		String sql = "INSERT INTO produto (id, descricao, quantidade, valorcusto, valorvenda, id_empresa, quantidadeestoque) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, produto.getId());
			ps.setString(2, produto.getDescricao());
			ps.setInt(3, produto.getQuantidade());
			ps.setDouble(4, produto.getValorCusto());
			ps.setDouble(5, produto.getValorVenda());
			ps.setString(6, produto.getIdEmpresa());
			ps.setInt(7, produto.getQuantidadeEstoque());
			ps.executeUpdate();

			System.out.println("Produto cadastrado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar produto: " + e.getMessage());
		}
	}
}
