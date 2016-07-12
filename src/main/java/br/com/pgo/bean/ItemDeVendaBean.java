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
	private List<ItemDeVenda> itensVenda;
	private ItemDeVenda demandaPontual;
	private ItemDeVenda itemDeVenda;
	private double valor;
	private double resultado;

	public void novo() {

		itemDeVenda = new ItemDeVenda();

	}

	public ItemDeVenda getItemDeVenda() {
		return itemDeVenda;
	}

	public void setItemDeVenda(ItemDeVenda itemDeVenda) {
		this.itemDeVenda = itemDeVenda;
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

	public List<ItemDeVenda> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<ItemDeVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}

	public ItemDeVenda getDemandaPontual() {
		return demandaPontual;
	}

	public void setDemandaPontual(ItemDeVenda demandaPontual) {
		this.demandaPontual = demandaPontual;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}

	@PostConstruct
	public void listar() {

		try {
			UaDAO uaDAO = new UaDAO();
			listaUa = uaDAO.listar("numeroUa");

			itensVenda = new ArrayList<>();

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao tentar carregar 'Seleção UA'");
			erro.printStackTrace();
		}

	}

	public void calcular() {

		double[] meses = new double[12];

		meses[0] = ua.getJan();
		meses[1] = ua.getFev();
		meses[2] = ua.getMar();
		meses[3] = ua.getAbr();
		meses[4] = ua.getMai();
		meses[5] = ua.getJun();
		meses[6] = ua.getJul();
		meses[7] = ua.getAgo();
		meses[8] = ua.getSet();
		meses[9] = ua.getOut();
		meses[10] = ua.getNov();
		meses[11] = ua.getDez();

		double cont = 0;
		for (int i = 0; i <= 11; i++) {

			if (valor <= meses[i]) {

				cont++;
			}

		}

		resultado = (cont / 12);

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

	public void adicionar() {

		novo();

		itemDeVenda.setNumeroUa(ua);
		itemDeVenda.setDemandaPontual(valor);
		itemDeVenda.setGarantiaVazao(resultado);

		itensVenda.add(itemDeVenda);

		for (ItemDeVenda venda : itensVenda) {

			System.out.println("Demanda Pontual: " + venda.getDemandaPontual());
			System.out.println("Garantia Vazao: " + venda.getGarantiaVazao());
			System.out.println("Numero Ua: " + venda.getNumeroUa());

		}

	}
}
