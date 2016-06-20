package br.com.pgo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.pgo.dao.UaDAO;
import br.com.pgo.domain.Ua;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped // Tempo de vida do objeto
public class UaBean implements Serializable {

	private Ua ua;
	private List<Ua> listaUa;

	public Ua getUa() {
		return ua;
	}

	public void setUa(Ua ua) {
		this.ua = ua;
	}

	

	public List<Ua> getListaUa() {
		return listaUa;
	}

	public void setListaUa(List<Ua> listaUa) {
		this.listaUa = listaUa;
	}

	public void novo() {

		ua = new Ua();
	
	}

	public void salvar() {

		try {
			UaDAO uaDAO = new UaDAO();
			uaDAO.salvar(ua);

			novo();

			Messages.addGlobalInfo("UA salva com sucesso!");

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao cadastrar UA!");
			erro.printStackTrace();

		}

	}
    @PostConstruct
	public void listar() {

		try {
			UaDAO uaDAO = new UaDAO();
			listaUa = uaDAO.listar();

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao listar UA!");

		}

	}

}
