package br.com.pgo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.pgo.dao.OutorganteDAO;
import br.com.pgo.domain.Outorgante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class OutorganteListagemBean implements Serializable {

	private List<Outorgante> listaOutorgante;
	

	private OutorganteDAO outorganteDAO;
	

	public List<Outorgante> getListaOutorgante() {
		return listaOutorgante;
	}

	public void setListaOutorgante(List<Outorgante> listaOutorgante) {
		this.listaOutorgante = listaOutorgante;
	}

	@PostConstruct
	public void iniciar(){
		
		outorganteDAO = new OutorganteDAO();
		
	}
	
	public void listar() {

		try {
			
			listaOutorgante = outorganteDAO.listar();

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao listar Processo !");
			erro.printStackTrace();
		}
	}
}
