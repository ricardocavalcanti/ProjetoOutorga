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
public class VendaBean implements Serializable {

	private List<Ua> listaUas;
	private BigDecimal areaUa;
	private BigDecimal garantiaJan, garantiaFev, garantiaMar, garantiaAbr, garantiaMai, garantiaJun, garantiaJul,
	garantiaAgo, garantiaSet, garantiaOut, garantiaNov, garantiaDez;
	private BigDecimal resultJan, resultFev, resultMar, resultAbr, resultMai, resultJun, resultJul,
	resultAgo, resultSet, resultOut, resultNov, resultDez;	
	private Venda venda; // processoAPAC //Vencimento // Captação - Itens que // vem do venda.xhtml
	private int num;
	private HashSet<Venda> listaVenda;	
	private List<Outorgante> listaOutorgantes;
	private List<Usuario> listaUsuarios;
	private List<Venda> ordenacaoRio;	

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

	
	@PostConstruct	
	public void novo() {
		
		listar();
		venda = new Venda();
		listaVenda = new HashSet<Venda>();
		listaUas = new ArrayList<Ua>();
		ordenacaoRio = new ArrayList<Venda>();
		areaUa = BigDecimal.ZERO;
		
		garantiaJan = BigDecimal.ZERO; garantiaFev = BigDecimal.ZERO; garantiaMar = BigDecimal.ZERO; garantiaAbr = BigDecimal.ZERO;
		garantiaMai = BigDecimal.ZERO; garantiaJun = BigDecimal.ZERO; garantiaJul = BigDecimal.ZERO;garantiaAgo = BigDecimal.ZERO; 
		garantiaSet = BigDecimal.ZERO; garantiaOut = BigDecimal.ZERO; garantiaNov = BigDecimal.ZERO;
		garantiaDez = BigDecimal.ZERO;	
		
		resultJan = BigDecimal.ZERO; resultFev = BigDecimal.ZERO; resultMar = BigDecimal.ZERO; resultAbr = BigDecimal.ZERO; 
		resultMai = BigDecimal.ZERO; resultJun = BigDecimal.ZERO; resultJul = BigDecimal.ZERO; resultAgo = BigDecimal.ZERO; 
		resultSet = BigDecimal.ZERO; resultOut = BigDecimal.ZERO; resultNov = BigDecimal.ZERO;
		resultDez = BigDecimal.ZERO;
		
		num = 0;
				
		
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
	/** Dados serão consultados na lista SET listaVenda e lançados novamente na tela dentro das mesmas
	variáveis **/
	
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

		/** Pesquisa Ua pelo número informado pelo usuário em venda.xhtml e
		 adiciona na "listaUas" para ser usada no metódo para calcular 
		 interpolação das Uas */
		
		VendaDAO BuscarUA = new VendaDAO();
		listaUas = BuscarUA.buscarUa(num); 
		areaUa = listaUas.get(1).getAreaUa();
		num = listaUas.get(1).getNumeroUa();

		if (listaUas.isEmpty()) {

			Messages.addGlobalInfo("Numero da UA não localizada!");
			

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
		//salvar();
	}

	// INTERPOLAR!

	/** Calculo de interpolação de todos os meses Jan - Dez da Ua selecionada
	 pelo usuário, capturara no metodo Adicionar() **/
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

	/** Faz consultado o BD e coloca na listaVenda e adicionar nova venda a
	 Lista. **/
	public void encaixar() {				
		
		try {

			VendaDAO vendaDAO = new VendaDAO();
			HashSet<Venda> listaVendaBD = vendaDAO.listarVenda();				
			listaVenda = listaVendaBD;
			listaVenda.add(venda);
			System.out.println("LISTA: "+listaVenda.size());
		

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

	

		/** Encaixa novo elemento na lista, quando as duas condições foram
		 verdadeiras para o laço. **/
		
		Iterator<Venda> posicao = listaVenda.iterator();
		while (posicao.hasNext()) {

			System.out.println("Dentro do While!");

			Venda atual = posicao.next();
			boolean condicao1 = false;
			boolean condicao2 = false;

			if (venda.getProcessoMontante()!= 0) {

				System.out.println("Dentro do IF!");

				if (atual.getOutorgante().getProcessoApac() == venda.getProcessoJusante()) {
					atual.setProcessoMontante(venda.getOutorgante().getProcessoApac());
					condicao1 = true;
				}
				
				if (atual.getOutorgante().getProcessoApac() == venda.getProcessoMontante()) {
					atual.setProcessoJusante(venda.getOutorgante().getProcessoApac());
					condicao2 = true;
				}
				// Erro na lógica, pois sempre vão ser falso! Dentro do While
				if (condicao1 == true && condicao2 == true) {
					break;
				}				

			}
		}
		
		System.out.println("FIM do While!");
	}

	//Calcular disponibilidade
	public void cacularDisponibilidade() {
		
		/** Instancia elementos para serem trabalhados na tela.
		 * Limpa a tela zerando todas as listas e variaveis para nova simulação
		 */		
		venda.setCaptacao(venda.getCaptacaoNoPonto());
		
		/**
		 * venda.getCaptcaoNoPonto() é quanto o outorgante está usando
		 * e esse valor será passado para venda.setCaptacao, e este será
		 * a captação acumulada no ponto ex: ponto montante = 2 + ponto atual =6
		 * logo a captação (acumulada) será = 8
		 * 
		 * 
		 */
		
		ordenacaoRio = new ArrayList<Venda>();
		
		//Transformando em percentual o valor da captação, divido o valor por 100		
		System.out.println("Dentro método Disponibilidade!"+venda.getCaptacao());
		
	/*	venda.setCaptacao(new BigDecimal(String.valueOf(venda.getCaptacao()))
		.divide(new BigDecimal(String.valueOf(100)),4,RoundingMode.UP));
		
		System.out.println("Depois da conversao em percentual!"+venda.getCaptacao());*/
		
		Iterator<Venda> posicao = listaVenda.iterator();
		
		System.out.println("TAMANHO DA LISTA VENDA: "+listaVenda.size());
		
	   //Ordenação dos processos do Rio para calcular disponibilidade		
		List <Venda> listaAux = new ArrayList<Venda>();		
		
		while (posicao.hasNext()){
			
			Venda rio = posicao.next(); 
			listaAux.add(rio);
		}
		
		System.out.println("LISTA AUX: "+ listaAux.size());
		//Primeiro rio da listaAux, Rio com montante igual a ZERO!
		for(Venda rio : listaAux){
			
			if (rio.getProcessoMontante() == 0) {
				 ordenacaoRio.add(rio);
				 System.out.println("PRIMEIRO RIO: "+rio.getProcessoMontante());
			}
		}
		
		System.out.println("INICIO LISTA: "+ordenacaoRio.size());
	   //Ordenando a lista dos rios com relação aos processos	
	   Venda rio = ordenacaoRio.get(0);
	   Venda rio2 = null;
	   
	   for(int i = 0; i< listaAux.size(); ++i){ 
		   
		   System.out.println(i);
		   		
		   for(int z = 0; z< listaAux.size(); ++z){	
		 
			rio2 = listaAux.get(z);   
			/**rio é o primeiro rio da lista e rio2 é o rio da posição corrente, será comparado
			 * caso sejam iguais o processo montante com o jusante, será adicionado a lista 'ordenacaoRio.add(rio2)'
			 * e o valor do rio2 será passado para o rio onde faço nova comparação.
			 * 
			 */
			if (rio.getProcessoJusante() == rio2.getOutorgante().getProcessoApac()){ 
				
				ordenacaoRio.add(rio2);
				System.out.println(z);
				System.out.println("ORDENAÇÃO: "+rio2.getProcessoMontante());
				//Se forem iguais variável rio recebe valor da variável rio2
				rio = rio2;	
				System.out.println("RIO RECEBENDO RIO 2"+rio.getProcessoMontante());
			  }
    	    }	//lista ordenaçãoRio são todos os rios em ordem que estão no banco de dados   
	   }		 
		 
        int i=0;	
		for(Venda ordem : ordenacaoRio){
			i++;
			System.out.println("Processo: "+i+": "+ordem.getProcessoMontante());
			
		}	
		
		/**
		 * Calculo das vazões acumuladas dos rios anteriores
		 * 
		 */
		/*if(venda.getProcessoMontante() == 0){
	
          //Calculo da disponibilidade do primeiro rio onde processo montante é igual a zero
		 // essa lista ordenacaoRio já está em ordem portanto o indice zero é o primeiro rio 
		
		 System.out.println("Primeiro Rio: "+ordenacaoRio.get(0).getProcessoMontante());
		 
		 BigDecimal calcDispJanIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(0).getJan()))
		 .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(0).getCaptacao())));		 
		 ordenacaoRio.get(0).setJan(calcDispJanIni1);
		 
		 BigDecimal calcDispFevIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(0).getFev()))
		 .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(0).getCaptacao())));		 
		 ordenacaoRio.get(0).setFev(calcDispFevIni1);
		 
		 BigDecimal calcDispMarIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(0).getMar()))
		 .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(0).getCaptacao())));		 
		 ordenacaoRio.get(0).setMar(calcDispMarIni1);
		 
		 BigDecimal calcDispAbrIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(0).getAbr()))
		 .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(0).getCaptacao())));		 
		 ordenacaoRio.get(0).setAbr(calcDispAbrIni1);
		 
		 BigDecimal calcDispMaiIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(0).getMai()))
		 .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(0).getCaptacao())));		 
		 ordenacaoRio.get(0).setMai(calcDispMaiIni1);
		 
		 BigDecimal calcDispJunIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(0).getJun()))
		 .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(0).getCaptacao())));		 
		 ordenacaoRio.get(0).setJun(calcDispJunIni1);
		 
		 BigDecimal calcDispJulIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(0).getJul()))
		.subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(0).getCaptacao())));		 
	    ordenacaoRio.get(0).setJul(calcDispJulIni1);
	    
	    BigDecimal calcDispAgoIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(0).getAgo()))
	    .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(0).getCaptacao())));		 
	   	ordenacaoRio.get(0).setAgo(calcDispAgoIni1);
	   	
	   	BigDecimal calcDispSetIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(0).getSet()))
	   	.subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(0).getCaptacao())));		 
	    ordenacaoRio.get(0).setSet(calcDispSetIni1);
	    
	    BigDecimal calcDispOutIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(0).getOut()))
	   	.subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(0).getCaptacao())));		 
	   	ordenacaoRio.get(0).setOut(calcDispOutIni1);
	   	
	   	BigDecimal calcDispNovIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(0).getNov()))
	   	.subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(0).getCaptacao())));		 
	   	ordenacaoRio.get(0).setNov(calcDispNovIni1);
	   	
	   	BigDecimal calcDispDezIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(0).getDez()))
	    .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(0).getCaptacao())));		 
	   	ordenacaoRio.get(0).setDez(calcDispDezIni1);		 
		 
		} else{

		//Calculo da vazao menos a disponibilidade do Rio
	   	//Dos outros processos menos o primeiro processo que o montante é igual a zero*/
		
        for(int z = 0; z<ordenacaoRio.size(); z++){ 
        	
        	if(ordenacaoRio.get(z).getProcessoMontante() == 0){
        		
        	System.out.println("DENTRO DO IF MONTANTE IGUAL A ZERO");
        	/**Calculo da disponibilidade do primeiro rio onde processo montante é igual a zero
       		essa lista ordenacaoRio já está em ordem portanto o indice zero é o primeiro rio **/
        		
        		
        	System.out.println("VAZAO JANEIRO ANTES OPERAÇÃO: "+ordenacaoRio.get(z).getJan());	
        	
        	System.out.println("CAPTACAO ANTES DE ZERAR"+ordenacaoRio.get(z).getCaptacao());
        		
        	ordenacaoRio.get(z).setCaptacao(BigDecimal.ZERO);
            ordenacaoRio.get(z).setCaptacao(ordenacaoRio.get(z).getCaptacaoNoPonto());

            ordenacaoRio.get(z).setCaptacao(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacaoNoPonto()))
            .divide(new BigDecimal(String.valueOf(100)),4,RoundingMode.UP));
    		
    		//System.out.println("Depois da conversao em percentual!"+venda.getCaptacao());
            	
            System.out.println("CAPTACAO DEPOIS DE ZERAR"+ordenacaoRio.get(z).getCaptacao());        		
            System.out.println("getCAPTACAO MONTANTE"+ordenacaoRio.get(z).getCaptacao());
      		
      		 System.out.println("Primeiro Rio: "+ordenacaoRio.get(0).getProcessoMontante());
      		 
      		 BigDecimal calcDispJanIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getJan()))
      		 .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));		 
      		 ordenacaoRio.get(z).setJan(calcDispJanIni1);
      		 
      		 
      		 
      		System.out.println("CAPTAÇÃO ACUMULADA: "+ordenacaoRio.get(z).getCaptacao());
            System.out.println("VAZAO JANEIRO DEPOIS OPERAÇÃO: "+ordenacaoRio.get(z).getJan());
            System.out.println("RESULTADO DO CALC VAZAO: "+calcDispJanIni1);
      		 
      		 
      		 
      		 BigDecimal calcDispFevIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getFev()))
      		 .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));		 
      		 ordenacaoRio.get(z).setFev(calcDispFevIni1);
      		 
      		 BigDecimal calcDispMarIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getMar()))
      		 .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));		 
      		 ordenacaoRio.get(z).setMar(calcDispMarIni1);
      		 
      		 BigDecimal calcDispAbrIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getAbr()))
      		 .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));		 
      		 ordenacaoRio.get(z).setAbr(calcDispAbrIni1);
      		 
      		 BigDecimal calcDispMaiIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getMai()))
      		 .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));		 
      		 ordenacaoRio.get(z).setMai(calcDispMaiIni1);
      		 
      		 BigDecimal calcDispJunIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getJun()))
      		 .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));		 
      		 ordenacaoRio.get(z).setJun(calcDispJunIni1);
      		 
      		 BigDecimal calcDispJulIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getJul()))
      		.subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));		 
      	    ordenacaoRio.get(z).setJul(calcDispJulIni1);
      	    
      	     BigDecimal calcDispAgoIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getAgo()))
      	     .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));		 
      	   	 ordenacaoRio.get(z).setAgo(calcDispAgoIni1);
      	   	
      	   	 BigDecimal calcDispSetIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getSet()))
      	   	.subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));		 
      	    ordenacaoRio.get(z).setSet(calcDispSetIni1);
      	    
      	     BigDecimal calcDispOutIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getOut()))
      	   	.subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));		 
      	   	ordenacaoRio.get(z).setOut(calcDispOutIni1);
      	   	
      	   	BigDecimal calcDispNovIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getNov()))
      	   	.subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));		 
      	   	ordenacaoRio.get(z).setNov(calcDispNovIni1);
      	   	
      	   	BigDecimal calcDispDezIni1 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getDez()))
      	    .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));		 
      	   	ordenacaoRio.get(z).setDez(calcDispDezIni1);        	
        	
        	
        	
        	
       // Os rios estão em ordem, portanto sei que ordenacaoRio.get(z) irá de  0 até fim da lista na ordem 	
       // Venda processoRio = ordenacaoRio.get(z);
        	
       // if(processoRio.getProcessoMontante()!=0){
        	}
        	
            if (ordenacaoRio.get(z).getProcessoMontante()!=0) {
        	
            	System.out.println("CAPTACAO ANTES DE ZERAR"+ordenacaoRio.get(z).getCaptacao());
            	
            	ordenacaoRio.get(z).setCaptacao(BigDecimal.ZERO);
            	ordenacaoRio.get(z).setCaptacao(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacaoNoPonto())).divide(new BigDecimal(String.valueOf(100)),4,RoundingMode.UP));
            	
            	
            	System.out.println("CAPTACAO DEPOIS DE ZERAR"+ordenacaoRio.get(z).getCaptacao());
            	
            	
        	//Captação acumulada do processo anterior com o processo corrente
        	BigDecimal captacao0 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao()));
			BigDecimal captacao1 = new BigDecimal(String.valueOf(ordenacaoRio.get(z-1).getCaptacao()));
			BigDecimal somaCaptacao = new BigDecimal(String.valueOf(captacao0)).add(new BigDecimal(String.valueOf(captacao1)));
			ordenacaoRio.get(z).setCaptacao(somaCaptacao);
			System.out.println("CONTADOR: "+z);
			System.out.println("getCAPTACAO"+ordenacaoRio.get(z).getCaptacao());
			System.out.println("-->>Captação acumulada: "+ordenacaoRio.get(z).getCaptacao());
        	/**
        	 * O que me interessa é saber se irá sobrar água portanto soma-se a vazão anterior
        	 * com a atual e subtrai captação do mês corrente
        	 */
			 System.out.println("VAZAO JANEIRO ANTES OPERAÇÃO: "+ordenacaoRio.get(z).getJan());
			 
             BigDecimal calcDispJanIni2 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getJan()))
            .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao()))); 
             ordenacaoRio.get(z).setJan(calcDispJanIni2);
             
             System.out.println("CAPTAÇÃO ACUMULADA: "+ordenacaoRio.get(z).getCaptacao());
             System.out.println("VAZAO JANEIRO DEPOIS OPERAÇÃO: "+ordenacaoRio.get(z).getJan());
             System.out.println("RESULTADO DO CALC VAZAO: "+calcDispJanIni2);
             
             BigDecimal calcDispFevIni2 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getFev()))
             .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));          
             ordenacaoRio.get(z).setFev(calcDispFevIni2);
             
             BigDecimal calcDispMarIni2 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getMar()))
             .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));          
             ordenacaoRio.get(z).setMar(calcDispMarIni2);
             
             BigDecimal calcDispAbrIni2 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getAbr()))
             .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));          
             ordenacaoRio.get(z).setAbr(calcDispAbrIni2);
             
             BigDecimal calcDispMaiIni2 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getMai()))
             .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));          
             ordenacaoRio.get(z).setMai(calcDispMaiIni2);
             
             BigDecimal calcDispJunIni2 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getJun()))
             .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));          
             ordenacaoRio.get(z).setJun(calcDispJunIni2);
             
             BigDecimal calcDispJulIni2 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getJul()))
             .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));          
             ordenacaoRio.get(z).setJul(calcDispJulIni2);
             
             BigDecimal calcDispAgoIni2 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getAgo()))
             .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));          
             ordenacaoRio.get(z).setAgo(calcDispAgoIni2);
             
             BigDecimal calcDispSetIni2 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getSet()))
             .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));          
             ordenacaoRio.get(z).setSet(calcDispSetIni2);
             
             BigDecimal calcDispOutIni2 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getOut()))
             .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));          
             ordenacaoRio.get(z).setOut(calcDispOutIni2);
             
             BigDecimal calcDispNovIni2 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getNov()))
             .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));          
             ordenacaoRio.get(z).setNov(calcDispNovIni2);
             
             BigDecimal calcDispDezIni2 = new BigDecimal(String.valueOf(ordenacaoRio.get(z).getDez()))
             .subtract(new BigDecimal(String.valueOf(ordenacaoRio.get(z).getCaptacao())));          
             ordenacaoRio.get(z).setDez(calcDispDezIni2);           
  }		
		
        }
        System.out.println("TAMANHO DA LISTA VENDA: "+listaVenda.size());
        System.out.println("TAMANHO DA LISTA ORDENACAO: "+ordenacaoRio.size());
        
        //Limpando a lista e colocando novamente dentro de uma lista SET
        listaVenda.clear(); 
        
        for(Venda rio10: ordenacaoRio){       	 
       	 listaVenda.add(rio10);
       	 
        }
        
      
        for(Venda rio10: listaVenda){       	 
          	System.out.println("Captacao: "+rio10.getCaptacao()); 
          	
           }
		  }
			
//}
	
// SALVAR
public void salvar() { 
	
	for(int z = 0; z<ordenacaoRio.size(); z++){ 
		
		 System.out.println("RIO: "+z+" "+ordenacaoRio.get(z).getProcessoMontante());
		 System.out.println(listaVenda.size());
		
	}	
	
	
		
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
	   Messages.addGlobalInfo("Outorga relizada com sucesso!");
	   
   } catch (RuntimeException erro) {

		Messages.addGlobalInfo("Erro relizar outorga!");
		erro.printStackTrace();
	}				

     novo();
		}
	}

