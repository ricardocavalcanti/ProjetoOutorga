package br.com.pgo.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.pgo.dao.PessoaDAO;
import br.com.pgo.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {

	private Pessoa pessoa;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public void novo(){
		
		pessoa = new Pessoa();
		
	}
	
	public void salvar(){
		
		try{
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);
		
		 novo();
		 
		 Messages.addGlobalInfo("Pessoa salva com sucesso!");
		
		} catch (RuntimeException erro) {
			
			Messages.addGlobalInfo("Erro ao cadastrar pessoa!");
			erro.printStackTrace();
			
		}
		
		
	}
	
}
