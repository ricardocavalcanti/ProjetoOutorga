package br.com.pgo.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	private List<Ua> listaItensVenda;
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

	public List<Ua> getListaItensVenda() {
		return listaItensVenda;
	}

	public void setListaItensVenda(List<Ua> listaItensVenda) {
		this.listaItensVenda = listaItensVenda;
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

	public void adicionar(ActionEvent evento) {

		ua = (Ua) evento.getComponent().getAttributes().get("uaSelecionada");

		ua.setAno(ua.getAno());
		ua.setNumeroUa(ua.getNumeroUa());
		ua.setJan(ua.getJan());
		ua.setFev(ua.getFev());
		ua.setMar(ua.getMar());
		ua.setAbr(ua.getAbr());
		ua.setMai(ua.getMai());
		ua.setJun(ua.getJun());
		ua.setJul(ua.getJul());
		ua.setAgo(ua.getAgo());
		ua.setSet(ua.getSet());
		ua.setOut(ua.getOut());
		ua.setNov(ua.getNov());
		ua.setDez(ua.getDez());

		listaItensVenda.add(ua);

	}

	public void calcular() {

		int tamanho = listaItensVenda.size();

		System.out.println(tamanho);

		Collections.sort(listaItensVenda, new Comparator<Ua>() {
			@Override
			public int compare(Ua ua1, Ua ua2) {

				if (ua1.getJan() < ua2.getJan()) {
					return 1;
				} else if (ua1.getJan() > ua2.getJan()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		for (Ua janeiro : listaItensVenda) {
			System.out.println("NumeroUA: " + janeiro.getNumeroUa() + " Mes: Janeiro " + " Vazao: " + janeiro.getJan());
		}
		
		System.out.println("1 "+listaItensVenda.get(0).getJan()/tamanho);
		System.out.println("2 " +listaItensVenda.get(1).getJan()/tamanho);
		System.out.println("3 " +listaItensVenda.get(2).getJan()/tamanho);

		Collections.sort(listaItensVenda, new Comparator<Ua>() {
			@Override
			public int compare(Ua ua1, Ua ua2) {

				if (ua1.getFev() < ua2.getFev()) {
					return 1;
				} else if (ua1.getFev() > ua2.getFev()) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		for (Ua fevereiro : listaItensVenda) {

			System.out.println("NumeroUA: " + fevereiro.getNumeroUa() + " Mes: Fevereiro " + " Vazao: " + fevereiro.getFev());
		}

		for (Ua marco : listaItensVenda) {

			System.out.println("NumeroUA: " + marco.getNumeroUa() + " Mes: Março " + " Vazao: " + marco.getMar());
		}
		for (Ua abril : listaItensVenda) {

			System.out.println("NumeroUA: " + abril.getNumeroUa() + " Mes: Abril " + " Vazao: " + abril.getAbr());
		}
		for (Ua maio : listaItensVenda) {

			System.out.println("NumeroUA: " + maio.getNumeroUa() + " Mes: Maio " + " Vazao: " + maio.getMai());
		}
		for (Ua junho : listaItensVenda) {

			System.out.println("NumeroUA: " + junho.getNumeroUa() + " Mes: Junho " + " Vazao: " + junho.getJun());
		}

		for (Ua julho : listaItensVenda) {

			System.out.println("NumeroUA: " + julho.getNumeroUa() + " Mes: Julho " + " Vazao: " + julho.getJul());
		}
		for (Ua agosto : listaItensVenda) {

			System.out.println("NumeroUA: " + agosto.getNumeroUa() + " Mes: Agosto " + " Vazao: " + agosto.getAgo());
		}
		for (Ua setembro : listaItensVenda) {

			System.out.println("NumeroUA: " + setembro.getNumeroUa() + " Mes: Setembro " + " Vazao: Setembro "
					+ setembro.getSet());
		}
		for (Ua outubro : listaItensVenda) {

			System.out.println("NumeroUA: " + outubro.getNumeroUa() + " Mes: Outubro " + " Vazao: " + outubro.getOut());
		}
		for (Ua novembro : listaItensVenda) {

			System.out.println(
					"NumeroUA: " + novembro.getNumeroUa() + " Mes: Novembro " + " Vazao: " + novembro.getNov());
		}
		for (Ua dezembro : listaItensVenda) {

			System.out.println(
					"NumeroUA: " + dezembro.getNumeroUa() + " Mes: Dezembro " + " Vazao: " + dezembro.getDez());
		}
	}

}
