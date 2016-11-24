package br.com.pgo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.pgo.dao.VendaDAO;
import br.com.pgo.domain.Venda;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class OutorgaListagemBean implements Serializable {

	private List<Venda> listaOutorgas;
	private VendaDAO vendaDAO;

	public List<Venda> getListaOutorgas() {
		return listaOutorgas;
	}

	public void setListaOutorgas(List<Venda> listaOutorgas) {
		this.listaOutorgas = listaOutorgas;
	}

	@PostConstruct
	public void iniciar() {

		vendaDAO = new VendaDAO();

	}
	
	public void listar(){
		
		try{
			
			listaOutorgas = vendaDAO.listar();
			
		}catch (RuntimeException erro){
			
			Messages.addGlobalInfo("Erro ao listar outorgas");
			erro.printStackTrace();
		
		}
	}

}
