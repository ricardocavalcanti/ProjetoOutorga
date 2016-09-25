package br.com.pgo.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import br.com.pgo.domain.Ua;

public class InterpolarUaCalc {

	// O calculo é o mesmo para todos os meses a única coisa que muda é o valor
	// garantia
	public BigDecimal vendaInterpolar(List<Ua> listaItensVenda, BigDecimal areaUa, BigDecimal garantia,
			BigDecimal areaDrenagem) {

		BigDecimal qtdBigDec = new BigDecimal(String.valueOf(listaItensVenda.size()));

		if (!garantia.equals(BigDecimal.ZERO)) {

			// Posição inicial utilizado na divisão = (posiçãoJan/Quantidade)
			int posicao = 1;

			// Adiconar os valores percentuais para fazer a busca dos valores
			// que estão antes de depois do valor informado para ser
			// interpolado.
			List<BigDecimal> percentJan = new ArrayList<BigDecimal>();

			// Para calcular os percentuais (posição/quantidade)
			HashMap<String, BigDecimal> mapJan = new HashMap<>();
			// O calculo é o mesmo para todos os meses a única coisa que muda é
			// o valor garantia
			for (Ua janeiro : listaItensVenda) {

				// Adiconando a media ao List percentJan
				BigDecimal media = new BigDecimal(String.valueOf(posicao)).divide(qtdBigDec, 4, RoundingMode.UP);
				percentJan.add(media);
				// O calculo é o mesmo para todos os meses a única coisa que
				// muda é o valor garantia
				mapJan.merge(String.valueOf(media), new BigDecimal(String.valueOf(janeiro.getJan())), BigDecimal::add);

				System.out.println("TAMANHO DA LISTA: " + qtdBigDec);
				System.out.println("MEDIA : " + media + " POSICAO " + posicao);

				posicao++;

				// Aqui ficaria o HasMap index 'percentJan(i)' e o valor seria
				// janeito.getJan(i)
			}
			System.out.println("--------------------------------------------");

			// Trabalhando com valores HashMap
			System.out.println("HashMap - 0.33 : " + mapJan.get("0.33"));
			System.out.println("HashMap - 0.66 : " + mapJan.get("0.66"));
			System.out.println("HashMap - 1.00 : " + mapJan.get("1.00"));

			System.out.println("--------------------------------------------");
			System.out.println("Percent Jan");

			percentJan.forEach(media -> System.out.println(media));

			System.out.println("--------------------------------------------");

			System.out.println("INTERPOLAÇÃO!");

			// double x1 = 0; Ver quem vai ser o maior e menor valor
			// double x2 = 0; Ver quem vai ser o maior e menor valor

			// double y1 = 0; Pegar a vazao da posição da outra lista
			// double y2 = 0; Pegar a vazao da posição da outra lista

			BigDecimal x2 = BigDecimal.ZERO;
			BigDecimal x1 = BigDecimal.ZERO;
			// garantiaJan = new
			// BigDecimal(String.valueOf(garantiaJan)).divide(new
			// BigDecimal("100"),2,RoundingMode.DOWN); // Valor informado pelo
			// usuário
			System.out.println(garantia);
			// Pegar as keys do HashMap da lista de Janeiro
			Set<String> chaves = mapJan.keySet();

			// Achar maior valor x2
			for (BigDecimal valor : percentJan) {

				if (valor.compareTo(garantia) == 1) {

					x2 = valor;

					break;
				}
			}

			// Achar menor valor y2
			BigDecimal y2 = BigDecimal.ZERO;
			for (String c : chaves) {
				if (mapJan.get(c) == mapJan.get(String.valueOf(x2))) {

					y2 = mapJan.get(c);
					System.out.println("TESTE_y2: " + y2);

				}

			}

			// Achar menor valor x1
			for (int i = percentJan.size() - 1; i > -1; i--) {

				BigDecimal valor = percentJan.get(i);

				if (valor.compareTo(garantia) == -1) {

					x1 = valor;
					break;
				}
			}

			// Achar maior valor y1
			BigDecimal y1 = BigDecimal.ZERO;
			for (String c : chaves) {
				if (mapJan.get(c) == mapJan.get(String.valueOf(x1))) {

					y1 = mapJan.get(c);
					System.out.println("TESTE_y1: " + y1);

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

			System.out.println(" 0 INTERPOLACAO: " + InterpolarJan.calcular(x1, x2, garantia, y1, y2));
			System.out.println("--------------------------------------------");

			System.out.println("1 AREA UA: " + areaUa);

			BigDecimal calc1 = InterpolarJan.calcular(x1, x2, garantia, y1, y2);

			BigDecimal calc2 = new BigDecimal(String.valueOf(calc1)).divide(new BigDecimal(String.valueOf(areaUa)), 4,
					RoundingMode.UP);
			System.out.println("3 AREA UA : " + areaUa);

			garantia = new BigDecimal(String.valueOf(calc2)).multiply(new BigDecimal(String.valueOf(areaDrenagem)));
			System.out.println("4 AREA UA: " + areaUa);

			System.out.println("GARANTIA FINAL" + garantia);

		} else {

			garantia = BigDecimal.ZERO;
		}

		BigDecimal resultado = new BigDecimal(String.valueOf(garantia));

		return resultado;

	}

}