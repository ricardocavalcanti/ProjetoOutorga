package br.com.pgo.bean;

import java.io.Serializable;
import java.util.List;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.pgo.dao.UaDAO;
import br.com.pgo.domain.Ua;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UaListagemBean implements Serializable {

	private UaDAO uaDAO;
	private List<Ua> listaUa;

	public List<Ua> getListaUa() {
		return listaUa;
	}

	public void setListaUa(List<Ua> listaUa) {
		this.listaUa = listaUa;
	}

	@PostConstruct
	public void iniciar() {

		uaDAO = new UaDAO();

	}

	public void listar() {

		try {

			listaUa = uaDAO.listar();

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao listar UA!");
			erro.printStackTrace();
		}

	}

}
