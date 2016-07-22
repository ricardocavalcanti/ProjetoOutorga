package br.com.pgo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;
import br.com.pgo.dao.OutorganteDAO;
import br.com.pgo.domain.Outorgante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class OutorganteBean implements Serializable {

	private Outorgante outorgante;
	private List<Outorgante> listaOutorgante;

	public Outorgante getOutorgante() {
		return outorgante;
	}

	public void setOutorgante(Outorgante outorgante) {
		this.outorgante = outorgante;
	}

	public List<Outorgante> getListaOutorgante() {
		return listaOutorgante;
	}

	public void setListaOutorgante(List<Outorgante> listaOutorgante) {
		this.listaOutorgante = listaOutorgante;
	}

	public void novo() {

		try {

			outorgante = new Outorgante();
			OutorganteDAO outorganteDAO = new OutorganteDAO();
			listaOutorgante = outorganteDAO.listar("processoApac");


		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao gerar processo Outorgante !");
			erro.printStackTrace();

		}
	}

	public void salvar() {

		try {

			OutorganteDAO outorganteDAO = new OutorganteDAO();
			outorganteDAO.merge(outorgante);
			outorgante = new Outorgante();
			listaOutorgante = outorganteDAO.listar();

			Messages.addFlashGlobalInfo("Processo salvo com sucesso!");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalInfo("Erro ao salvar processo!");
			erro.printStackTrace();
		}

	}

	@PostConstruct
	public void listar() {

		try {

			OutorganteDAO outorganteDAO = new OutorganteDAO();
			listaOutorgante = outorganteDAO.listar();

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao listar Processo !");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {

		try {

			outorgante = (Outorgante) evento.getComponent().getAttributes().get("outorganteSelecionado");

			Messages.addGlobalInfo("Numero ProcessoAPAC: " + outorgante.getProcessoApac());

			OutorganteDAO outorganteDAO = new OutorganteDAO();
			outorganteDAO.excluir(outorgante);

			listaOutorgante = outorganteDAO.listar();
			Messages.addGlobalInfo("Processo excluido com sucesso!");

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao excluir Processo!");
			erro.printStackTrace();

		}

	}

	public void editar(ActionEvent evento) {

		try {

			outorgante = (Outorgante) evento.getComponent().getAttributes().get("outorganteSelecionado");

			OutorganteDAO outorganteDAO = new OutorganteDAO();
			listaOutorgante = outorganteDAO.listar();

			Messages.addGlobalInfo("Edição ProcessoAPAC: " + outorgante.getProcessoApac());

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao editar Processo!");
			erro.printStackTrace();
		}
	}
}
