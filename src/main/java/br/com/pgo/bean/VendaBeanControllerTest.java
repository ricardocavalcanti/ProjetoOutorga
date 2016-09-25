package br.com.pgo.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.pgo.domain.Ua;
import br.com.pgo.domain.Venda;
import br.com.pgo.util.InterpolarUaCalc;
import br.com.pgo.util.OrdenarDescAbr;
import br.com.pgo.util.OrdenarDescAgo;
import br.com.pgo.util.OrdenarDescDez;
import br.com.pgo.util.OrdenarDescFev;
import br.com.pgo.util.OrdenarDescJan;
import br.com.pgo.util.OrdenarDescJul;
import br.com.pgo.util.OrdenarDescJun;
import br.com.pgo.util.OrdenarDescMai;
import br.com.pgo.util.OrdenarDescMar;
import br.com.pgo.util.OrdenarDescNov;
import br.com.pgo.util.OrdenarDescOut;
import br.com.pgo.util.OrdenarDescSet;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaBeanControllerTest implements Serializable {

	private List<Ua> listaItensVenda;
	private BigDecimal areaUa;
	private BigDecimal garantiaJan, garantiaFev, garantiaMar, garantiaAbr, garantiaMai, garantiaJun, garantiaJul,
			garantiaAgo, garantiaSet, garantiaOut, garantiaNov, garantiaDez;
	private BigDecimal areaDrenagem;
	private Venda venda;

	public void interpolarMeses() {

		InterpolarUaCalc interpolarJan = new InterpolarUaCalc();
		Collections.sort(listaItensVenda, new OrdenarDescJan());
		venda.setJan(interpolarJan.vendaInterpolar(listaItensVenda, areaUa, garantiaJan, areaDrenagem));

		InterpolarUaCalc interpolarFev = new InterpolarUaCalc();
		Collections.sort(listaItensVenda, new OrdenarDescFev());
		venda.setFev(interpolarFev.vendaInterpolar(listaItensVenda, areaUa, garantiaFev, areaDrenagem));

		InterpolarUaCalc interpolarMar = new InterpolarUaCalc();
		Collections.sort(listaItensVenda, new OrdenarDescMar());
		venda.setMar(interpolarMar.vendaInterpolar(listaItensVenda, areaUa, garantiaMar, areaDrenagem));

		InterpolarUaCalc interpolarAbr = new InterpolarUaCalc();
		Collections.sort(listaItensVenda, new OrdenarDescAbr());
		venda.setAbr(interpolarAbr.vendaInterpolar(listaItensVenda, areaUa, garantiaAbr, areaDrenagem));

		InterpolarUaCalc interpolarMai = new InterpolarUaCalc();
		Collections.sort(listaItensVenda, new OrdenarDescMai());
		venda.setMai(interpolarMai.vendaInterpolar(listaItensVenda, areaUa, garantiaMai, areaDrenagem));

		InterpolarUaCalc interpolarJun = new InterpolarUaCalc();
		Collections.sort(listaItensVenda, new OrdenarDescJun());
		venda.setJun(interpolarJun.vendaInterpolar(listaItensVenda, areaUa, garantiaJun, areaDrenagem));

		InterpolarUaCalc interpolarJul = new InterpolarUaCalc();
		Collections.sort(listaItensVenda, new OrdenarDescJul());
		venda.setJul(interpolarJul.vendaInterpolar(listaItensVenda, areaUa, garantiaJul, areaDrenagem));

		InterpolarUaCalc interpolarAgo = new InterpolarUaCalc();
		Collections.sort(listaItensVenda, new OrdenarDescAgo());
		venda.setAgo(interpolarAgo.vendaInterpolar(listaItensVenda, areaUa, garantiaAgo, areaDrenagem));

		InterpolarUaCalc interpolarSet = new InterpolarUaCalc();
		Collections.sort(listaItensVenda, new OrdenarDescSet());
		venda.setSet(interpolarSet.vendaInterpolar(listaItensVenda, areaUa, garantiaSet, areaDrenagem));

		InterpolarUaCalc interpolarOut = new InterpolarUaCalc();
		Collections.sort(listaItensVenda, new OrdenarDescOut());
		venda.setOut(interpolarOut.vendaInterpolar(listaItensVenda, areaUa, garantiaOut, areaDrenagem));

		InterpolarUaCalc interpolarNov = new InterpolarUaCalc();
		Collections.sort(listaItensVenda, new OrdenarDescNov());
		venda.setNov(interpolarNov.vendaInterpolar(listaItensVenda, areaUa, garantiaNov, areaDrenagem));

		InterpolarUaCalc interpolarDez = new InterpolarUaCalc();
		Collections.sort(listaItensVenda, new OrdenarDescDez());
		venda.setDez(interpolarDez.vendaInterpolar(listaItensVenda, areaUa, garantiaDez, areaDrenagem));
		
		//Amarrar controler a tela e testa interpolação!

	}

}
