package br.com.pgo.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;
import br.com.pgo.dao.UaDAO;
import br.com.pgo.domain.ItemDeVenda;
import br.com.pgo.domain.Ua;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ItemDeVendaBean implements Serializable {

	private Ua ua;
	private List<Ua> listaUa;
	private List<ItemDeVenda> listaItensVenda;
	private ItemDeVenda demandaPontual;
	private ItemDeVenda itemDeVenda;

	public void novo() {

		itemDeVenda = new ItemDeVenda();

	}

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

	public List<ItemDeVenda> getListaItensVenda() {
		return listaItensVenda;
	}

	public void setListaItensVenda(List<ItemDeVenda> listaItensVenda) {
		this.listaItensVenda = listaItensVenda;
	}

	public ItemDeVenda getDemandaPontual() {
		return demandaPontual;
	}

	public void setDemandaPontual(ItemDeVenda demandaPontual) {
		this.demandaPontual = demandaPontual;
	}

	public ItemDeVenda getItemDeVenda() {
		return itemDeVenda;
	}

	public void setItemDeVenda(ItemDeVenda itemDeVenda) {
		this.itemDeVenda = itemDeVenda;
	}

	@PostConstruct
	public void listar() {

		try {
			UaDAO uaDAO = new UaDAO();
			listaUa = uaDAO.listar("numeroUa");

			listaItensVenda = new ArrayList<>();

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao tentar carregar 'Seleção UA'");
			erro.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {

		try {

			ua = (Ua) evento.getComponent().getAttributes().get("uaSelecionada");

			Messages.addGlobalInfo("Calculo vazão UA: " + ua.getNumeroUa());

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao calcular");
			erro.printStackTrace();
		}

	}

}
