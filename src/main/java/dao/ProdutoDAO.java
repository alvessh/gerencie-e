package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import model.Empresa;
import model.Produto;

public class ProdutoDAO {
	private Connection conn;

	public ProdutoDAO(Connection conn) {
		this.conn = conn;
	}

	public void cadastrar(Produto produto) {
		String sql = "INSERT INTO produto (id, descricao, quantidade, valorcusto, valorvenda, id_empresa, quantidade_estoque) "
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
	
	public void atualizar(Produto produto) {
		//atualizar o Produto UPDATE
	}
	
	public List<Produto> listar() {
		//retorna todos os Produtos cadastros SELECT
		return new ArrayList<Produto>();
	}
	public Produto listarPorId(String id) {
		// retornar o Produto pelo o id informado SELECT
		return new Produto();
	}
	
	public void inativar(String id) {
		// inativar  UPDATE
	}
}
