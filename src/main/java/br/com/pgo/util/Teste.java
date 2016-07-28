package br.com.pgo.util;

import java.math.BigDecimal;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		BigDecimal x1 = new BigDecimal(0.33);
		BigDecimal x2 = new BigDecimal(0.66);
		BigDecimal z = new BigDecimal(0.4);
		BigDecimal y1 = new BigDecimal(7.0);
		BigDecimal y2 = new BigDecimal(4.0);
		
		Interpolar.calcular(x1, x2, z, y1, y2);

	}

}
