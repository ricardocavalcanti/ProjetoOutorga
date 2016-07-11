package br.com.pgo.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.pgo.dao.UaDAO;
import br.com.pgo.domain.Outorgante;
import br.com.pgo.domain.Ua;
import br.com.pgo.domain.Venda;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaBean implements Serializable {

	private List<Ua> listaUa;
	private List<Outorgante> listaOutorgante;
	private List<Venda> listaVenda;
	private Ua ua;
	private double valor;
	private double resultado;

	public List<Ua> getListaUa() {
		return listaUa;
	}

	public void setListaUa(List<Ua> listaUa) {
		this.listaUa = listaUa;
	}

	public List<Outorgante> getListaOutorgante() {
		return listaOutorgante;
	}

	public void setListaOutorgante(List<Outorgante> listaOutorgante) {
		this.listaOutorgante = listaOutorgante;
	}

	public List<Venda> getListaVenda() {
		return listaVenda;
	}

	public void setListaVenda(List<Venda> listaVenda) {
		this.listaVenda = listaVenda;
	}

	public Ua getUa() {
		return ua;
	}

	public void setUa(Ua ua) {
		this.ua = ua;
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

				System.out.println(meses[i]);
				cont++;
			}

		}

		resultado = (cont / 12) * 100;

		System.out.println("Total de meses: " + cont);
		System.out.println("Percentual vazão: " + resultado);
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
	
	public void salvar (){
		
		//Usar o data
		
		
	}
}
