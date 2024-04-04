package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import persistence.DaoUsuario;

public class CadastroServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "  \r\n"
				+ "\r\n"
				+ "    <form action=\"cadastroUsuario\" method=\"post\">\r\n"
				+ "        <label for=\"nome\">Nome:</label>\r\n"
				+ "        <input type=\"text\" id=\"nome\" name=\"nome\"><br><br>\r\n"
				+ "\r\n"
				+ "        <label for=\"endereco\">Endereco:</label>\r\n"
				+ "        <input type=\"text\" id=\"endereco\" name=\"endereco\"><br><br>\r\n"
				+ "\r\n"
				+ "        <input type=\"submit\" value=\"Enviar\">\r\n"
				+ "    </form>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		
		usuario.setEndereco(request.getParameter("endereco"));
		usuario.setNome(request.getParameter("nome"));
		
		DaoUsuario daoUsuario = new DaoUsuario();
		
		daoUsuario.salvarUsuario(usuario);
	}

}
