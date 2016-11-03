package br.com.pgo.dao;

import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Ignore;
import org.junit.Test;
import br.com.pgo.domain.Pessoa;
import br.com.pgo.domain.Usuario;

public class UsuarioDAOTest {
	@Test
	//@Ignore
	public void salvar() {

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(55L);
		Usuario usuario = new Usuario();

		
		
		usuario.setAtivo(true);
		usuario.setLogin("antonio.silva");
		usuario.setPessoa(pessoa);
		usuario.setSenhaSemCriptografia("12345678");
		
		SimpleHash hash = new SimpleHash("md5", usuario.getSenhaSemCriptografia());
		
		usuario.setSenha(hash.toHex());
		
		usuario.setTipo('A');

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);

		System.out.println("Usuário salvo com sucesso!");
	}
	@Ignore
	public void buscar() {

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Long codigo = 1L;
		Usuario usuario = usuarioDAO.buscar(codigo);

		if (usuario == null) {
			
			System.out.println("Usuario não encontrado!");
			
		} else {

			System.out.println(usuario.getLogin());
			System.out.println(usuario.getPessoa());
			System.out.println(usuario.getTipo());

		}
	}
	@Ignore
	public void listar() {

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.listar();

		for (Usuario usuario : resultado) {

			System.out.println(usuario.getLogin());
			System.out.println(usuario.getTipo());
			System.out.println(usuario.getPessoa());

		}

	}
	@Ignore
	public void excluir() {

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Long codigo = 1L;
		Usuario usuario = usuarioDAO.buscar(codigo);

		if (usuario == null) {

			System.out.println("Usuario não encontrado!");
		} else {
			usuarioDAO.excluir(usuario);
		}

	}
	
	@Test
	@Ignore
	public void autenticar(){
		
		String login = "renato.cavalcanti";
		String senha = "renato1234";
		
		UsuarioDAO usuDAO = new UsuarioDAO();		
		Usuario usuario = usuDAO.autenticar(login, senha);
		
		System.out.println("Usuario autenticado: "+usuario);
		
		
	}

}
