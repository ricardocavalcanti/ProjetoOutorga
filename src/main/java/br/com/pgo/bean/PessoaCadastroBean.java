package br.com.pgo.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.pgo.dao.PessoaDAO;
import br.com.pgo.domain.Pessoa;


@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaCadastroBean implements Serializable {

	private Pessoa pessoa;
	private PessoaDAO pessoaDAO;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	@PostConstruct
	public void iniciar() {

		pessoaDAO = new PessoaDAO();
		pessoa = new Pessoa();
	}
	
	public void salvar() {

		try {

			pessoaDAO.merge(pessoa);

			Messages.addFlashGlobalInfo("Pessoa salva com sucesso!");

		} catch (RuntimeException erro) {

			Messages.addFlashGlobalInfo("Erro ao salvar pessoa!");
			erro.printStackTrace();
		}

	}

}
