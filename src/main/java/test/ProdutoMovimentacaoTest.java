package test;

import java.sql.Connection;

import connection.DatabaseConnection;
import dao.ProdutoMovimentacaoDAO;
import model.ProdutoMovimentacao;

public class ProdutoMovimentacaoTest {
	public static void main(String[] args) {
		Connection conn = DatabaseConnection.getConnection();

		ProdutoMovimentacao mov = new ProdutoMovimentacao();
		mov.setIdProduto("ID_DO_PRODUTO");
		mov.setIdEmpresa("ID_DA_EMPRESA");
		mov.setQuantidadeMovimentada(5);
		mov.setValorUnitario(850.00);
		mov.setTipoMovimentacao("venda");
		mov.setTipo("Saída");

		ProdutoMovimentacaoDAO dao = new ProdutoMovimentacaoDAO(conn);
		dao.cadastrar(mov);
	}
}