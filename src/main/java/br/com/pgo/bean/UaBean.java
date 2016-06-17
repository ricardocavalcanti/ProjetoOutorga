package br.com.pgo.bean;

import java.io.Serializable;

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

	public Ua getUa() {
		return ua;
	}

	public void setUa(Ua ua) {
		this.ua = ua;
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

}
