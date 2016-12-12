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

import br.com.pgo.dao.OutorganteDAO;
import br.com.pgo.domain.Outorgante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class OutorganteApagarBean implements Serializable {

	private Long codigoOutorgante;
	private OutorganteDAO outorganteDAO;
	private Outorgante outorgante;

	public Long getCodigoOutorgante() {
		return codigoOutorgante;
	}

	public void setCodigoOutorgante(Long codigoOutorgante) {
		this.codigoOutorgante = codigoOutorgante;
	}

	public Outorgante getOutorgante() {
		return outorgante;
	}

	public void setOutorgante(Outorgante outorgante) {
		this.outorgante = outorgante;
	}

	@PostConstruct
	public void iniciar() {

		outorganteDAO = new OutorganteDAO();
	}
	
	public void message() {

		addMessage("Outorgante excluído com sucesso", null);

	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void buscarOutorgante() {

		System.out.println(codigoOutorgante);

		try {

			outorgante = outorganteDAO.buscar(codigoOutorgante);

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao buscar outorgante");
		}

	}

	public void excluirOutorgante() throws IOException {

		buscarOutorgante();

		try {

			outorganteDAO.excluir(outorgante);
			message();
			Faces.redirect("./pages/outorganteListagem.xhtml");

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao excluir outorgante");
			erro.printStackTrace();

		}

	}

}
