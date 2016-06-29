package br.com.pgo.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.pgo.dao.PessoaDAO;
import br.com.pgo.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped //Tempo de vida do objeto
public class PessoaBean implements Serializable {

	private Pessoa pessoa;
	private List<Pessoa> listaPessoa;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}	
	
	public List<Pessoa> getListaPessoa() {
		return listaPessoa;
	}

	public void setListaPessoa(List<Pessoa> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}

	public void novo(){
		
		pessoa = new Pessoa();
		
	}
	
	public void salvar(){
		
		try{
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.merge(pessoa);
		
		 novo();
		 
		 Messages.addGlobalInfo("Pessoa salva com sucesso!");
		
		} catch (RuntimeException erro) {
			
			Messages.addGlobalInfo("Erro ao cadastrar pessoa!");
			erro.printStackTrace();
			
		}
		
		
	}
	
	public void listar(){
		
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			listaPessoa = pessoaDAO.listar();
			
		} catch (RuntimeException erro){
			
			Messages.addGlobalInfo("Erro ao listar Pessoa!");
			erro.printStackTrace();
			
		}
	}
	
	public void excluir(ActionEvent evento){
		
		try{
			
		pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");
		Messages.addGlobalInfo("Nome pessoa"+pessoa.getNome());
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.excluir(pessoa);
		listaPessoa = pessoaDAO.listar();
		Messages.addGlobalInfo("Pessoa excluida com sucesso!");
		
		} catch (RuntimeException erro){
			
			Messages.addGlobalInfo("Erro ao excluir pessoa!");
			erro.printStackTrace();
		}
	}
	
	public void editar (ActionEvent evento){
		
		try {
			
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");
			Messages.addGlobalInfo("Edição UA: "+ pessoa.getNome());
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.editar(pessoa);
		}catch (RuntimeException erro){
			
			Messages.addGlobalInfo("Erro ao editar Pessoa!");
			erro.printStackTrace();
		}
		
		
		
	}
	
}
