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
public class OutoganteCadastroBean implements Serializable {

	private Outorgante outorgante;
	private OutorganteDAO outorganteDAO;

	public Outorgante getOutorgante() {
		return outorgante;
	}

	public void setOutorgante(Outorgante outorgante) {
		this.outorgante = outorgante;
	}

	@PostConstruct
	public void iniciar() {

		outorganteDAO = new OutorganteDAO();
		outorgante = new Outorgante();
	}
	
	public void message() {

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
	}

	public void salvar() throws IOException{

		try {

			outorganteDAO.merge(outorgante);
			message();
			Faces.redirect("./pages/outorganteListagem.xhtml");
			

		} catch (RuntimeException erro) {
			
			Messages.addFlashGlobalInfo("Erro ao salvar Outorgante!");
			erro.printStackTrace();
		}

	}

}
