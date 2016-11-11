package br.com.pgo.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.pgo.dao.UaDAO;
import br.com.pgo.domain.Ua;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UaCadastroBean implements Serializable {

	private Ua ua;
	private UaDAO uaDAO;

	public Ua getUa() {
		return ua;
	}

	public void setUa(Ua ua) {
		this.ua = ua;
	}

	@PostConstruct
	public void iniciar() {

		uaDAO = new UaDAO();
		ua = new Ua();
	}

	public void salvar() {

		try {

			uaDAO.merge(ua);

			Messages.addFlashGlobalInfo("Unidade de análise salva com sucesso!");

		} catch (RuntimeException erro) {

			Messages.addFlashGlobalInfo("Erro ao salvar Unidade de análise!");
			erro.printStackTrace();
		}
		  iniciar();
	}

}
