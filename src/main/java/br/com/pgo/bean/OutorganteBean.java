package br.com.pgo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.pgo.dao.OutorganteDAO;
import br.com.pgo.dao.UaDAO;
import br.com.pgo.domain.Outorgante;
import br.com.pgo.domain.Ua;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class OutorganteBean implements Serializable {

	private Outorgante outorgante;
	private List<Outorgante> listaOutorgante;
	private List<Ua> listaNumeroUa;

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

	public List<Ua> getListaNumeroUa() {
		return listaNumeroUa;
	}

	public void setListaNumeroUa(List<Ua> listaNumeroUa) {
		this.listaNumeroUa = listaNumeroUa;
	}

	public void novo() {

		try {

			outorgante = new Outorgante();
			UaDAO uaDAO = new UaDAO();
			listaNumeroUa = uaDAO.listar("numeroUa");			

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao gerar numero UA !");
			erro.printStackTrace();

		}
	}

	public void salvar() {

		try {

			OutorganteDAO outorganteDAO = new OutorganteDAO();
			outorganteDAO.merge(outorgante);
			outorgante = new Outorgante();
			listaOutorgante = outorganteDAO.listar();

			UaDAO uaDAO = new UaDAO();
			listaNumeroUa = uaDAO.listar();

			Messages.addFlashGlobalInfo("Outorgante salvo com sucesso!");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalInfo("Erro ao salvar outorgante!");
			erro.printStackTrace();
		}

	}

	@PostConstruct
	public void listar() {

		try {

			OutorganteDAO outorganteDAO = new OutorganteDAO();
			listaOutorgante = outorganteDAO.listar();

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao listar Outorgante !");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {

		try {

			outorgante = (Outorgante) evento.getComponent().getAttributes().get("outorganteSelecionado");
			
			Messages.addGlobalInfo("Numero da Outorgante: " + outorgante.getProcesso());

			OutorganteDAO outorganteDAO = new OutorganteDAO();
			outorganteDAO.excluir(outorgante);

			listaOutorgante = outorganteDAO.listar();
			Messages.addGlobalInfo("Outorgante excluido com sucesso!");

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao excluir Outorgante!");
			erro.printStackTrace();

		}

	}

	public void editar(ActionEvent evento) {

		try {

			outorgante = (Outorgante) evento.getComponent().getAttributes().get("outorganteSelecionado");
			
			UaDAO uaDAO = new UaDAO();
			listaNumeroUa = uaDAO.listar();
			
			Messages.addGlobalInfo("Edição processo: "+ outorgante.getProcesso());
			
			/**OutorganteDAO outorganteDAO = new OutorganteDAO();
			outorganteDAO.editar(outorgante);**/

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao editar Processo!");
			erro.printStackTrace();
		}
	}
}
