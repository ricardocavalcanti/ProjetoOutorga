package br.com.pgo.util;

public class Interpolar {

	public static double calcular(double x1, double x2, double z, double y1, double y2) {

		double fator1 = z - x1;
		System.out.println("FATOR1: " + fator1);
		double fator2 = x2 - x1;
		System.out.println("FATOR2: " + fator2);
		double media1 = fator1 / fator2;
		System.out.println("MEDIA1 :" + media1);

		double fator3 = y1 * -1;
		System.out.println("FATOR3: " + fator3);
		double fator4 = y2 - y1;
		System.out.println("FATOR4: " + fator4);
		double media2 = fator3 / fator4;
		System.out.println("MEDIA2 :" + media2);

		double interpolacao = (media1 * fator4) - fator3;

		return interpolacao;

	}

}
