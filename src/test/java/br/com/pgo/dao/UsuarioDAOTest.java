package br.com.pgo.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.com.pgo.domain.Pessoa;
import br.com.pgo.domain.Usuario;

public class UsuarioDAOTest {
	@Test
	@Ignore
	public void salvar() {

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);
		Usuario usuario = new Usuario();

		usuario.setAtivo(true);
		usuario.setLogin("ricardo.cavalcanti");
		usuario.setPessoa(pessoa);
		usuario.setSenha("37eyrue");
		usuario.setTipo("A");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);

		System.out.println("Usuário salvo com sucesso!");
	}

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

	public void listar() {

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.listar();

		for (Usuario usuario : resultado) {

			System.out.println(usuario.getLogin());
			System.out.println(usuario.getTipo());
			System.out.println(usuario.getPessoa());

		}

	}

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

}
