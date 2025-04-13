package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.ProdutoMovimentacao;

public class ProdutoMovimentacaoDAO {
	private Connection conn;

	public ProdutoMovimentacaoDAO(Connection conn) {
		this.conn = conn;
	}

	public void cadastrar(ProdutoMovimentacao mov) {
		String sql = "INSERT INTO produtomovimentacao (id, id_produto, id_empresa, quantidade_movimentada, valor_unitario, tipo_movimentacao, tipo) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mov.getId());
			ps.setString(2, mov.getIdProduto());
			ps.setString(3, mov.getIdEmpresa());
			ps.setInt(4, mov.getQuantidadeMovimentada());
			ps.setDouble(5, mov.getValorUnitario());
			ps.setString(6, mov.getTipoMovimentacao());
			ps.setString(7, mov.getTipo());

			ps.executeUpdate();
			System.out.println("Movimentação cadastrada com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar movimentação: " + e.getMessage());
		}
	}
}
