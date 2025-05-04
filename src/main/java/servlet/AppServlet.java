package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.EmpresaController;
import controller.UsuarioController;

/**
 * Servlet implementation class AppServlet
 */
@WebServlet("/*")
public class AppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AppServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String acao = request.getParameter("action");
		UsuarioController usuarioController = new UsuarioController();
		EmpresaController empresaController = new EmpresaController();

		if ("cadastrarUsuarioForm".equals(acao)) {
			usuarioController.cadastrarForm(response);
		} else if ("usuarioCadastrado".equals(acao)) {
//			usuarioController.usuarioCadastrado(response);
		} else if ("cadastrarEmpresaForm".equals(acao)) {
			empresaController.cadastrarForm(response);
		} else if ("empresaCadastrada".equals(acao)) {
			empresaController.empresaCadastrada(response);
		} else {
			response.getWriter().println("<h2>Bem-vindo ao sistema</h2><a href='?action=cadastrarEmpresaForm'>Cadastrar Empresa</a>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("action");
		UsuarioController usuarioController = new UsuarioController();
		EmpresaController empresaController = new EmpresaController();

		if ("cadastrarUsuario".equals(acao)) {
			usuarioController.cadastrarUsuario(request, response);
		} else if ("cadastrarEmpresa".equals(acao)) {
			empresaController.cadastrarEmpresa(request, response);
		}
	}
}	
