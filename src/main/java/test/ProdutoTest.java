package test;

import java.sql.Connection;

import connection.DatabaseConnection;
import dao.ProdutoDAO;
import model.Produto;

public class ProdutoTest {
	public static void main(String[] args) {
		Connection conn = DatabaseConnection.getConnection();

		Produto produto = new Produto();
		produto.setDescricao("Monitor 24'' Full HD");
		produto.setQuantidade(10);
		produto.setValorCusto(600.00);
		produto.setValorVenda(850.00);
		produto.setIdEmpresa("ID_DA_EMPRESA");
		produto.setQuantidadeEstoque(10);

		ProdutoDAO produtoDAO = new ProdutoDAO(conn);
		produtoDAO.cadastrar(produto);
	}
}
