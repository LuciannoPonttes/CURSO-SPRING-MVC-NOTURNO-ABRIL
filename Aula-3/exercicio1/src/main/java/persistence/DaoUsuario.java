package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Usuario;

public class DaoUsuario {
	

	public boolean salvarUsuario(Usuario usuario) {
		FabricaConexao fabricaConexao = new FabricaConexao();

		boolean salvamento = false; // Resposta do metodo
		String comandoSqlInsert = "insert into tb_pessoa(nome,endereco) values(?,?)";// Comando SQL

		Connection conexaoRecebida = null; // Recebe a conexao
		PreparedStatement declaracaoComando = null; // Preparação do comando

		try {
			conexaoRecebida = fabricaConexao.criarConexaoDb_usuarios();

			declaracaoComando = (PreparedStatement) conexaoRecebida.prepareStatement(comandoSqlInsert);// Preparação do
																										// comanda																							// recebe 
			declaracaoComando.setString(1, usuario.getNome().toUpperCase());
			declaracaoComando.setString(2, usuario.getEndereco().toUpperCase());
			declaracaoComando.execute();

			salvamento = true;
			System.out.println("Usuario Cadastrado com sucesso");

			

		} catch (Exception mensagemErro) {
			System.out.println(mensagemErro);
			System.out.println("Erro ao salvar!");
			salvamento = false;

		} finally { 

			try {

				if (conexaoRecebida != null) {
					conexaoRecebida.close();
				}

				if (declaracaoComando != null) {
					declaracaoComando.close();
				}

			} catch (Exception msgErro) {
				System.out.println(msgErro);
				System.out.println("Erro ao tentar fechar a conexao");
			}

		}

		return salvamento;
	}
	
	
	
	
	
	

}
