package br.com.pgo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.pgo.dao.PessoaDAO;
import br.com.pgo.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaListagemBean implements Serializable {

	private List<Pessoa> listaPessoa;
	private PessoaDAO pessoaDAO;

	public List<Pessoa> getListaPessoa() {
		return listaPessoa;
	}

	public void setListaPessoa(List<Pessoa> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}
    
	@PostConstruct
	public void iniciar(){
		
		pessoaDAO = new PessoaDAO();
		
	}
	
	public void listar(){
		
		try{
		
		listaPessoa = pessoaDAO.listar();
		
		}catch (RuntimeException erro){
			
			Messages.addGlobalInfo("Erro ao listar Pessoa");
			erro.printStackTrace();
		}
	} 
	
}
