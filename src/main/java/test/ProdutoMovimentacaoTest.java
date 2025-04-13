package test;

import java.sql.Connection;

import connection.DatabaseConnection;
import dao.ProdutoMovimentacaoDAO;
import model.ProdutoMovimentacao;

public class ProdutoMovimentacaoTest {
	public static void main(String[] args) {
		Connection conn = DatabaseConnection.getConnection();

		ProdutoMovimentacao mov = new ProdutoMovimentacao();
		mov.setIdProduto("dd0a22b5-e507-4580-bb39-1014f61fc77c");
		mov.setIdEmpresa("39ca2a32-d227-4826-bd69-bfaceeb82541");
		mov.setQuantidadeMovimentada(5);
		mov.setValorUnitario(850.00);
		mov.setTipoMovimentacao("venda");
		mov.setTipo("Saída");

		ProdutoMovimentacaoDAO dao = new ProdutoMovimentacaoDAO(conn);
		dao.cadastrar(mov);
	}
}