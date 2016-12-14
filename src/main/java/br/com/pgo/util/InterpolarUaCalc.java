package br.com.pgo.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class InterpolarUaCalc {

	// O calculo é o mesmo para todos os meses a única coisa que muda é o valor
	// garantia, recebe por paramento um list do mes especifico Ex:.
	// List<BigDecimal> listaItensVenda = ua.getJan()
	
	public BigDecimal vendaInterpolar(List<BigDecimal> mesInterpolar, BigDecimal areaUa, BigDecimal garantia,	BigDecimal areaDrenagem) {

		BigDecimal qtdBigDec = new BigDecimal(String.valueOf(mesInterpolar.size()));

		if (!garantia.equals(BigDecimal.ZERO)) {
           
			//Ordenando a lista em ordem decrescente
			Collections.sort(mesInterpolar, new Comparator<BigDecimal>() {
				public int compare(BigDecimal ua1, BigDecimal ua2) {

					if (ua2.compareTo(ua1) == 1) {
						return 1;
					} else if (ua1.compareTo(ua2) == 1) {
						return -1;
					} else {
						return 0;
					}
				}

			});

			// Posição inicial utilizado na divisão = (posiçãoJan/Quantidade)
			int posicao = 1;

			// Adiconar os valores percentuais para fazer a busca dos valores
			// que estão antes de depois do valor informado para ser
			// interpolado.
			List<BigDecimal> percent = new ArrayList<BigDecimal>();

			// Para calcular os percentuais (posição/quantidade)
			HashMap<String, BigDecimal> mapChave = new HashMap<>();
			for (int i = 0; i < mesInterpolar.size(); i++) {

				BigDecimal ua = mesInterpolar.get(i);

				// Adiconando a media ao List percentJan
				BigDecimal media = new BigDecimal(String.valueOf(posicao)).divide(qtdBigDec, 4, RoundingMode.UP);
				percent.add(media);
				// O calculo é o mesmo para todos os meses a única coisa que
				// muda é o valor garantia
				mapChave.merge(String.valueOf(media), new BigDecimal(String.valueOf(ua)), BigDecimal::add);
				System.out.println("--------------------------------------------");
				System.out.println("DADOS DA LISTA ");
				System.out.println("TAMANHO DA LISTA: " + qtdBigDec);
				System.out.println("MEDIA : " + media + " POSICAO " + posicao);

				posicao++;
			}

			BigDecimal x2 = BigDecimal.ZERO;
			BigDecimal x1 = BigDecimal.ZERO;

			Set<String> chaves = mapChave.keySet();

			// Achar maior valor x2
			for (BigDecimal valor : percent) {

				if (valor.compareTo(garantia) == 1) {

					x2 = valor;

					break;
				}
			}

			// Achar menor valor y2
			BigDecimal y2 = BigDecimal.ZERO;
			for (String c : chaves) {
				if (mapChave.get(c) == mapChave.get(String.valueOf(x2))) {

					y2 = mapChave.get(c);
					

				}

			}

			// Achar menor valor x1
			for (int i = percent.size() - 1; i > -1; i--) {

				BigDecimal valor = percent.get(i);

				if (valor.compareTo(garantia) == -1) {

					x1 = valor;
					break;
				}
			}

			// Achar maior valor y1
			BigDecimal y1 = BigDecimal.ZERO;
			for (String c : chaves) {
				if (mapChave.get(c) == mapChave.get(String.valueOf(x1))) {

					y1 = mapChave.get(c);					

				}

			}

			System.out.println("--------------------------------------------");
			System.out.println("PONTOS DE REFERENCIA PARA INTERPOLAR");
			System.out.println("X1: " + x1);
			System.out.println("X2: " + x2);
			System.out.println("Z: " + garantia);
			System.out.println("Y1: " + y1);
			System.out.println("Y2: " + y2);
			System.out.println("--------------------------------------------");

			// Invocando o metodo InterpolarCalc do pacote br.com.pgo.Util

			InterpolarCalc InterpolarJan = new InterpolarCalc();
			System.out.println("--------------------------------------------");	
			
			System.out.println(" RELATÓRIO DOS VALORES PARA O CALCULO FINAL! ");			

			BigDecimal calc1 = InterpolarJan.calcular(x1, x2, garantia, y1, y2);
            System.out.println("0 Calculo garantia final = (Resultado interpolação/areaUA) x areaDrenagem ");
            System.out.println("0 INTERPOLAÇÃO= "+calc1+"* AREA UA= "+areaUa+"* AREA DRENAGEM= "+areaDrenagem);
			BigDecimal calc2 = new BigDecimal(String.valueOf(calc1)).divide(new BigDecimal(String.valueOf(areaUa)), 4,RoundingMode.UP);
			
			garantia = new BigDecimal(String.valueOf(calc2)).multiply(new BigDecimal(String.valueOf(areaDrenagem)));		
			System.out.println("(RESULTADO FINAL) GARANTIA FINAL" + garantia);

		} else {

			garantia = BigDecimal.ZERO;
		}

		BigDecimal resultado = new BigDecimal(String.valueOf(garantia));

		return resultado;

	}

}