package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

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
		String sql = "UPDATE produto SET descricao = ?, quantidade = ?, valorcusto = ?, valorvenda = ?, id_empresa = ?, quantidade_estoque = ? WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, produto.getDescricao());
			ps.setInt(2, produto.getQuantidade());
			ps.setDouble(3, produto.getValorCusto());
			ps.setDouble(4, produto.getValorVenda());
			ps.setString(5, produto.getIdEmpresa());
			ps.setInt(6, produto.getQuantidadeEstoque());
			ps.setString(7, produto.getId());
			ps.executeUpdate();

			System.out.println("Produto atualizado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao atualizar produto: " + e.getMessage());
		}
	}

	public List<Produto> listar() {
		List<Produto> produtos = new ArrayList<>();
		String sql = "SELECT * FROM produto";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			var rs = ps.executeQuery();

			while (rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getString("id"));
				p.setDescricao(rs.getString("descricao"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setValorCusto(rs.getDouble("valorcusto"));
				p.setValorVenda(rs.getDouble("valorvenda"));
				p.setIdEmpresa(rs.getString("id_empresa"));
				p.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));

				produtos.add(p);
			}
		} catch (Exception e) {
			System.out.println("Erro ao listar produtos: " + e.getMessage());
		}
		return produtos;
	}

	public Produto listarPorId(String id) {
		String sql = "SELECT * FROM produto WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			var rs = ps.executeQuery();

			if (rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getString("id"));
				p.setDescricao(rs.getString("descricao"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setValorCusto(rs.getDouble("valorcusto"));
				p.setValorVenda(rs.getDouble("valorvenda"));
				p.setIdEmpresa(rs.getString("id_empresa"));
				p.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
				return p;
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar produto por ID: " + e.getMessage());
		}
		return null;
	}

	public void inativar(String id) {
		String sql = "UPDATE produto SET ativo = false WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();

			System.out.println("Produto inativado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao inativar produto: " + e.getMessage());
		}
	}
}
