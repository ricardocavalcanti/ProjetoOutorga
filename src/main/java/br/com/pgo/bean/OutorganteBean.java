package br.com.pgo.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.pgo.dao.OutorganteDAO;
import br.com.pgo.domain.Outorgante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class OutorganteBean implements Serializable {

	private Outorgante outorgante;

	public Outorgante getOutorgante() {
		return outorgante;
	}

	public void setOutorgante(Outorgante outorgante) {
		this.outorgante = outorgante;
	}

	public void novo() {

		outorgante = new Outorgante();
	
	}

	public void Salvar() {

		try {

			OutorganteDAO outorganteDAO = new OutorganteDAO();
			outorganteDAO.salvar(outorgante);

			novo();
			Messages.addFlashGlobalInfo("Outorgante salvo com sucesso!");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalInfo("Outorgante salvo com sucesso!");
			erro.printStackTrace();
		}

	}
}
