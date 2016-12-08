package br.com.pgo.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.pgo.dao.UaDAO;
import br.com.pgo.domain.Ua;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UaApagarBean implements Serializable {

	private Long codigoUa;
	private UaDAO uaDAO;
	private Ua ua;

	public Long getCodigoUa() {
		return codigoUa;
	}

	public void setCodigoUa(Long codigoUa) {
		this.codigoUa = codigoUa;
	}

	public Ua getUa() {
		return ua;
	}

	public void setUa(Ua ua) {
		this.ua = ua;
	}

	@PostConstruct
	public void iniciar() {

		uaDAO = new UaDAO();
	}

	public void message() {

		addMessage("Unidade de análise excluída com sucesso", null);

	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void buscarUa() {

		try {

			ua = uaDAO.buscar(codigoUa);

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao buscar Ua");

		}

	}

	public void excluirUa() throws IOException {

		buscarUa();

		try {

			uaDAO.excluir(ua);
			message();
			Faces.redirect("./pages/uaListagem.xhtml");

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao excluir Unidade de análise");
			erro.printStackTrace();
		}

	}

}
