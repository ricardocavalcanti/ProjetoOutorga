package br.com.pgo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

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
			uaDAO.merge(ua);

			novo();

			listaUa = uaDAO.listar();

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
			listaUa = uaDAO.listar("numeroUa");

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao listar UA!");
			erro.printStackTrace();
		}

	}

	public void excluir(ActionEvent evento) {

		try {

			ua = (Ua) evento.getComponent().getAttributes().get("uaSelecionada");
			Messages.addGlobalInfo("Numero da UA: " + ua.getNumeroUa());

			UaDAO uaDAO = new UaDAO();
			uaDAO.excluir(ua);
			listaUa = uaDAO.listar();
			Messages.addGlobalInfo("UA excluida com sucesso!");

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao excluir UA!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {

		try {

			ua = (Ua) evento.getComponent().getAttributes().get("uaSelecionada");
			Messages.addGlobalInfo("Edição UA: " + ua.getNumeroUa());
			UaDAO uaDAO = new UaDAO();
			uaDAO.editar(ua);

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao editar UA!");
			erro.printStackTrace();
		}
	}

}
