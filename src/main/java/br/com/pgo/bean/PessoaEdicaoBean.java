package br.com.pgo.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.pgo.dao.PessoaDAO;
import br.com.pgo.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaEdicaoBean implements Serializable {

	private Long codigoPessoa;
	private PessoaDAO pessoaDAO;
	private Pessoa pessoa;

	public Long getCodigoPessoa() {
		return codigoPessoa;
	}

	public void setCodigoPessoa(Long codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@PostConstruct
	public void iniciar() {

		pessoaDAO = new PessoaDAO();

	}

	public void carregarEdicao() {

		try {

			pessoa = pessoaDAO.buscar(codigoPessoa);

		} catch (RuntimeException erro) {

			Messages.addFlashGlobalInfo("Erro ao carregar edição da pessoa");

		}
	}

	public void salvarEdicao() {

		try {

			pessoaDAO.merge(pessoa);
			Messages.addGlobalInfo("Pessoa editada com sucesso");

		} catch (RuntimeException erro) {

			Messages.addGlobalError("Erro ao editar pessoa");
			erro.printStackTrace();

		}

	}

}
