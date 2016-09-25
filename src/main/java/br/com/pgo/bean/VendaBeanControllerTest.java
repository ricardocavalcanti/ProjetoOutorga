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
	
@PostConstruct	
public void novo() {

		venda = new Venda();
		listaVenda = new HashSet<Venda>();		

	}	
	
public void adicionar() {
		
        //Pesquisa Ua pelo número informado pelo usuário em venda.xhtml e adiciona
	   // na "listaUas" para ser usada no metódo para calcular interpolação das Uas
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


       

	@SuppressWarnings("unchecked")
	public void interpolarMeses() {
		              adicionar();
		
		List<BigDecimal> ListaJan = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas){
			
			ListaJan = (List<BigDecimal>) ua.getJan();
			
		}        
		//Receber List de Janeiro que foi setada dentro do listUas
		InterpolarUaCalc interpolarJan = new InterpolarUaCalc();	
		venda.setJan(interpolarJan.vendaInterpolar(ListaJan, areaUa, garantiaJan, areaDrenagem));
		
		
		List<BigDecimal> ListaFev = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas){
			
			ListaFev = (List<BigDecimal>)ua.getFev();
			
		}		
		//Receber List de Fevereiro que foi setada dentro do listUas
		InterpolarUaCalc interpolarFev = new InterpolarUaCalc();	
		venda.setFev(interpolarFev.vendaInterpolar(ListaFev, areaUa, garantiaFev, areaDrenagem));
		
		List<BigDecimal> ListaMar = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas){
			
			ListaMar = (List<BigDecimal>)ua.getMar();
			
		}
		
		//Receber List de Março que foi setada dentro do listUas
		InterpolarUaCalc interpolarMar = new InterpolarUaCalc();
		venda.setMar(interpolarMar.vendaInterpolar(ListaMar, areaUa, garantiaMar, areaDrenagem));
		
		
		List<BigDecimal> ListaAbr = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas){
			
			ListaAbr = (List<BigDecimal>)ua.getAbr();
			
		}		
		//Receber List de Abril que foi setada dentro do listUas
		InterpolarUaCalc interpolarAbr = new InterpolarUaCalc();		
		venda.setAbr(interpolarAbr.vendaInterpolar(ListaAbr, areaUa, garantiaAbr, areaDrenagem));
		
		
		List<BigDecimal> ListaMai = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas){
			
			ListaMai = (List<BigDecimal>)ua.getMai();
			
		}		
		//Receber List de Maio que foi setada dentro do listUas
		InterpolarUaCalc interpolarMai = new InterpolarUaCalc();	
		venda.setMai(interpolarMai.vendaInterpolar(ListaMai, areaUa, garantiaMai, areaDrenagem));
		
		
		List<BigDecimal> ListaJun = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas){
			
			ListaJun = (List<BigDecimal>)ua.getJun();
			
		}
		//Receber List de Junho que foi setada dentro do listUas
		InterpolarUaCalc interpolarJun = new InterpolarUaCalc();	
		venda.setJun(interpolarJun.vendaInterpolar(ListaJun, areaUa, garantiaJun, areaDrenagem));
		
		
		List<BigDecimal> ListaJul = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas){
			
			ListaJul = (List<BigDecimal>)ua.getJul();
			
		}
		//Receber List de Julho que foi setada dentro do listUas
		InterpolarUaCalc interpolarJul = new InterpolarUaCalc();		
		venda.setJul(interpolarJul.vendaInterpolar(ListaJul, areaUa, garantiaJul, areaDrenagem));
		
		
		List<BigDecimal> ListaAgo = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas){
			
			ListaAgo = (List<BigDecimal>)ua.getAgo();
			
		}
		//Receber List de Agosto que foi setada dentro do listUas
		InterpolarUaCalc interpolarAgo = new InterpolarUaCalc();		
		venda.setAgo(interpolarAgo.vendaInterpolar(ListaAgo, areaUa, garantiaAgo, areaDrenagem));
		
		
		List<BigDecimal> ListaSet = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas){
			
			ListaSet = (List<BigDecimal>)ua.getSet();
			
		}
		//Receber List de Setembro que foi setada dentro do listUas
		InterpolarUaCalc interpolarSet = new InterpolarUaCalc();		
		venda.setSet(interpolarSet.vendaInterpolar(ListaSet, areaUa, garantiaSet, areaDrenagem));
		
		
		List<BigDecimal> ListaOut = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas){
			
			ListaOut = (List<BigDecimal>)ua.getOut();
			
		}
		//Receber List de Outubro que foi setada dentro do listUas
		InterpolarUaCalc interpolarOut = new InterpolarUaCalc();		
		venda.setOut(interpolarOut.vendaInterpolar(ListaOut, areaUa, garantiaOut, areaDrenagem));
		
		
		List<BigDecimal> ListaNov = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas){
			
			ListaNov = (List<BigDecimal>)ua.getNov();
			
		}
		//Receber List de Novembro que foi setada dentro do listUas
		InterpolarUaCalc interpolarNov = new InterpolarUaCalc();	
		venda.setNov(interpolarNov.vendaInterpolar(ListaNov, areaUa, garantiaNov, areaDrenagem));
		
		
		List<BigDecimal> ListaDez = new ArrayList<BigDecimal>();
		for (Ua ua : listaUas){
			
			ListaDez = (List<BigDecimal>)ua.getDez();
			
		}
		//Receber List de Dezembro que foi setada dentro do listUas
		InterpolarUaCalc interpolarDez = new InterpolarUaCalc();		
		venda.setDez(interpolarDez.vendaInterpolar(ListaDez, areaUa, garantiaDez, areaDrenagem));
		
		//Amarrar controler a tela e testa interpolação!

	}

	
	public void encaixar() {
		System.out.println("Metodo Encaixar!");       
		try {			
				
		VendaDAO vendaDAO = new VendaDAO();
		listaVenda = vendaDAO.listarVenda();
		listaVenda.add(venda);
				
		System.out.println("Tamanho lista ENCAIXAR: "+listaVenda.size());
				
		} catch (RuntimeException erro){
					
		Messages.addGlobalInfo("Erro ao tentar criar 'Lista de Venda' ");
		erro.printStackTrace();
					
		} 			
		Iterator<Venda>posicao=listaVenda.iterator();

		while(posicao.hasNext()){
				
		Venda atual = posicao.next();
		boolean condicao1 = false;
		boolean condicao2 = false;

		if(atual.getOutorgante().getProcessoApac()==processoJusante){
		atual.setProcessoMotante(processoJusante);
		condicao1 = true;
		}
		if(atual.getOutorgante().getProcessoApac()==processoMontante){
		atual.setProcessoJusante(processoMontante);
		condicao2 = true;
		}
		if(condicao1==true && condicao2==true) {
			break;
		   }
		}
		            
		}
}
