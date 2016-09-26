package br.com.pgo.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
//import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.pgo.dao.VendaDAO;
import br.com.pgo.domain.Ua;
import br.com.pgo.domain.Venda;
import br.com.pgo.util.InterpolarUaCalc;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaBeanControllerTest implements Serializable {

	private List<Ua> listaUas;
	private BigDecimal areaUa;
	private BigDecimal garantiaJan, garantiaFev, garantiaMar, garantiaAbr, garantiaMai, garantiaJun, garantiaJul,
			garantiaAgo, garantiaSet, garantiaOut, garantiaNov, garantiaDez;
	private BigDecimal areaDrenagem;
	private Venda venda;
	private int num;
	private HashSet<Venda> listaVenda;
	private int processoMontante;
	private int processoJusante;

	// Instancia elementos para serem trabalhados na tela.
	@PostConstruct
	public void novo() {

		venda = new Venda();
		listaVenda = new HashSet<Venda>();

	}

	// CONSULTAR!
	//Dados serão consultados e lançados novamente na tela dentro das mesmas variáveis
	public void consultar() {

		Iterator<Venda> posicao = listaVenda.iterator();

		while (posicao.hasNext()) {

			Venda atual = posicao.next();

	if (atual.getOutorgante().getProcessoApac() == venda.getOutorgante().getProcessoApac()) {

				venda.setJan(atual.getJan());
				venda.setJan(atual.getFev());
				venda.setJan(atual.getMar());
				venda.setJan(atual.getAbr());
				venda.setJan(atual.getMai());
				venda.setJan(atual.getJun());
				venda.setJan(atual.getJul());
				venda.setJan(atual.getAgo());
				venda.setJan(atual.getSet());
				venda.setJan(atual.getOut());
				venda.setJan(atual.getNov());
				venda.setJan(atual.getDez());

			}

		}
	}
	// ADICIONAR!

	// Adiconar Ua selecionada pelo usuário
	public void adicionar() {

		// Pesquisa Ua pelo número informado pelo usuário em venda.xhtml e
		// adiciona
		// na "listaUas" para ser usada no metódo para calcular interpolação das
		// Uas
		VendaDAO BuscarUA = new VendaDAO();
		listaUas = BuscarUA.buscarUa(num);
		areaUa = listaUas.get(1).getAreaUa();
		num = listaUas.get(1).getNumeroUa();

		if (listaUas.isEmpty()) {

			System.out.println("Nenhum registro encontrado");

		} else {
			int i = 0;
			for (Ua ua : listaUas) {
				i++;

				System.out.println(ua.getNumeroUa());
				System.out.println("Ano da UA: " + ua.getAno());

				venda.setNumeroUa(num);
				venda.setAreaUa(areaUa);
			}

			System.out.println("Quantidade Ua encontrada: " + i);
		}

		System.out.println(num);
	}

	// SIMULAR
	public void simular() {	
			
			adicionar();
			interpolarMeses();
			encaixar();
			cacularDisponibilidade();
			consultar();

		
	}

	// INTERPOLAR!

	// Calculo de interpolação de todos os meses Jan - Dez da Ua selecionada
	// pelo usuário
	@SuppressWarnings("unchecked")
	public void interpolarMeses() {

		List<BigDecimal> ListaJan = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaJan = (List<BigDecimal>) ua.getJan();

		}
		// Receber List de Janeiro que foi setada dentro do listUas
		InterpolarUaCalc interpolarJan = new InterpolarUaCalc();
		venda.setJan(interpolarJan.vendaInterpolar(ListaJan, areaUa, garantiaJan, areaDrenagem));

		List<BigDecimal> ListaFev = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaFev = (List<BigDecimal>) ua.getFev();

		}
		// Receber List de Fevereiro que foi setada dentro do listUas
		InterpolarUaCalc interpolarFev = new InterpolarUaCalc();
		venda.setFev(interpolarFev.vendaInterpolar(ListaFev, areaUa, garantiaFev, areaDrenagem));

		List<BigDecimal> ListaMar = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaMar = (List<BigDecimal>) ua.getMar();

		}

		// Receber List de Março que foi setada dentro do listUas
		InterpolarUaCalc interpolarMar = new InterpolarUaCalc();
		venda.setMar(interpolarMar.vendaInterpolar(ListaMar, areaUa, garantiaMar, areaDrenagem));

		List<BigDecimal> ListaAbr = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaAbr = (List<BigDecimal>) ua.getAbr();

		}
		// Receber List de Abril que foi setada dentro do listUas
		InterpolarUaCalc interpolarAbr = new InterpolarUaCalc();
		venda.setAbr(interpolarAbr.vendaInterpolar(ListaAbr, areaUa, garantiaAbr, areaDrenagem));

		List<BigDecimal> ListaMai = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaMai = (List<BigDecimal>) ua.getMai();

		}
		// Receber List de Maio que foi setada dentro do listUas
		InterpolarUaCalc interpolarMai = new InterpolarUaCalc();
		venda.setMai(interpolarMai.vendaInterpolar(ListaMai, areaUa, garantiaMai, areaDrenagem));

		List<BigDecimal> ListaJun = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaJun = (List<BigDecimal>) ua.getJun();

		}
		// Receber List de Junho que foi setada dentro do listUas
		InterpolarUaCalc interpolarJun = new InterpolarUaCalc();
		venda.setJun(interpolarJun.vendaInterpolar(ListaJun, areaUa, garantiaJun, areaDrenagem));

		List<BigDecimal> ListaJul = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaJul = (List<BigDecimal>) ua.getJul();

		}
		// Receber List de Julho que foi setada dentro do listUas
		InterpolarUaCalc interpolarJul = new InterpolarUaCalc();
		venda.setJul(interpolarJul.vendaInterpolar(ListaJul, areaUa, garantiaJul, areaDrenagem));

		List<BigDecimal> ListaAgo = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaAgo = (List<BigDecimal>) ua.getAgo();

		}
		// Receber List de Agosto que foi setada dentro do listUas
		InterpolarUaCalc interpolarAgo = new InterpolarUaCalc();
		venda.setAgo(interpolarAgo.vendaInterpolar(ListaAgo, areaUa, garantiaAgo, areaDrenagem));

		List<BigDecimal> ListaSet = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaSet = (List<BigDecimal>) ua.getSet();

		}
		// Receber List de Setembro que foi setada dentro do listUas
		InterpolarUaCalc interpolarSet = new InterpolarUaCalc();
		venda.setSet(interpolarSet.vendaInterpolar(ListaSet, areaUa, garantiaSet, areaDrenagem));

		List<BigDecimal> ListaOut = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaOut = (List<BigDecimal>) ua.getOut();

		}
		// Receber List de Outubro que foi setada dentro do listUas
		InterpolarUaCalc interpolarOut = new InterpolarUaCalc();
		venda.setOut(interpolarOut.vendaInterpolar(ListaOut, areaUa, garantiaOut, areaDrenagem));

		List<BigDecimal> ListaNov = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaNov = (List<BigDecimal>) ua.getNov();

		}
		// Receber List de Novembro que foi setada dentro do listUas
		InterpolarUaCalc interpolarNov = new InterpolarUaCalc();
		venda.setNov(interpolarNov.vendaInterpolar(ListaNov, areaUa, garantiaNov, areaDrenagem));

		List<BigDecimal> ListaDez = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaDez = (List<BigDecimal>) ua.getDez();

		}
		// Receber List de Dezembro que foi setada dentro do listUas.
		InterpolarUaCalc interpolarDez = new InterpolarUaCalc();
		venda.setDez(interpolarDez.vendaInterpolar(ListaDez, areaUa, garantiaDez, areaDrenagem));

		// Amarrar controler a tela e testa interpolação!

	}

	// ENCAIXAR!

	// Faz consultado o BD e coloca na listaVenda e adicionar nova venda a
	// Lista.
	public void encaixar() {
		System.out.println("Metodo Encaixar!");
		try {

			VendaDAO vendaDAO = new VendaDAO();
			listaVenda = vendaDAO.listarVenda();
			listaVenda.add(venda);

			System.out.println("Tamanho lista ENCAIXAR: " + listaVenda.size());

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao tentar criar 'Lista de Venda' ");
			erro.printStackTrace();

		}
		Iterator<Venda> posicao = listaVenda.iterator();

		// Encaixa novo elemento na lista, quando as duas condições foram
		// verdadeiras para o laço.
		while (posicao.hasNext()) {

			Venda atual = posicao.next();
			boolean condicao1 = false;
			boolean condicao2 = false;

			if (atual.getOutorgante().getProcessoApac() == processoJusante) {
				atual.setProcessoMotante(processoJusante);
				condicao1 = true;
			}
			if (atual.getOutorgante().getProcessoApac() == processoMontante) {
				atual.setProcessoJusante(processoMontante);
				condicao2 = true;
			}
			if (condicao1 == true && condicao2 == true) {
				break;
			}
		}

	}

	// Calcular disponibilidade
	public void cacularDisponibilidade() {

		Iterator<Venda> posicao = listaVenda.iterator();

		while (posicao.hasNext()) {
			
           //Captacao atual + anterior 
			Venda atual = posicao.next();

			while (posicao.hasNext()) {
				
				Venda proximo = posicao.next();				
				  

				if (atual.getOutorgante().getProcessoApac() == proximo.getProcessoMotante()) {
                    
					
					BigDecimal captacao0 = atual.getCaptacao();
					BigDecimal captacao1 = proximo.getCaptacao();
					BigDecimal somaCaptacao = new BigDecimal(String.valueOf(captacao0))
							.add(new BigDecimal(String.valueOf(captacao1)));
					proximo.setCaptacao(somaCaptacao);
					
					//Disponibilidade Janeiro					
					BigDecimal calcDispJan = new BigDecimal(String.valueOf(proximo.getCaptacao()))
							.subtract(new BigDecimal(String.valueOf(proximo.getJan())));
					proximo.setFev(calcDispJan);
									

					//Disponibilidade Fevereiro					
					BigDecimal calcDispFev = new BigDecimal(String.valueOf(proximo.getCaptacao()))
							.subtract(new BigDecimal(String.valueOf(proximo.getFev())));
					proximo.setFev(calcDispFev);					

					//Disponibilidade Março				
					BigDecimal calcDispMar = new BigDecimal(String.valueOf(proximo.getCaptacao()))
							.subtract(new BigDecimal(String.valueOf(proximo.getMar())));
					proximo.setFev(calcDispMar);

					//Disponibilidade Abril					
					BigDecimal calcDispAbr = new BigDecimal(String.valueOf(proximo.getCaptacao()))
							.subtract(new BigDecimal(String.valueOf(proximo.getAbr())));
					proximo.setFev(calcDispAbr);

					//Disponibilidade Maio					
					BigDecimal calcDispMai = new BigDecimal(String.valueOf(proximo.getCaptacao()))
							.subtract(new BigDecimal(String.valueOf(proximo.getMai())));
					proximo.setFev(calcDispMai);

					//Disponibilidade Junho					
					BigDecimal calcDispJun = new BigDecimal(String.valueOf(proximo.getCaptacao()))
							.subtract(new BigDecimal(String.valueOf(proximo.getJun())));
					proximo.setFev(calcDispJun);					
					
					BigDecimal dispJul0 = atual.getCaptacao();
					BigDecimal dispJul1 = atual.getJul();
					BigDecimal resultDispJul = new BigDecimal(String.valueOf(dispJul0))
							.subtract(new BigDecimal(String.valueOf(dispJul1)));
					proximo.setJul(resultDispJul);

					BigDecimal dispAgo0 = atual.getCaptacao();
					BigDecimal dispAgo1 = atual.getAgo();
					BigDecimal resultDispAgo = new BigDecimal(String.valueOf(dispAgo0))
							.subtract(new BigDecimal(String.valueOf(dispAgo1)));
					proximo.setAgo(resultDispAgo);

					BigDecimal dispSet0 = atual.getCaptacao();
					BigDecimal dispSet1 = atual.getSet();
					BigDecimal resultDispSet = new BigDecimal(String.valueOf(dispSet0))
							.subtract(new BigDecimal(String.valueOf(dispSet1)));
					proximo.setSet(resultDispSet);

					BigDecimal dispOut0 = atual.getCaptacao();
					BigDecimal dispOut1 = atual.getOut();
					BigDecimal resultDispOut = new BigDecimal(String.valueOf(dispOut0))
							.subtract(new BigDecimal(String.valueOf(dispOut1)));
					proximo.setOut(resultDispOut);

					BigDecimal dispNov0 = atual.getCaptacao();
					BigDecimal dispNov1 = atual.getNov();
					BigDecimal resultDispNov = new BigDecimal(String.valueOf(dispNov0))
							.subtract(new BigDecimal(String.valueOf(dispNov1)));
					proximo.setNov(resultDispNov);

					BigDecimal dispDez0 = atual.getCaptacao();
					BigDecimal dispDez1 = atual.getDez();
					BigDecimal resultDispDez = new BigDecimal(String.valueOf(dispDez0))
							.subtract(new BigDecimal(String.valueOf(dispDez1)));
					proximo.setDez(resultDispDez);

				}
			}
		}

	}

	// SALVAR

	public void salvar() {

		VendaDAO salvarProcesso = new VendaDAO();

		Iterator<Venda> atual = listaVenda.iterator();

		while (atual.hasNext()) {

			salvarProcesso.mergeVenda(atual);

		}
	}
}
