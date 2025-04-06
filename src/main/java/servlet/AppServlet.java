package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UsuarioController;

/**
 * Servlet implementation class AppServlet
 */
@WebServlet("/*")
public class AppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AppServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String acao = request.getParameter("action");

		UsuarioController usuarioController = new UsuarioController();
		if ("cadastrarUsuarioForm".equals(acao)) {
			usuarioController.cadastrarForm(response);
		} else if ("usuarioCadastrado".equals(acao)) {
			usuarioController.usuarioCadastrado(response);
		} else {
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("action");

		if ("cadastrarUsuario".equals(acao)) {
			UsuarioController usuarioController = new UsuarioController();
			usuarioController.cadastrarUsuario(request, response);
		} else {
		}
	}

}
