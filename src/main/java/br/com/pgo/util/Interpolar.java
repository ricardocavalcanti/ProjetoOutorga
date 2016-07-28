package br.com.pgo.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Interpolar {

	//BigDecimal media = new BigDecimal(String.valueOf(posicaoJan)).divide(qtdBigDec, 2, RoundingMode.DOWN);
	//new BigDecimal("1.00").divide(new BigDecimal("1.3"),3,RoundingMode.UP));
	
	
	private Interpolar() {
	}
	
	public static BigDecimal calcular(BigDecimal x1, BigDecimal x2, BigDecimal z, BigDecimal y1, BigDecimal y2) {

		BigDecimal fator1 = new BigDecimal(String.valueOf(z)).subtract(new BigDecimal(String.valueOf(x1)));
		System.out.println("FATOR1: " +new BigDecimal (String.valueOf(z)).subtract(new BigDecimal(String.valueOf(x1))));
		
		BigDecimal fator2 = new BigDecimal(String.valueOf(x2)).subtract(new BigDecimal(String.valueOf(x1)));
		System.out.println("FATOR1: " +new BigDecimal (String.valueOf(x2)).subtract(new BigDecimal(String.valueOf(x1))));
		
		BigDecimal media1 = new BigDecimal(String.valueOf(fator1)).divide(new BigDecimal(String.valueOf(fator2)),2,RoundingMode.DOWN);
		System.out.println("MEDIA1: "+new BigDecimal(String.valueOf(fator1)).divide(new BigDecimal(String.valueOf(fator2)),2,RoundingMode.DOWN));
			
		
		BigDecimal fator3 = new BigDecimal(String.valueOf(y1)).multiply(new BigDecimal("-1"));
		System.out.println("FATOR3: "+new BigDecimal(String.valueOf(y1)));
		
		BigDecimal fator4 = new BigDecimal(String.valueOf(y1)).subtract(new BigDecimal(String.valueOf(y2)));
		System.out.println("FATOR4: "+new BigDecimal(String.valueOf(y1)).subtract(new BigDecimal(String.valueOf(y2))));		
		
		
		BigDecimal interpolacao = new BigDecimal(String.valueOf(media1)).multiply(new BigDecimal(String.valueOf(fator4))).add(new BigDecimal(String.valueOf(fator3)));
        BigDecimal resultado = new BigDecimal(String.valueOf(interpolacao)).multiply(new BigDecimal("-1"));
		
        System.out.println(resultado);
		return resultado;
       
		
		
	}
	
	
}
