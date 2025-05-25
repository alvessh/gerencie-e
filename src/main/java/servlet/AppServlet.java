package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DashboardController;
import controller.EmpresaController;
import controller.LoginController;

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
		EmpresaController empresaController = new EmpresaController();
		LoginController loginController = new LoginController();
		DashboardController dashboardController = new DashboardController();

		switch (acao != null ? acao : "") {
		case "cadastrarEmpresaForm":
			empresaController.cadastrarForm(request, response);
			break;
		case "empresaCadastrada":
			empresaController.empresaCadastrada(request, response);
			break;
		case "listarEmpresas":
			empresaController.listarEmpresas(request, response);
			break;
		case "login":
			loginController.loginForm(request, response);
			break;
		case "dashboard":
			dashboardController.dashboard(request, response);
			break;
		default:
		    response.sendRedirect("?action=login");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("action");
		EmpresaController empresaController = new EmpresaController();
		LoginController loginController = new LoginController();

		switch (acao != null ? acao : "") {
		case "cadastrarEmpresa":
			empresaController.cadastrarEmpresa(request, response);
			break;
		case "loginUsuario":
			loginController.loginUsuario(request, response);
			break;
		default:
			response.getWriter().println("Ação POST não reconhecida.");
		}
	}
}
