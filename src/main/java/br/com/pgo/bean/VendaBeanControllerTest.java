package br.com.pgo.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.omnifaces.util.Messages;
import br.com.pgo.dao.OutorganteDAO;
import br.com.pgo.dao.UsuarioDAO;
import br.com.pgo.dao.VendaDAO;
import br.com.pgo.domain.Outorgante;
import br.com.pgo.domain.Ua;
import br.com.pgo.domain.Usuario;
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
	private BigDecimal resultJan, resultFev, resultMar, resultAbr, resultMai, resultJun, resultJul,
	resultAgo, resultSet, resultOut, resultNov, resultDez;
	//private BigDecimal areaDrenagem;
	private Venda venda; // processoAPAC //Vencimento // Captação - Itens que // vem do venda.xhtml
	private int num;
	private HashSet<Venda> listaVenda;
	//private int processoMontante;
	//private int processoJusante;
	private List<Outorgante> listaOutorgantes;
	private List<Usuario> listaUsuarios;
	
	
	

	public BigDecimal getResultJan() {
		return resultJan;
	}

	public void setResultJan(BigDecimal resultJan) {
		this.resultJan = resultJan;
	}

	public BigDecimal getResultFev() {
		return resultFev;
	}

	public void setResultFev(BigDecimal resultFev) {
		this.resultFev = resultFev;
	}

	public BigDecimal getResultMar() {
		return resultMar;
	}

	public void setResultMar(BigDecimal resultMar) {
		this.resultMar = resultMar;
	}

	public BigDecimal getResultAbr() {
		return resultAbr;
	}

	public void setResultAbr(BigDecimal resultAbr) {
		this.resultAbr = resultAbr;
	}

	public BigDecimal getResultMai() {
		return resultMai;
	}

	public void setResultMai(BigDecimal resultMai) {
		this.resultMai = resultMai;
	}

	public BigDecimal getResultJun() {
		return resultJun;
	}

	public void setResultJun(BigDecimal resultJun) {
		this.resultJun = resultJun;
	}

	public BigDecimal getResultJul() {
		return resultJul;
	}

	public void setResultJul(BigDecimal resultJul) {
		this.resultJul = resultJul;
	}

	public BigDecimal getResultAgo() {
		return resultAgo;
	}

	public void setResultAgo(BigDecimal resultAgo) {
		this.resultAgo = resultAgo;
	}

	public BigDecimal getResultSet() {
		return resultSet;
	}

	public void setResultSet(BigDecimal resultSet) {
		this.resultSet = resultSet;
	}

	public BigDecimal getResultOut() {
		return resultOut;
	}

	public void setResultOut(BigDecimal resultOut) {
		this.resultOut = resultOut;
	}

	public BigDecimal getResultNov() {
		return resultNov;
	}

	public void setResultNov(BigDecimal resultNov) {
		this.resultNov = resultNov;
	}

	public BigDecimal getResultDez() {
		return resultDez;
	}

	public void setResultDez(BigDecimal resultDez) {
		this.resultDez = resultDez;
	}

	public List<Ua> getListaUas() {
		return listaUas;
	}

	public void setListaUas(List<Ua> listaUas) {
		this.listaUas = listaUas;
	}

	public BigDecimal getAreaUa() {
		return areaUa;
	}

	public void setAreaUa(BigDecimal areaUa) {
		this.areaUa = areaUa;
	}

	public BigDecimal getGarantiaJan() {
		return garantiaJan;
	}

	public void setGarantiaJan(BigDecimal garantiaJan) {
		this.garantiaJan = garantiaJan;
	}

	public BigDecimal getGarantiaFev() {
		return garantiaFev;
	}

	public void setGarantiaFev(BigDecimal garantiaFev) {
		this.garantiaFev = garantiaFev;
	}

	public BigDecimal getGarantiaMar() {
		return garantiaMar;
	}

	public void setGarantiaMar(BigDecimal garantiaMar) {
		this.garantiaMar = garantiaMar;
	}

	public BigDecimal getGarantiaAbr() {
		return garantiaAbr;
	}

	public void setGarantiaAbr(BigDecimal garantiaAbr) {
		this.garantiaAbr = garantiaAbr;
	}

	public BigDecimal getGarantiaMai() {
		return garantiaMai;
	}

	public void setGarantiaMai(BigDecimal garantiaMai) {
		this.garantiaMai = garantiaMai;
	}

	public BigDecimal getGarantiaJun() {
		return garantiaJun;
	}

	public void setGarantiaJun(BigDecimal garantiaJun) {
		this.garantiaJun = garantiaJun;
	}

	public BigDecimal getGarantiaJul() {
		return garantiaJul;
	}

	public void setGarantiaJul(BigDecimal garantiaJul) {
		this.garantiaJul = garantiaJul;
	}

	public BigDecimal getGarantiaAgo() {
		return garantiaAgo;
	}

	public void setGarantiaAgo(BigDecimal garantiaAgo) {
		this.garantiaAgo = garantiaAgo;
	}

	public BigDecimal getGarantiaSet() {
		return garantiaSet;
	}

	public void setGarantiaSet(BigDecimal garantiaSet) {
		this.garantiaSet = garantiaSet;
	}

	public BigDecimal getGarantiaOut() {
		return garantiaOut;
	}

	public void setGarantiaOut(BigDecimal garantiaOut) {
		this.garantiaOut = garantiaOut;
	}

	public BigDecimal getGarantiaNov() {
		return garantiaNov;
	}

	public void setGarantiaNov(BigDecimal garantiaNov) {
		this.garantiaNov = garantiaNov;
	}

	public BigDecimal getGarantiaDez() {
		return garantiaDez;
	}

	public void setGarantiaDez(BigDecimal garantiaDez) {
		this.garantiaDez = garantiaDez;
	}

	/*public BigDecimal getAreaDrenagem() {
		return areaDrenagem;
	}

	public void setAreaDrenagem(BigDecimal areaDrenagem) {
		this.areaDrenagem = areaDrenagem;
	}*/

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public HashSet<Venda> getListaVenda() {
		return listaVenda;
	}

	public void setListaVenda(HashSet<Venda> listaVenda) {
		this.listaVenda = listaVenda;
	}

	/*public int getProcessoMontante() {
		return processoMontante;
	}

	public void setProcessoMontante(int processoMontante) {
		this.processoMontante = processoMontante;
	}

	public int getProcessoJusante() {
		return processoJusante;
	}

	public void setProcessoJusante(int processoJusante) {
		this.processoJusante = processoJusante;
	}*/

	public List<Outorgante> getListaOutorgantes() {
		return listaOutorgantes;
	}

	public void setListaOutorgantes(List<Outorgante> listaOutorgantes) {
		this.listaOutorgantes = listaOutorgantes;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	// Instancia elementos para serem trabalhados na tela.
	@PostConstruct
	public void novo() {
		listar();
		venda = new Venda();
		listaVenda = new HashSet<Venda>();

	}

	// Listar usuários e outorgante para serem usando no
	// venda.xhtml (<p:outputLabel>)
	public void listar() {

		try {

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			listaUsuarios = usuarioDAO.listar("login");

			OutorganteDAO outorganteDAO = new OutorganteDAO();
			listaOutorgantes = outorganteDAO.listar("processoApac");

		} catch (RuntimeException erro) {

			Messages.addGlobalError("Ocorreu um erro ao criar processo");
			erro.printStackTrace();

		}

	}

	// CONSULTAR!
	// Dados serão consultados e lançados novamente na tela dentro das mesmas
	// variáveis
	public void consultar() {

		Iterator<Venda> posicao = listaVenda.iterator();

		while (posicao.hasNext()) {

			Venda atual = posicao.next();

			if (atual.getOutorgante().getProcessoApac() == venda.getOutorgante().getProcessoApac()) {

				venda.setJan(atual.getJan());				
				venda.setFev(atual.getFev());
				venda.setMar(atual.getMar());
				venda.setAbr(atual.getAbr());
				venda.setMai(atual.getMai());
				venda.setJun(atual.getJun());
				venda.setJul(atual.getJul());
				venda.setAgo(atual.getAgo());
				venda.setSet(atual.getSet());
				venda.setOut(atual.getOut());
				venda.setNov(atual.getNov());
				venda.setDez(atual.getDez());

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
		salvar();
	}

	// INTERPOLAR!

	// Calculo de interpolação de todos os meses Jan - Dez da Ua selecionada
	// pelo usuário
	public void interpolarMeses() {
		
       // venda.setAreaDrenagem(areaDrenagem); //Adicionando Area Drenagem Outorgante ao Objeto Venda
        
		List<BigDecimal> ListaJan = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {
			ListaJan.add(ua.getJan());
		}
		// Receber List de Janeiro que foi setada dentro do listUas
		InterpolarUaCalc interpolarJan = new InterpolarUaCalc();
		venda.setJan(interpolarJan.vendaInterpolar(ListaJan, areaUa, garantiaJan, venda.getAreaDrenagem()));
		
        System.out.println("AREA DRENAGEM DENTRO DO CALC "+venda.getAreaDrenagem());
        
		List<BigDecimal> ListaFev = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaFev.add(ua.getFev());

		}
		// Receber List de Fevereiro que foi setada dentro do listUas
		InterpolarUaCalc interpolarFev = new InterpolarUaCalc();
		venda.setFev(interpolarFev.vendaInterpolar(ListaFev, areaUa, garantiaFev, venda.getAreaDrenagem()));

		List<BigDecimal> ListaMar = new ArrayList<BigDecimal>();
		
		for (Ua ua : listaUas) {

			ListaMar.add(ua.getMar());

		}

		// Receber List de Março que foi setada dentro do listUas
		InterpolarUaCalc interpolarMar = new InterpolarUaCalc();
		venda.setMar(interpolarMar.vendaInterpolar(ListaMar, areaUa, garantiaMar, venda.getAreaDrenagem()));

		List<BigDecimal> ListaAbr = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaAbr.add(ua.getAbr());

		}
		// Receber List de Abril que foi setada dentro do listUas
		InterpolarUaCalc interpolarAbr = new InterpolarUaCalc();
		venda.setAbr(interpolarAbr.vendaInterpolar(ListaAbr, areaUa, garantiaAbr, venda.getAreaDrenagem()));

		List<BigDecimal> ListaMai = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaMai.add(ua.getMai());

		}
		// Receber List de Maio que foi setada dentro do listUas
		InterpolarUaCalc interpolarMai = new InterpolarUaCalc();
		venda.setMai(interpolarMai.vendaInterpolar(ListaMai, areaUa, garantiaMai, venda.getAreaDrenagem()));

		List<BigDecimal> ListaJun = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaJun.add(ua.getJun());

		}
		// Receber List de Junho que foi setada dentro do listUas
		InterpolarUaCalc interpolarJun = new InterpolarUaCalc();
		venda.setJun(interpolarJun.vendaInterpolar(ListaJun, areaUa, garantiaJun, venda.getAreaDrenagem()));

		List<BigDecimal> ListaJul = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaJul.add(ua.getJul());

		}
		// Receber List de Julho que foi setada dentro do listUas
		InterpolarUaCalc interpolarJul = new InterpolarUaCalc();
		venda.setJul(interpolarJul.vendaInterpolar(ListaJul, areaUa, garantiaJul, venda.getAreaDrenagem()));

		List<BigDecimal> ListaAgo = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaAgo.add(ua.getAgo());

		}
		// Receber List de Agosto que foi setada dentro do listUas
		InterpolarUaCalc interpolarAgo = new InterpolarUaCalc();
		venda.setAgo(interpolarAgo.vendaInterpolar(ListaAgo, areaUa, garantiaAgo, venda.getAreaDrenagem()));

		List<BigDecimal> ListaSet = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaSet.add(ua.getSet());

		}
		// Receber List de Setembro que foi setada dentro do listUas
		InterpolarUaCalc interpolarSet = new InterpolarUaCalc();
		venda.setSet(interpolarSet.vendaInterpolar(ListaSet, areaUa, garantiaSet, venda.getAreaDrenagem()));

		List<BigDecimal> ListaOut = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaOut.add(ua.getOut());

		}
		// Receber List de Outubro que foi setada dentro do listUas
		InterpolarUaCalc interpolarOut = new InterpolarUaCalc();
		venda.setOut(interpolarOut.vendaInterpolar(ListaOut, areaUa, garantiaOut, venda.getAreaDrenagem()));

		List<BigDecimal> ListaNov = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaNov.add(ua.getNov());

		}
		// Receber List de Novembro que foi setada dentro do listUas
		InterpolarUaCalc interpolarNov = new InterpolarUaCalc();
		venda.setNov(interpolarNov.vendaInterpolar(ListaNov, areaUa, garantiaNov, venda.getAreaDrenagem()));

		List<BigDecimal> ListaDez = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas) {

			ListaDez.add(ua.getDez());

		}
		// Receber List de Dezembro que foi setada dentro do listUas.
		InterpolarUaCalc interpolarDez = new InterpolarUaCalc();
		venda.setDez(interpolarDez.vendaInterpolar(ListaDez, areaUa, garantiaDez, venda.getAreaDrenagem()));

		// Amarrar controler a tela e testa interpolação!

	}

	// ENCAIXAR!

	// Faz consultado o BD e coloca na listaVenda e adicionar nova venda a
	// Lista.
	public void encaixar() {
		
		//venda.setProcessoMotante(processoMontante);
		//venda.setProcessoJusante(processoJusante);
		
		// SALVA VENDA NO BANCO ANTES DE JOGAR NA LISTA
		try{
			
			VendaDAO vendaDAO = new VendaDAO();
			vendaDAO.mergeVenda(venda);
			
		}
		catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao salvar usuário no método encaixar!");
			erro.printStackTrace();
		}	
		
		//FAZ CONSULTA NO BANCO E COLOCA NA LISTA!
		try {

			VendaDAO vendaDAO = new VendaDAO();
			HashSet<Venda> listaVendaBD = vendaDAO.listarVenda();				
			listaVenda = listaVendaBD;			

			System.out.println("Tamanho lista ENCAIXAR no TRY: " + listaVenda.size());

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao tentar criar 'Lista de Venda' ");
			erro.printStackTrace();

		}
		
		System.out.println("Tamanho lista ENCAIXAR depois do CATCH: " + listaVenda.size());
		
		
		

		System.out.println("Metodo Encaixar!");
		
		System.out.println("Processo MONTANTE"+venda.getProcessoMontante());
		System.out.println("Processo JUSANTE"+venda.getProcessoJusante());
		
		
		System.out.println("Tamanho lista ENCAIXAR: " + listaVenda.size());
		
		for(Venda venda: listaVenda){
			
			System.out.println("LISTA DENTRO DO MÉTODO ENCAIXAR");
			
			System.out.println("Processo APAC" +venda.getOutorgante().getProcessoApac());
			System.out.println("Processo Montante " +venda.getProcessoMontante());
			System.out.println("Processo Jusante " +venda.getProcessoJusante());
			System.out.println("Usuario Sistema" +venda.getUsuario());
			System.out.println("Numero da UA " +venda.getNumeroUa());			
			System.out.println("Area drenagem Outorgante " +venda.getAreaDrenagem());
			System.out.println("Area UA " +venda.getAreaUa());
			System.out.println("Captação Outorgante " +venda.getCaptacao());
			System.out.println("Vencimento " +venda.getVencimento());
			System.out.println("Janeiro " +venda.getJan());
			System.out.println("Fevereiro " +venda.getFev());
			System.out.println("Março " +venda.getMar());
			System.out.println("Abril " +venda.getAbr());
			System.out.println("Maio " +venda.getMai());
			System.out.println("Junho " +venda.getJun());
			System.out.println("Julho " +venda.getJul());
			System.out.println("Agosto " +venda.getAgo());
			System.out.println("Setembro " +venda.getSet());
			System.out.println("Outubro " +venda.getOut());
			System.out.println("Novembro " +venda.getNov());
			System.out.println("Dezembro " +venda.getDez());
			
			System.out.println("FIM DA LISTA DENTRO DO MÉTODO ENCAIXAR");
			
		}
		
		System.out.println("Tamanho lista ENCAIXAR: " + listaVenda.size());

	

		// Encaixa novo elemento na lista, quando as duas condições foram
		// verdadeiras para o laço.
		Iterator<Venda> posicao = listaVenda.iterator();
		while (posicao.hasNext()) {

			System.out.println("Dentro do While!");

			Venda atual = posicao.next();
			boolean condicao1 = false;
			boolean condicao2 = false;

			if (venda.getProcessoMontante()!= 0) {

				System.out.println("Dentro do IF!");

				if (atual.getOutorgante().getProcessoApac() == venda.getProcessoJusante()) {
					atual.setProcessoMontante(venda.getProcessoJusante());
					condicao1 = true;
				}
				
				if (atual.getOutorgante().getProcessoApac() == venda.getProcessoMontante()) {
					atual.setProcessoJusante(venda.getProcessoMontante());
					condicao2 = true;
				}
				
				if (condicao1 == true && condicao2 == true) {
					break;
				}				

			}
		}
		
		System.out.println("FIM do While!");
	}

	// Calcular disponibilidade
	public void cacularDisponibilidade() {
		
		
		System.out.println("Dentro método Disponibilidade!"+venda.getCaptacao());
		
		venda.setCaptacao(new BigDecimal(String.valueOf(venda.getCaptacao()))
		.divide(new BigDecimal(String.valueOf(100)),4,RoundingMode.UP));
		
		System.out.println("Depois da conversao em percentual!"+venda.getCaptacao());
		
		Iterator<Venda> posicao = listaVenda.iterator();

		//Venda atual = null;

		while (posicao.hasNext()) {
			System.out.println("Dentro método Disponibilidade - WHILE!");
			Venda atual = posicao.next();

			if (atual.getProcessoMontante() == 0) {
				// Primeiro processo do rio
				  //jusante = posicao.next();

				// Captação primeiro outorgante do rio
				System.out.println("getCaptação ANTES - "+atual.getCaptacao());
				System.out.println("getJan ANTES - "+atual.getJan());
				
				// Disponibilidade Janeiro
				BigDecimal calcDispJanIni = new BigDecimal(String.valueOf(atual.getJan()))
				.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
				atual.setJan(calcDispJanIni);
				//resultJan=calcDispJanIni;
				
				System.out.println("CALCULO"+calcDispJanIni);
                 
				System.out.println("getCaptação DEPOIS - "+atual.getCaptacao());
				System.out.println("getJan DEPOIS - "+atual.getJan());
				System.out.println("getJan vendaJAN - "+venda.getJan());
				
				// Disponibilidade Fevereiro
				BigDecimal calcDispFevIni = new BigDecimal(String.valueOf(atual.getFev()))
				.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
				atual.setFev(calcDispFevIni);
				//resultFev=calcDispFevIni;

				// Disponibilidade Março
				BigDecimal calcDispMarIni = new BigDecimal(String.valueOf(atual.getMar()))
				.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
				atual.setMar(calcDispMarIni);
				resultMar=calcDispMarIni;

				// Disponibilidade Abril
				BigDecimal calcDispAbrIni = new BigDecimal(String.valueOf(atual.getAbr()))
				.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
				atual.setAbr(calcDispAbrIni);
				//resultAbr=calcDispAbrIni;

				// Disponibilidade Maio
				BigDecimal calcDispMaiIni = new BigDecimal(String.valueOf(atual.getMai()))
				.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
				atual.setMai(calcDispMaiIni);
				//resultMai=calcDispMaiIni;

				// Disponibilidade Junho
				BigDecimal calcDispJunIni = new BigDecimal(String.valueOf(atual.getJun()))
				.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
				atual.setJun(calcDispJunIni);
				//resultJun=calcDispJunIni;

				// Disponibilidade Julho
				BigDecimal calcDispJulIni = new BigDecimal(String.valueOf(atual.getJul()))
				.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
				atual.setJul(calcDispJulIni);
				//resultJul=calcDispJulIni;

				// Disponibilidade Ago
				BigDecimal calcDispAgoIni = new BigDecimal(String.valueOf(atual.getAgo()))
				.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
				atual.setAgo(calcDispAgoIni);
				//resultAgo=calcDispAgoIni;

				// Disponibilidade Set
				BigDecimal calcDispSetIni = new BigDecimal(String.valueOf(atual.getSet()))
				.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
				atual.setSet(calcDispSetIni);
				//resultSet=calcDispSetIni;

				// Disponibilidade Out
				BigDecimal calcDispOutIni = new BigDecimal(String.valueOf(atual.getOut()))
				.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
				atual.setOut(calcDispOutIni);
				//resultOut=calcDispOutIni;

				// Disponibilidade Nov
				BigDecimal calcDispNovIni = new BigDecimal(String.valueOf(atual.getNov()))
				.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
				atual.setNov(calcDispNovIni);
				//resultNov=calcDispNovIni;

				// Disponibilidade Dez
				BigDecimal calcDispDezIni = new BigDecimal(String.valueOf(atual.getDez()))
				.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
				atual.setDez(calcDispDezIni);
				//resultDez=calcDispDezIni;

				break;
			}
		}
		
		// Dois laços While separado pois antes de começar precisamos calcular o montante para depois fazer o resto das operações
		// de calculo

		while (posicao.hasNext()) {

			Venda atual = posicao.next();

			while (posicao.hasNext()) {

				Venda proximo = posicao.next();

				if (atual.getOutorgante().getProcessoApac() == proximo.getProcessoMontante()) {

					BigDecimal captacao0 = atual.getCaptacao();
					BigDecimal captacao1 = proximo.getCaptacao();
					BigDecimal somaCaptacao = new BigDecimal(String.valueOf(captacao0))
					.add(new BigDecimal(String.valueOf(captacao1)));
					atual.setCaptacao(somaCaptacao);

					// Disponibilidade Janeiro
					BigDecimal calcDispJan = new BigDecimal(String.valueOf(atual.getJan()))
							.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
					atual.setJan(calcDispJan);

					// Disponibilidade Fevereiro
					BigDecimal calcDispFev = new BigDecimal(String.valueOf(atual.getFev()))
							.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
					atual.setFev(calcDispFev);

					// Disponibilidade Março
					BigDecimal calcDispMar = new BigDecimal(String.valueOf(atual.getMar()))
							.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
					atual.setFev(calcDispMar);

					// Disponibilidade Abril
					BigDecimal calcDispAbr = new BigDecimal(String.valueOf(atual.getAbr()))
							.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
					atual.setFev(calcDispAbr);

					// Disponibilidade Maio
					BigDecimal calcDispMai = new BigDecimal(String.valueOf(atual.getMai()))
							.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
					atual.setFev(calcDispMai);

					// Disponibilidade Junho
					BigDecimal calcDispJun = new BigDecimal(String.valueOf(atual.getJun()))
							.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
					atual.setFev(calcDispJun);

					// Disponibilidade Julho
					BigDecimal calcDispJul = new BigDecimal(String.valueOf(atual.getJul()))
							.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
					atual.setFev(calcDispJul);

					// Disponibilidade Ago
					BigDecimal calcDispAgo = new BigDecimal(String.valueOf(atual.getAgo()))
							.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
					atual.setFev(calcDispAgo);

					// Disponibilidade Set
					BigDecimal calcDispSet = new BigDecimal(String.valueOf(atual.getSet()))
							.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
					atual.setFev(calcDispSet);

					// Disponibilidade Out
					BigDecimal calcDispOut = new BigDecimal(String.valueOf(atual.getOut()))
							.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
					atual.setFev(calcDispOut);

					// Disponibilidade Nov
					BigDecimal calcDispNov = new BigDecimal(String.valueOf(atual.getNov()))
							.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
					atual.setFev(calcDispNov);

					// Disponibilidade Dez
					BigDecimal calcDispDez = new BigDecimal(String.valueOf(atual.getDez()))
							.subtract(new BigDecimal(String.valueOf(atual.getCaptacao())));
					atual.setFev(calcDispDez);

				}
			}
		}

	}

	// SALVAR

	public void salvar() {		
		
   System.out.println("Dentro do método SALVAR!");
   
   try{
	   
	   System.out.println("Dentro do TRY no método SALVAR!");
	   
	   VendaDAO salvarProcesso = new VendaDAO();
	   
	   Iterator<Venda> posicao = listaVenda.iterator();
	   
	   while (posicao.hasNext()) {
		   
		 System.out.println("Dentro do  WHILE no método SALVAR!");
		 
		 Venda venda = posicao.next();
		 salvarProcesso.merge(venda);
		 System.out.println(venda.getNumeroUa());
		 
     }
	   Messages.addGlobalInfo("Usuário salvo com sucesso!");
	   
   } catch (RuntimeException erro) {

		Messages.addGlobalInfo("Erro ao salvar usuário!");
		erro.printStackTrace();
	}				

		}
	}

