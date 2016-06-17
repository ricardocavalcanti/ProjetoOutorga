package br.com.pgo.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.pgo.domain.Pessoa;

public class PessoaDAOTest {
	@Test
	@Ignore
	public void salvar() {

		Pessoa pessoa = new Pessoa();
		pessoa.setMatricula("050.122.354.10");
		pessoa.setEmail("Bob@email");
		pessoa.setNome("Bob");
		pessoa.setSetor("Financeiro");
		pessoa.setTelefone("34789876");

		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);

	}

	@Test
	@Ignore
	public void listar() {

		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.listar();

		for (Pessoa pessoa : resultado) {

			System.out.println("CPF: " + pessoa.getMatricula());
			System.out.println("E-MAIL: " + pessoa.getEmail());
			System.out.println("NOME: " + pessoa.getNome());
			System.out.println("SETOR: " + pessoa.getSetor());
			System.out.println("TELEFONE: " + pessoa.getTelefone());

		}

	}

	@Test
	@Ignore
	public void buscar() {

		Long codigo = 6L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		if (pessoa == null) {
			System.out.println("Pessoa não encontrada");
		} else {

			System.out.println("CPF: " + pessoa.getMatricula());
			System.out.println("E-MAIL: " + pessoa.getEmail());
			System.out.println("NOME: " + pessoa.getNome());
			System.out.println("SETOR: " + pessoa.getSetor());
			System.out.println("TELEFONE: " + pessoa.getTelefone());

		}
	}

	@Test
	@Ignore
	public void atualizar() {

		Long codigo = 6L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		if (pessoa == null) {
			System.out.println("Pessoa não encontrada!");
		} else {

			pessoa.setNome("Bob");
			pessoaDAO.editar(pessoa);
			System.out.println("Pessoa editada com sucesso!");
		}
	}

	@Test
	@Ignore
	public void excluir() {

		Long codigo = 6L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		if (pessoa == null) {
			System.out.println("Pessoa não encontrada!");
		} else {
			pessoaDAO.excluir(pessoa);
			System.out.println("Pessoa excluida com sucesso!");
		}
	}
}
