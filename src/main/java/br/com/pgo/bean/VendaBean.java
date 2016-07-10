package br.com.pgo.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.pgo.dao.UaDAO;
import br.com.pgo.domain.Ua;
import br.com.pgo.domain.Venda;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaBean implements Serializable {

	private List<Ua> listaUa;
	private List<Ua> listaOutorgante;
	private List<Venda> listaVenda;

	public List<Ua> getListaUa() {
		return listaUa;
	}

	public void setListaUa(List<Ua> listaUa) {
		this.listaUa = listaUa;
	}

	public List<Ua> getListaOutorgante() {
		return listaOutorgante;
	}

	public void setListaOutorgante(List<Ua> listaOutorgante) {
		this.listaOutorgante = listaOutorgante;
	}

	public List<Venda> getListaVenda() {
		return listaVenda;
	}

	public void setListaVenda(List<Venda> listaVenda) {
		this.listaVenda = listaVenda;
	}

	@PostConstruct
	public void listar() {

		try {
			UaDAO uaDAO = new UaDAO();
			listaUa = uaDAO.listar("numeroUa"); // Valor para ordenação da lista

			listaVenda = new ArrayList<>();

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao tentar carregar 'Seleção UA'");
			erro.printStackTrace();
		}

	}

	public void adicionar(ActionEvent evento) {

		Ua ua = (Ua) evento.getComponent().getAttributes().get("uaSelecionada");

		Venda novaVenda = new Venda();	
		
		Date dataAtual = new Date();
		
		
		
		novaVenda.setDataCadastro(dataAtual);
		
		novaVenda.setNumeroUa(ua);
		
	
		listaVenda.add(novaVenda);		
		System.out.println(ua);

	}
	
	public void calcular(ActionEvent evento) {

		Ua ua = (Ua) evento.getComponent().getAttributes().get("uaSelecionada");

		Venda novaVenda = new Venda();	
		
		Date dataAtual = new Date();
		
		
		
		novaVenda.setDataCadastro(dataAtual);
		
		novaVenda.setNumeroUa(ua);
		
	
		listaVenda.add(novaVenda);		
		System.out.println(ua);

	}
}
