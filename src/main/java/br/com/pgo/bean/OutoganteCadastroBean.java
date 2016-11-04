package br.com.pgo.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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

	public void salvar(){

		try {

			outorganteDAO.merge(outorgante);

			Messages.addFlashGlobalInfo("Outorgante salvo com sucesso!");			
			

		} catch (RuntimeException erro) {
			
			Messages.addFlashGlobalInfo("Erro ao salvar Outorgante!");
			erro.printStackTrace();
		}

	}

}
