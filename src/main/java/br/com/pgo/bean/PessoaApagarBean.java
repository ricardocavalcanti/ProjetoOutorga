package br.com.pgo.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.pgo.dao.PessoaDAO;
import br.com.pgo.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaApagarBean implements Serializable {

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

	public void message() {

		addMessage("Pessoa excluída com sucesso", null);
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void buscarPessoa() {
		
		try{
			
			pessoa = pessoaDAO.buscar(codigoPessoa);
			
		} catch (RuntimeException erro){
			
			Messages.addGlobalInfo("Erro ao buscar pessoa");
		}
	}
	
	public void excluirPessoa() throws IOException {
		
		buscarPessoa();
		
		try {
			
			pessoaDAO.excluir(pessoa);
			message();
			Faces.redirect("./pages/pessoaListagem.xhtml");
			
		} catch (RuntimeException erro){
			
			Messages.addGlobalInfo("Erro ao excluir pessoa");
			erro.printStackTrace();
		}
	}
}
