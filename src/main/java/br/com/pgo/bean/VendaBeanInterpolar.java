package br.com.pgo.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import br.com.pgo.domain.Ua;
import br.com.pgo.util.Interpolar;

public class VendaBeanInterpolar {

	public static void vendaInterpolar(int num, List<Ua> listaItensVenda) {

		BigDecimal qtdBigDec = new BigDecimal(String.valueOf(listaItensVenda.size()));

		if (!VendaBeanController.garantiaJan.equals(BigDecimal.ZERO)) {

			// Para fazer a ordenação Janeiro em ordem descrescente.
			Collections.sort(listaItensVenda, new Comparator<Ua>() {
				@Override
				public int compare(Ua ua1, Ua ua2) {

					if (ua2.getJan().compareTo(ua1.getJan()) == 1) {
						return 1;
					} else if (ua1.getJan().compareTo(ua2.getJan()) == 1) {
						return -1;
					} else {
						return 0;
					}
				}
			});

			System.out.println("##########INICIO JANEIRO##############");
			System.out.println(VendaBeanController.garantiaJan);
			// Posição inicial de Janeiro para ser utilizado na divisão =
			// (posiçãoJan/Quantidade)
			int posicaoJan = 1;
			// Adiconar os valores percentuais para fazer a busca dos valores
			// que
			// estão antes de depois do valor informado para ser interpolado.
			List<BigDecimal> percentJan = new ArrayList<BigDecimal>();
			HashMap<String, BigDecimal> mapJan = new HashMap<>();
			// Para calcular os percentuais (posição/quantidade)
			for (Ua janeiro : listaItensVenda) {

				System.out.println(
						"NumeroUA: " + janeiro.getNumeroUa() + " - Mes: Janeiro " + " - Vazao: " + janeiro.getJan());

				// Adiconando a medeia ao List percentJan
				BigDecimal media = new BigDecimal(String.valueOf(posicaoJan)).divide(qtdBigDec, 4, RoundingMode.UP);
				percentJan.add(media);

				mapJan.merge(String.valueOf(media), new BigDecimal(String.valueOf(janeiro.getJan())), BigDecimal::add);

				System.out.println("TAMANHO DA LISTA: " + qtdBigDec);
				System.out.println("MEDIA : " + media + " POSICAO " + posicaoJan);

				posicaoJan++;

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
			System.out.println(VendaBeanController.garantiaJan);
			// Pegar as keys do HashMap da lista de Janeiro
			Set<String> chaves = mapJan.keySet();

			// Achar maior valor x2
			for (BigDecimal valor : percentJan) {

				if (valor.compareTo(VendaBeanController.garantiaJan) == 1) {

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

				if (valor.compareTo(VendaBeanController.garantiaJan) == -1) {

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
			System.out.println("Z: " + VendaBeanController.garantiaJan);
			System.out.println("Y1: " + y1);
			System.out.println("Y2: " + y2);
			System.out.println("--------------------------------------------");

			Interpolar InterpolarJan = new Interpolar();

			System.out.println("INTERPOLACAO JAN: " + InterpolarJan.calcular(x1, x2, VendaBeanController.garantiaJan, y1, y2));
			System.out.println("--------------------------------------------");

			System.out.println("1 AREA UA JANEIRO: " + areaUa);

			BigDecimal calc1 = InterpolarJan.calcular(x1, x2, VendaBeanController.garantiaJan, y1, y2);
			System.out.println("2 AREA UA JANEIRO: " + areaUa);

			BigDecimal calc2 = new BigDecimal(String.valueOf(calc1)).divide(new BigDecimal(String.valueOf(areaUa)), 4,
					RoundingMode.UP);
			System.out.println("3 AREA UA JANEIRO: " + areaUa);

			garantiaJan = new BigDecimal(String.valueOf(calc2)).multiply(new BigDecimal(String.valueOf(areaDrenagem)));
			System.out.println("4 AREA UA JANEIRO: " + areaUa);

			System.out.println("GARANTIA JAN FINAL" + VendaBeanController.garantiaJan);
			// Ua ua = new Ua();

			// Interpolar.calcular(x1, x2, z, y1, y2) ;

			// -------------------------------------FIM //
			// JANEIRO---------------------------------------------------------------------------------------------------------//
		} else {

			garantiaJan = BigDecimal.ZERO;
		}

		rgarantiaJan = VendaBeanController.garantiaJan;

		// ua.setJan(garantiaJan);

		// listaGarantiaVazao.add(garantiaVazao);
		System.out.println(ua.getJan());

		System.out.println("GARANTIA JAN FINAL" + garantiaJan);

		// rgarantiaFev=garantiaFev;
		if (!garantiaFev.equals(BigDecimal.ZERO)) {

			// Ordenação Fevereiro
			Collections.sort(listaItensVenda, new Comparator<Ua>() {
				@Override
				public int compare(Ua ua1, Ua ua2) {

					if (ua2.getFev().compareTo(ua1.getFev()) == 1) {
						return 1;
					} else if (ua1.getFev().compareTo(ua2.getFev()) == 1) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			System.out.println("##########INICIO FEVEREIRO##############");
			int posicaoFev = 1;
			List<BigDecimal> percentFev = new ArrayList<BigDecimal>();
			HashMap<String, BigDecimal> mapFev = new HashMap<>();

			for (Ua fevereiro : listaItensVenda) {

				System.out.println(
						"NumeroUA: " + fevereiro.getNumeroUa() + " Mes: Fevereiro " + " Vazao: " + fevereiro.getFev());

				BigDecimal media = new BigDecimal(String.valueOf(posicaoFev)).divide(qtdBigDec, 4, RoundingMode.UP);
				percentFev.add(media);
				mapFev.merge(String.valueOf(media), new BigDecimal(String.valueOf(fevereiro.getFev())),
						BigDecimal::add);

				System.out.println("TAMANHO DA LISTA: " + qtdBigDec);
				System.out.println("MEDIA : " + media + " POSICAO " + posicaoFev);
				System.out.println("--------------------------------------------");
				posicaoFev++;
			}

			System.out.println("--------------------------------------------");

			// Trabalhando com valores HashMap
			System.out.println("HashMap - 0.33 : " + mapFev.get("0.33"));
			System.out.println("HashMap - 0.66 : " + mapFev.get("0.66"));
			System.out.println("HashMap - 1.00 : " + mapFev.get("1.00"));

			System.out.println("--------------------------------------------");
			System.out.println("Percent Fev");

			percentFev.forEach(media -> System.out.println(media));
			System.out.println("--------------------------------------------");
			System.out.println("INTERPOLAÇÃO!");

			// garantiaFev = new
			// BigDecimal(String.valueOf(garantiaFev)).divide(new
			// BigDecimal("100"),2,RoundingMode.DOWN); // Valor informado pelo
			// usuário
			Set<String> chavesFev = mapFev.keySet();

			// Achar maior valor fevX2
			BigDecimal fevX2 = BigDecimal.ZERO;
			for (BigDecimal valor : percentFev) {

				if (valor.compareTo(garantiaFev) == 1) {

					fevX2 = valor;
					break;
				}
			}
			// Achar menor valor fevY2
			BigDecimal fevY2 = BigDecimal.ZERO;
			for (String c : chavesFev) {
				if (mapFev.get(c) == mapFev.get(String.valueOf(fevX2))) {
					fevY2 = mapFev.get(c);
					System.out.println("OOOOOFEV Y2: " + fevY2);

				}

			}

			// Achar menor valor fevX1
			BigDecimal fevX1 = BigDecimal.ZERO;
			for (int i = percentFev.size() - 1; i > -1; i--) {
				BigDecimal valor = percentFev.get(i);
				if (valor.compareTo(garantiaFev) == -1) {
					fevX1 = valor;
					break;
				}
			}
			// Achar maior valor fevY1
			BigDecimal fevY1 = BigDecimal.ZERO;
			for (String c : chavesFev) {
				if (mapFev.get(c) == mapFev.get(String.valueOf(fevX1))) {
					fevY1 = mapFev.get(c);
					System.out.println("OOOOOFevY1: " + fevY1);
				}
			}
			System.out.println("--------------------------------------------");
			System.out.println("PONTOS DE REFERENCIA PARA INTERPOLAR");
			System.out.println("FevX1: " + fevX1);
			System.out.println("FevX2: " + fevX2);
			System.out.println("FevZ: " + garantiaFev);
			System.out.println("FevY1: " + fevY1);
			System.out.println("FevY2: " + fevY2);
			System.out.println("--------------------------------------------");

			Interpolar interpolarFev = new Interpolar();
			System.out.println("INTERPOLACAO FEV: " + interpolarFev.calcular(fevX1, fevX2, garantiaFev, fevY1, fevY2));
			System.out.println("--------------------------------------------");

			BigDecimal calc1 = interpolarFev.calcular(fevX1, fevX2, garantiaFev, fevY1, fevY2);

			BigDecimal calc2 = new BigDecimal(String.valueOf(calc1)).divide(new BigDecimal(String.valueOf(areaUa)), 4,
					RoundingMode.UP);

			garantiaFev = new BigDecimal(String.valueOf(calc2)).multiply(new BigDecimal(String.valueOf(areaDrenagem)));

			// garantiaFev = interpolarFev.calcular(fevX1, fevX2, garantiaFev,
			// fevY1, fevY2);

		} else {

			garantiaFev = BigDecimal.ZERO;

		}

		rgarantiaFev = garantiaFev;

		// ua.setFev(garantiaFev);

		System.out.println("GARANTIA FEVEREIRO FINAL" + garantiaFev);
		// FIM FEVEREIRO
		System.out.println("##########INICIO MARÇO##############");
		// rgarantiaMar=garantiaMar;
		if (!garantiaMar.equals(BigDecimal.ZERO)) {
			// Ordenação Março
			Collections.sort(listaItensVenda, new Comparator<Ua>() {
				@Override
				public int compare(Ua ua1, Ua ua2) {

					if (ua2.getMar().compareTo(ua1.getMar()) == 1) {
						return 1;
					} else if (ua1.getMar().compareTo(ua2.getMar()) == 1) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			int posicaoMar = 1;
			List<BigDecimal> percentMar = new ArrayList<BigDecimal>();
			HashMap<String, BigDecimal> mapMar = new HashMap<>();

			for (Ua marco : listaItensVenda) {

				System.out.println("NumeroUA: " + marco.getNumeroUa() + " Mes: Março " + " Vazao: " + marco.getMar());
				BigDecimal media = new BigDecimal(String.valueOf(posicaoMar)).divide(qtdBigDec, 4, RoundingMode.UP);
				percentMar.add(media);
				mapMar.merge(String.valueOf(media), new BigDecimal(String.valueOf(marco.getMar())), BigDecimal::add);

				System.out.println("TAMANHO DA LISTA: " + qtdBigDec);
				System.out.println("MEDIA : " + media + " POSICAO " + posicaoMar);
				System.out.println("--------------------------------------------");
				posicaoMar++;

			}
			System.out.println("--------------------------------------------");
			// Trabalhando com valores HashMap
			System.out.println("HashMap - 0.33 : " + mapMar.get("0.33"));
			System.out.println("HashMap - 0.66 : " + mapMar.get("0.66"));
			System.out.println("HashMap - 1.00 : " + mapMar.get("1.00"));

			System.out.println("--------------------------------------------");
			System.out.println("Percent Mar");
			percentMar.forEach(media -> System.out.println(media));
			System.out.println("--------------------------------------------");
			System.out.println("INTERPOLAÇÃO!");

			// garantiaMar = new
			// BigDecimal(String.valueOf(garantiaMar)).divide(new
			// BigDecimal("100"),2,RoundingMode.DOWN); // Valor informado pelo
			// usuário
			Set<String> chavesMar = mapMar.keySet();

			// Achar maior valor marX2
			BigDecimal marX2 = BigDecimal.ZERO;
			for (BigDecimal valor : percentMar) {

				if (valor.compareTo(garantiaMar) == 1) {

					marX2 = valor;
					break;
				}
			}
			// Achar menor valor marY2
			BigDecimal marY2 = BigDecimal.ZERO;
			for (String c : chavesMar) {
				if (mapMar.get(c) == mapMar.get(String.valueOf(marX2))) {
					marY2 = mapMar.get(c);
					System.out.println("OOOOOMAR Y2: " + marY2);

				}
			}
			// Achar menor valor marX1
			BigDecimal marX1 = BigDecimal.ZERO;
			for (int i = percentMar.size() - 1; i > -1; i--) {
				BigDecimal valor = percentMar.get(i);
				if (valor.compareTo(garantiaMar) == -1) {
					marX1 = valor;
					break;
				}
			}

			// Achar maior valor marY1
			BigDecimal marY1 = BigDecimal.ZERO;
			for (String c : chavesMar) {
				if (mapMar.get(c) == mapMar.get(String.valueOf(marX1))) {
					marY1 = mapMar.get(c);
					System.out.println("OOOOOMAR Y1: " + marY1);
				}
			}

			System.out.println("--------------------------------------------");
			System.out.println("MARÇO PONTOS DE REFERENCIA PARA INTERPOLAR");
			System.out.println("MarX1: " + marX1);
			System.out.println("MarX2: " + marX2);
			System.out.println("MarZ: " + garantiaMar);
			System.out.println("MarY1: " + marY1);
			System.out.println("MarY2: " + marY2);
			System.out.println("--------------------------------------------");

			Interpolar interpolarMar = new Interpolar();
			System.out.println("INTERPOLACAO MAR: " + interpolarMar.calcular(marX1, marX2, garantiaMar, marY1, marY2));
			System.out.println("--------------------------------------------");
			// FIM DE MARÇO

			BigDecimal calc1 = interpolarMar.calcular(marX1, marX2, garantiaMar, marY1, marY2);

			BigDecimal calc2 = new BigDecimal(String.valueOf(calc1)).divide(new BigDecimal(String.valueOf(areaUa)), 4,
					RoundingMode.UP);

			garantiaMar = new BigDecimal(String.valueOf(calc2)).multiply(new BigDecimal(String.valueOf(areaDrenagem)));

			// garantiaMar = interpolarMar.calcular(marX1, marX2, garantiaMar,
			// marY1, marY2);

		} else {

			garantiaMar = BigDecimal.ZERO;

		}

		rgarantiaMar = garantiaMar;

		// ua.setMar(garantiaMar);
		// rgarantiaAbr=garantiaAbr;
		if (!garantiaAbr.equals(BigDecimal.ZERO)) {

			System.out.println("##########INICIO ABRIL##############");
			// Ordenação Abril
			Collections.sort(listaItensVenda, new Comparator<Ua>() {
				@Override
				public int compare(Ua ua1, Ua ua2) {

					if (ua2.getAbr().compareTo(ua1.getAbr()) == 1) {
						return 1;
					} else if (ua1.getAbr().compareTo(ua2.getAbr()) == 1) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			double posicaoAbr = 1;
			List<BigDecimal> percentAbr = new ArrayList<BigDecimal>();
			HashMap<String, BigDecimal> mapAbr = new HashMap<>();

			for (Ua abril : listaItensVenda) {

				System.out.println("NumeroUA: " + abril.getNumeroUa() + " Mes: Abril " + " Vazao: " + abril.getAbr());

				BigDecimal media = new BigDecimal(String.valueOf(posicaoAbr)).divide(qtdBigDec, 4, RoundingMode.UP);
				percentAbr.add(media);
				mapAbr.merge(String.valueOf(media), new BigDecimal(String.valueOf(abril.getAbr())), BigDecimal::add);

				System.out.println("TAMANHO DA LISTA: " + qtdBigDec);
				System.out.println("MEDIA : " + media + " POSICAO " + posicaoAbr);
				System.out.println("--------------------------------------------");
				posicaoAbr++;
			}
			System.out.println("--------------------------------------------");

			// Trabalhando com valores HashMap
			System.out.println("HashMap - 0.33 : " + mapAbr.get("0.33"));
			System.out.println("HashMap - 0.66 : " + mapAbr.get("0.66"));
			System.out.println("HashMap - 1.00 : " + mapAbr.get("1.00"));

			System.out.println("--------------------------------------------");
			System.out.println("Percent Abr");

			percentAbr.forEach(media -> System.out.println(media));
			System.out.println("--------------------------------------------");
			System.out.println("INTERPOLAÇÃO!");

			// garantiaAbr = new
			// BigDecimal(String.valueOf(garantiaAbr)).divide(new
			// BigDecimal("100"),2,RoundingMode.DOWN); // Valor informado pelo
			// usuário
			Set<String> chavesAbr = mapAbr.keySet();

			// Achar maior valor abrX2
			BigDecimal abrX2 = BigDecimal.ZERO;
			for (BigDecimal valor : percentAbr) {

				if (valor.compareTo(garantiaAbr) == 1) {

					abrX2 = valor;
					break;
				}
			}
			// Achar menor valor abrY2
			BigDecimal abrY2 = BigDecimal.ZERO;
			for (String c : chavesAbr) {
				if (mapAbr.get(c) == mapAbr.get(String.valueOf(abrX2))) {
					abrY2 = mapAbr.get(c);
					System.out.println("OOOOOABR Y2: " + abrY2);

				}

			}
			// Achar menor valor fevX1
			BigDecimal abrX1 = BigDecimal.ZERO;
			for (int i = percentAbr.size() - 1; i > -1; i--) {
				BigDecimal valor = percentAbr.get(i);
				if (valor.compareTo(garantiaAbr) == -1) {
					abrX1 = valor;
					break;
				}
			}
			// Achar maior valor fevY1
			BigDecimal abrY1 = BigDecimal.ZERO;
			for (String c : chavesAbr) {
				if (mapAbr.get(c) == mapAbr.get(String.valueOf(abrX1))) {
					abrY1 = mapAbr.get(c);
					System.out.println("OOOOOABRY1: " + abrY1);
				}
			}
			System.out.println("--------------------------------------------");
			System.out.println(" ABRIL PONTOS DE REFERENCIA PARA INTERPOLAR");
			System.out.println("AbrX1: " + abrX1);
			System.out.println("AbrX2: " + abrX2);
			System.out.println("AbrZ: " + garantiaAbr);
			System.out.println("AbrY1: " + abrY1);
			System.out.println("AbrY2: " + abrY2);
			System.out.println("--------------------------------------------");

			Interpolar interpolarAbr = new Interpolar();
			System.out
					.println("INTERPOLACAO ABRIL: " + interpolarAbr.calcular(abrX1, abrX2, garantiaAbr, abrY1, abrY2));
			System.out.println("--------------------------------------------");

			BigDecimal calc1 = interpolarAbr.calcular(abrX1, abrX2, garantiaAbr, abrY1, abrY2);

			BigDecimal calc2 = new BigDecimal(String.valueOf(calc1)).divide(new BigDecimal(String.valueOf(areaUa)), 4,
					RoundingMode.UP);

			garantiaAbr = new BigDecimal(String.valueOf(calc2)).multiply(new BigDecimal(String.valueOf(areaDrenagem)));

			// garantiaAbr = interpolarAbr.calcular(abrX1, abrX2, garantiaAbr,
			// abrY1, abrY2);

			System.out.println("GARANTIA ABRIL FINAL" + garantiaAbr);

		} else {

			garantiaAbr = BigDecimal.ZERO;
		}

		rgarantiaAbr = garantiaAbr;
		// ua.setAbr(garantiaAbr);

		// rgarantiaMai=garantiaMai;
		// FIM ABRIL
		if (!garantiaMai.equals(BigDecimal.ZERO)) {

			System.out.println("##########INICIO MAIO##############");
			// Ordenação Maio
			// Usando Lambda
			listaItensVenda.sort((ua1, ua2) -> {
				if (ua2.getMai().compareTo(ua1.getMai()) == 1) {
					return 1;
				} else if (ua1.getMai().compareTo(ua2.getMai()) == 1) {
					return -1;
				} else {
					return 0;
				}
			});

			double posicaoMai = 1;
			List<BigDecimal> percentMai = new ArrayList<BigDecimal>();
			HashMap<String, BigDecimal> mapMai = new HashMap<>();

			for (Ua maio : listaItensVenda) {

				System.out.println("NumeroUA: " + maio.getNumeroUa() + " Mes: Maio " + " Vazao: " + maio.getMai());

				BigDecimal media = new BigDecimal(String.valueOf(posicaoMai)).divide(qtdBigDec, 4, RoundingMode.UP);
				percentMai.add(media);
				mapMai.merge(String.valueOf(media), new BigDecimal(String.valueOf(maio.getMai())), BigDecimal::add);

				System.out.println("TAMANHO DA LISTA: " + qtdBigDec);
				System.out.println("MEDIA : " + media + " POSICAO " + posicaoMai);
				System.out.println("--------------------------------------------");
				posicaoMai++;
			}
			System.out.println("--------------------------------------------");

			// Trabalhando com valores HashMap
			System.out.println("HashMap - 0.33 : " + mapMai.get("0.33"));
			System.out.println("HashMap - 0.66 : " + mapMai.get("0.66"));
			System.out.println("HashMap - 1.00 : " + mapMai.get("1.00"));

			System.out.println("--------------------------------------------");
			System.out.println("Percent Mai");

			percentMai.forEach(media -> System.out.println(media));
			System.out.println("--------------------------------------------");
			System.out.println("INTERPOLAÇÃO!");

			// garantiaMai = new
			// BigDecimal(String.valueOf(garantiaMai)).divide(new
			// BigDecimal("100"),2,RoundingMode.DOWN); // Valor informado pelo
			// usuário

			Set<String> chavesMai = mapMai.keySet();

			// Achar maior valor maiX2
			BigDecimal maiX2 = BigDecimal.ZERO;
			for (BigDecimal valor : percentMai) {

				if (valor.compareTo(garantiaMai) == 1) {

					maiX2 = valor;
					break;
				}
			}

			// Achar menor valor maiY2
			BigDecimal maiY2 = BigDecimal.ZERO;
			for (String c : chavesMai) {
				if (mapMai.get(c) == mapMai.get(String.valueOf(maiX2))) {
					maiY2 = mapMai.get(c);
					System.out.println("OOOOOMAIO Y2: " + maiY2);

				}

			}
			// Achar menor valor maiX1
			BigDecimal maiX1 = BigDecimal.ZERO;
			for (int i = percentMai.size() - 1; i > -1; i--) {
				BigDecimal valor = percentMai.get(i);
				if (valor.compareTo(garantiaMai) == -1) {
					maiX1 = valor;
					break;
				}
			}
			// Achar maior valor maiY1
			BigDecimal maiY1 = BigDecimal.ZERO;
			for (String c : chavesMai) {
				if (mapMai.get(c) == mapMai.get(String.valueOf(maiX1))) {
					maiY1 = mapMai.get(c);
					System.out.println("OOOOOMAIO Y1: " + maiY1);
				}
			}
			System.out.println("--------------------------------------------");
			System.out.println("PONTOS DE REFERENCIA PARA INTERPOLAR");
			System.out.println("MaiX1: " + maiX1);
			System.out.println("MaiX2: " + maiX2);
			System.out.println("MaiZ: " + garantiaMai);
			System.out.println("MaiY1: " + maiY1);
			System.out.println("MaiY2: " + maiY2);
			System.out.println("--------------------------------------------");

			Interpolar interpolarMai = new Interpolar();
			System.out.println("INTERPOLACAO MAIO: " + interpolarMai.calcular(maiX1, maiX2, garantiaMai, maiY1, maiY2));
			System.out.println("--------------------------------------------");

			BigDecimal calc1 = interpolarMai.calcular(maiX1, maiX2, garantiaMai, maiY1, maiY2);

			BigDecimal calc2 = new BigDecimal(String.valueOf(calc1)).divide(new BigDecimal(String.valueOf(areaUa)), 4,
					RoundingMode.UP);

			garantiaMai = new BigDecimal(String.valueOf(calc2)).multiply(new BigDecimal(String.valueOf(areaDrenagem)));

			// garantiaMai = interpolarMai.calcular(maiX1, maiX2, garantiaMai,
			// maiY1, maiY2);

		} else {
			garantiaMai = BigDecimal.ZERO;

		}

		rgarantiaMai = garantiaMai;
		// ua.setMai(garantiaMai);

		System.out.println("GARANTIA MAIO FINAL" + garantiaMai);
		// FIM MAIO
		System.out.println("##########INICIO JUNHO##############");
		// Ordenação Junho
		// rgarantiaJun=garantiaJun;
		if (!garantiaJun.equals(BigDecimal.ZERO)) {
			Collections.sort(listaItensVenda, new Comparator<Ua>() {
				@Override
				public int compare(Ua ua1, Ua ua2) {

					if (ua2.getJun().compareTo(ua1.getJun()) == 1) {
						return 1;
					} else if (ua1.getJun().compareTo(ua2.getJun()) == 1) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			double posicaoJun = 1;
			List<BigDecimal> percentJun = new ArrayList<BigDecimal>();
			HashMap<String, BigDecimal> mapJun = new HashMap<>();
			for (Ua junho : listaItensVenda) {

				System.out.println("NumeroUA: " + junho.getNumeroUa() + " Mes: Junho " + " Vazao: " + junho.getJun());

				BigDecimal media = new BigDecimal(String.valueOf(posicaoJun)).divide(qtdBigDec, 4, RoundingMode.UP);
				percentJun.add(media);
				mapJun.merge(String.valueOf(media), new BigDecimal(String.valueOf(junho.getJun())), BigDecimal::add);

				System.out.println("TAMANHO DA LISTA: " + qtdBigDec);
				System.out.println("MEDIA : " + media + " POSICAO " + posicaoJun);
				System.out.println("--------------------------------------------");
				posicaoJun++;
			}
			System.out.println("--------------------------------------------");

			// Trabalhando com valores HashMap
			System.out.println("HashMap - 0.33 : " + mapJun.get("0.33"));
			System.out.println("HashMap - 0.66 : " + mapJun.get("0.66"));
			System.out.println("HashMap - 1.00 : " + mapJun.get("1.00"));

			System.out.println("--------------------------------------------");
			System.out.println("Percent Jun");

			percentJun.forEach(media -> System.out.println(media));
			System.out.println("--------------------------------------------");
			System.out.println("INTERPOLAÇÃO!");

			// garantiaJun = new
			// BigDecimal(String.valueOf(garantiaJun)).divide(new
			// BigDecimal("100"),2,RoundingMode.DOWN); // Valor informado pelo
			// usuário

			Set<String> chavesJun = mapJun.keySet();

			// Achar maior valor junX2
			BigDecimal junX2 = BigDecimal.ZERO;
			for (BigDecimal valor : percentJun) {

				if (valor.compareTo(garantiaJun) == 1) {

					junX2 = valor;
					break;
				}
			}
			// Achar menor valor junY2
			BigDecimal junY2 = BigDecimal.ZERO;
			for (String c : chavesJun) {
				if (mapJun.get(c) == mapJun.get(String.valueOf(junX2))) {
					junY2 = mapJun.get(c);
					System.out.println("OOOOOJUNHO Y2: " + junY2);

				}
			}
			// Achar menor valor junX1
			BigDecimal junX1 = BigDecimal.ZERO;
			for (int i = percentJun.size() - 1; i > -1; i--) {
				BigDecimal valor = percentJun.get(i);
				if (valor.compareTo(garantiaJun) == -1) {
					junX1 = valor;
					break;
				}
			}
			// Achar maior valor junY1
			BigDecimal junY1 = BigDecimal.ZERO;
			for (String c : chavesJun) {
				if (mapJun.get(c) == mapJun.get(String.valueOf(junX1))) {
					junY1 = mapJun.get(c);
					System.out.println("OOOOOJUNHOY1: " + junY1);
				}
			}
			System.out.println("--------------------------------------------");
			System.out.println("PONTOS DE REFERENCIA PARA INTERPOLAR");
			System.out.println("JunX1: " + junX1);
			System.out.println("JunX2: " + junX2);
			System.out.println("JunZ: " + garantiaJun);
			System.out.println("JunY1: " + junY1);
			System.out.println("JunY2: " + junY2);
			System.out.println("--------------------------------------------");

			Interpolar interpolarJun = new Interpolar();
			System.out.println("INTERPOLACAO JUN: " + interpolarJun.calcular(junX1, junX2, garantiaJun, junY1, junY2));
			System.out.println("--------------------------------------------");

			BigDecimal calc1 = interpolarJun.calcular(junX1, junX2, garantiaJun, junY1, junY2);

			BigDecimal calc2 = new BigDecimal(String.valueOf(calc1)).divide(new BigDecimal(String.valueOf(areaUa)), 4,
					RoundingMode.UP);

			garantiaJun = new BigDecimal(String.valueOf(calc2)).multiply(new BigDecimal(String.valueOf(areaDrenagem)));

			// garantiaJun = interpolarJun.calcular(junX1, junX2, garantiaJun,
			// junY1, junY2);

			System.out.println("GARANTIA JUNHO FINAL" + garantiaJun);

		} else {

			garantiaJun = BigDecimal.ZERO;

		}

		rgarantiaJun = garantiaJun;
		// ua.setJun(garantiaJun);
		// rgarantiaJul=garantiaJul;
		if (!garantiaJul.equals(BigDecimal.ZERO)) {

			// FIM JUNHO
			System.out.println("##########INICIO JULHO##############");
			// Ordenação Julho
			Collections.sort(listaItensVenda, new Comparator<Ua>() {
				@Override
				public int compare(Ua ua1, Ua ua2) {

					if (ua2.getJul().compareTo(ua1.getJul()) == 1) {
						return 1;
					} else if (ua1.getJul().compareTo(ua2.getJul()) == 1) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			double posicaoJul = 1;
			List<BigDecimal> percentJul = new ArrayList<BigDecimal>();
			HashMap<String, BigDecimal> mapJul = new HashMap<>();
			for (Ua julho : listaItensVenda) {

				System.out.println("NumeroUA: " + julho.getNumeroUa() + " Mes: Julho " + " Vazao: " + julho.getJul());

				BigDecimal media = new BigDecimal(String.valueOf(posicaoJul)).divide(qtdBigDec, 4, RoundingMode.UP);
				percentJul.add(media);
				mapJul.merge(String.valueOf(media), new BigDecimal(String.valueOf(julho.getJul())), BigDecimal::add);

				System.out.println("TAMANHO DA LISTA: " + qtdBigDec);
				System.out.println("MEDIA : " + media + " POSICAO " + posicaoJul);
				System.out.println("--------------------------------------------");
				posicaoJul++;
			}

			System.out.println("--------------------------------------------");

			// Trabalhando com valores HashMap
			System.out.println("HashMap - 0.33 : " + mapJul.get("0.33"));
			System.out.println("HashMap - 0.66 : " + mapJul.get("0.66"));
			System.out.println("HashMap - 1.00 : " + mapJul.get("1.00"));

			System.out.println("--------------------------------------------");
			System.out.println("Percent Jul");

			percentJul.forEach(media -> System.out.println(media));
			System.out.println("--------------------------------------------");
			System.out.println("INTERPOLAÇÃO!");

			// garantiaJul = new
			// BigDecimal(String.valueOf(garantiaJul)).divide(new
			// BigDecimal("100"),2,RoundingMode.DOWN); // Valor informado pelo
			// usuário
			Set<String> chavesJul = mapJul.keySet();

			// Achar maior valor julX2
			BigDecimal julX2 = BigDecimal.ZERO;
			for (BigDecimal valor : percentJul) {

				if (valor.compareTo(garantiaJul) == 1) {

					julX2 = valor;
					break;
				}
			}
			// Achar menor valor julY2
			BigDecimal julY2 = BigDecimal.ZERO;
			for (String c : chavesJul) {
				if (mapJul.get(c) == mapJul.get(String.valueOf(julX2))) {
					julY2 = mapJul.get(c);
					System.out.println("OOOOOJULHO Y2: " + julY2);

				}
			}
			// Achar menor valor julX1
			BigDecimal julX1 = BigDecimal.ZERO;
			for (int i = percentJul.size() - 1; i > -1; i--) {
				BigDecimal valor = percentJul.get(i);
				if (valor.compareTo(garantiaJul) == -1) {
					julX1 = valor;
					break;
				}
			}
			// Achar maior valor julY1
			BigDecimal julY1 = BigDecimal.ZERO;
			for (String c : chavesJul) {
				if (mapJul.get(c) == mapJul.get(String.valueOf(julX1))) {
					julY1 = mapJul.get(c);
					System.out.println("OOOOOJULHO Y1: " + julY1);
				}
			}
			System.out.println("--------------------------------------------");
			System.out.println("PONTOS DE REFERENCIA PARA INTERPOLAR");
			System.out.println("JulX1: " + julX1);
			System.out.println("JulX2: " + julX2);
			System.out.println("JulZ: " + garantiaJul);
			System.out.println("JulY1: " + julY1);
			System.out.println("JulY2: " + julY2);
			System.out.println("--------------------------------------------");

			Interpolar interpolarJul = new Interpolar();
			System.out
					.println("INTERPOLACAO JULHO: " + interpolarJul.calcular(julX1, julX2, garantiaJul, julY1, julY2));
			System.out.println("--------------------------------------------");

			BigDecimal calc1 = interpolarJul.calcular(julX1, julX2, garantiaJul, julY1, julY2);

			BigDecimal calc2 = new BigDecimal(String.valueOf(calc1)).divide(new BigDecimal(String.valueOf(areaUa)), 4,
					RoundingMode.UP);

			garantiaJul = new BigDecimal(String.valueOf(calc2)).multiply(new BigDecimal(String.valueOf(areaDrenagem)));

			// garantiaJul = interpolarJul.calcular(julX1, julX2, garantiaJul,
			// julY1, julY2);

		} else {

			garantiaJul = BigDecimal.ZERO;

		}

		rgarantiaJul = garantiaJul;
		// ua.setJul(garantiaJul);

		System.out.println("GARANTIA JULHO FINAL" + garantiaJul);
		// rgarantiaAgo=garantiaAgo;

		if (!garantiaAgo.equals(BigDecimal.ZERO)) {

			// FIM JULHO
			System.out.println("##########INICIO AGOSTO##############");
			// Ordenação Agosto
			Collections.sort(listaItensVenda, new Comparator<Ua>() {
				@Override
				public int compare(Ua ua1, Ua ua2) {

					if (ua2.getAgo().compareTo(ua1.getAgo()) == 1) {
						return 1;
					} else if (ua1.getAgo().compareTo(ua2.getAgo()) == 1) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			double posicaoAgo = 1;
			List<BigDecimal> percentAgo = new ArrayList<BigDecimal>();
			HashMap<String, BigDecimal> mapAgo = new HashMap<>();
			for (Ua agosto : listaItensVenda) {

				System.out
						.println("NumeroUA: " + agosto.getNumeroUa() + " Mes: Agosto " + " Vazao: " + agosto.getAgo());

				BigDecimal media = new BigDecimal(String.valueOf(posicaoAgo)).divide(qtdBigDec, 4, RoundingMode.UP);
				percentAgo.add(media);
				mapAgo.merge(String.valueOf(media), new BigDecimal(String.valueOf(agosto.getAgo())), BigDecimal::add);

				System.out.println("TAMANHO DA LISTA: " + qtdBigDec);
				System.out.println("MEDIA : " + media + " POSICAO " + posicaoAgo);
				System.out.println("--------------------------------------------");
				posicaoAgo++;
			}

			System.out.println("--------------------------------------------");

			// Trabalhando com valores HashMap
			System.out.println("HashMap - 0.33 : " + mapAgo.get("0.33"));
			System.out.println("HashMap - 0.66 : " + mapAgo.get("0.66"));
			System.out.println("HashMap - 1.00 : " + mapAgo.get("1.00"));

			System.out.println("--------------------------------------------");
			System.out.println("Percent Ago");

			percentAgo.forEach(media -> System.out.println(media));
			System.out.println("--------------------------------------------");
			System.out.println("INTERPOLAÇÃO!");

			// garantiaAgo = new
			// BigDecimal(String.valueOf(garantiaAgo)).divide(new
			// BigDecimal("100"),2,RoundingMode.DOWN); // Valor informado pelo
			// usuário
			Set<String> chavesAgo = mapAgo.keySet();

			// Achar maior valor fevX2
			BigDecimal agoX2 = BigDecimal.ZERO;
			for (BigDecimal valor : percentAgo) {

				if (valor.compareTo(garantiaAgo) == 1) {

					agoX2 = valor;
					break;
				}
			}
			// Achar menor valor fevY2
			BigDecimal agoY2 = BigDecimal.ZERO;
			for (String c : chavesAgo) {
				if (mapAgo.get(c) == mapAgo.get(String.valueOf(agoX2))) {
					agoY2 = mapAgo.get(c);
					System.out.println("OOOOOAGOSTO Y2: " + agoY2);

				}
			}
			// Achar menor valor fevX1
			BigDecimal agoX1 = BigDecimal.ZERO;
			for (int i = percentAgo.size() - 1; i > -1; i--) {
				BigDecimal valor = percentAgo.get(i);
				if (valor.compareTo(garantiaAgo) == -1) {
					agoX1 = valor;
					break;
				}
			}
			// Achar maior valor fevY1
			BigDecimal agoY1 = BigDecimal.ZERO;
			for (String c : chavesAgo) {
				if (mapAgo.get(c) == mapAgo.get(String.valueOf(agoX1))) {
					agoY1 = mapAgo.get(c);
					System.out.println("OOOOOAGOSTO Y1: " + agoY1);
				}
			}
			System.out.println("--------------------------------------------");
			System.out.println("PONTOS DE REFERENCIA PARA INTERPOLAR");
			System.out.println("AgoX1: " + agoX1);
			System.out.println("AgoX2: " + agoX2);
			System.out.println("AgoZ: " + garantiaAgo);
			System.out.println("AgoY1: " + agoY1);
			System.out.println("AgoY2: " + agoY2);
			System.out.println("--------------------------------------------");

			Interpolar interpolarAgo = new Interpolar();
			System.out
					.println("INTERPOLACAO AGOSTO: " + interpolarAgo.calcular(agoX1, agoX2, garantiaAgo, agoY1, agoY2));
			System.out.println("--------------------------------------------");

			BigDecimal calc1 = interpolarAgo.calcular(agoX1, agoX2, garantiaAgo, agoY1, agoY2);

			BigDecimal calc2 = new BigDecimal(String.valueOf(calc1)).divide(new BigDecimal(String.valueOf(areaUa)), 4,
					RoundingMode.UP);

			garantiaAgo = new BigDecimal(String.valueOf(calc2)).multiply(new BigDecimal(String.valueOf(areaDrenagem)));

			// garantiaAgo = interpolarAgo.calcular(agoX1, agoX2, garantiaAgo,
			// agoY1, agoY2);

		} else {

			garantiaAgo = BigDecimal.ZERO;

		}

		rgarantiaAgo = garantiaAgo;

		// ua.setAgo(garantiaAgo);

		System.out.println("GARANTIA AGOSTO FINAL" + garantiaAgo);

		// FIM AGOSTO
		// rgarantiaSet=garantiaSet;
		if (!garantiaSet.equals(BigDecimal.ZERO)) {

			System.out.println("##########INICIO SETEMBRO##############");
			// Ordenanação Setembro
			Collections.sort(listaItensVenda, new Comparator<Ua>() {
				@Override
				public int compare(Ua ua1, Ua ua2) {

					if (ua2.getSet().compareTo(ua1.getSet()) == 1) {
						return 1;
					} else if (ua1.getSet().compareTo(ua2.getSet()) == 1) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			double posicaoSet = 1;
			List<BigDecimal> percentSet = new ArrayList<BigDecimal>();
			HashMap<String, BigDecimal> mapSet = new HashMap<>();
			for (Ua setembro : listaItensVenda) {

				System.out.println(
						"NumeroUA: " + setembro.getNumeroUa() + " Mes: Setembro " + " Vazao: " + setembro.getSet());

				BigDecimal media = new BigDecimal(String.valueOf(posicaoSet)).divide(qtdBigDec, 4, RoundingMode.UP);
				percentSet.add(media);
				mapSet.merge(String.valueOf(media), new BigDecimal(String.valueOf(setembro.getSet())), BigDecimal::add);

				System.out.println("TAMANHO DA LISTA: " + qtdBigDec);
				System.out.println("MEDIA : " + media + " POSICAO " + posicaoSet);
				System.out.println("--------------------------------------------");
				posicaoSet++;
			}
			System.out.println("--------------------------------------------");

			// Trabalhando com valores HashMap
			System.out.println("HashMap - 0.33 : " + mapSet.get("0.33"));
			System.out.println("HashMap - 0.66 : " + mapSet.get("0.66"));
			System.out.println("HashMap - 1.00 : " + mapSet.get("1.00"));

			System.out.println("--------------------------------------------");
			System.out.println("Percent Set");

			percentSet.forEach(media -> System.out.println(media));
			System.out.println("--------------------------------------------");
			System.out.println("INTERPOLAÇÃO!");

			// garantiaSet = new
			// BigDecimal(String.valueOf(garantiaSet)).divide(new
			// BigDecimal("100"),2,RoundingMode.DOWN); // Valor informado pelo
			// usuário

			Set<String> chavesSet = mapSet.keySet();

			// Achar maior valor setX2
			BigDecimal setX2 = BigDecimal.ZERO;
			for (BigDecimal valor : percentSet) {

				if (valor.compareTo(garantiaSet) == 1) {

					setX2 = valor;
					break;
				}
			}
			// Achar menor valor setY2
			BigDecimal setY2 = BigDecimal.ZERO;
			for (String c : chavesSet) {
				if (mapSet.get(c) == mapSet.get(String.valueOf(setX2))) {
					setY2 = mapSet.get(c);
					System.out.println("OOOOOSETEMBRO Y2: " + setY2);

				}
			}
			// Achar menor valor setX1
			BigDecimal setX1 = BigDecimal.ZERO;
			for (int i = percentSet.size() - 1; i > -1; i--) {
				BigDecimal valor = percentSet.get(i);
				if (valor.compareTo(garantiaSet) == -1) {
					setX1 = valor;
					break;
				}
			}
			// Achar maior valor setY1
			BigDecimal setY1 = BigDecimal.ZERO;
			for (String c : chavesSet) {
				if (mapSet.get(c) == mapSet.get(String.valueOf(setX1))) {
					setY1 = mapSet.get(c);
					System.out.println("OOOOOSETEMBRO Y1: " + setY1);
				}
			}
			System.out.println("--------------------------------------------");
			System.out.println("PONTOS DE REFERENCIA PARA INTERPOLAR");
			System.out.println("FevX1: " + setX1);
			System.out.println("FevX2: " + setX2);
			System.out.println("FevZ: " + garantiaSet);
			System.out.println("FevY1: " + setY1);
			System.out.println("FevY2: " + setY2);
			System.out.println("--------------------------------------------");

			Interpolar interpolarSet = new Interpolar();
			System.out.println(
					"INTERPOLACAO SETEMBRO: " + interpolarSet.calcular(setX1, setX2, garantiaSet, setY1, setY2));
			System.out.println("--------------------------------------------");

			BigDecimal calc1 = interpolarSet.calcular(setX1, setX2, garantiaSet, setY1, setY2);

			BigDecimal calc2 = new BigDecimal(String.valueOf(calc1)).divide(new BigDecimal(String.valueOf(areaUa)), 4,
					RoundingMode.UP);

			garantiaSet = new BigDecimal(String.valueOf(calc2)).multiply(new BigDecimal(String.valueOf(areaDrenagem)));

			// garantiaSet = interpolarSet.calcular(setX1, setX2, garantiaSet,
			// setY1, setY2);

		} else {
			garantiaSet = BigDecimal.ZERO;

		}

		rgarantiaSet = garantiaSet;
		// ua.setSet(garantiaSet);

		System.out.println("GARANTIA SETEMBRO FINAL" + garantiaSet);
		// FIM SETEMBRO
		// rgarantiaOut=garantiaOut;
		if (!garantiaOut.equals(BigDecimal.ZERO)) {

			System.out.println("##########INICIO OUTUBRO##############");
			// Ordenanação Outubro
			Collections.sort(listaItensVenda, new Comparator<Ua>() {
				@Override
				public int compare(Ua ua1, Ua ua2) {

					if (ua2.getOut().compareTo(ua1.getOut()) == 1) {
						return 1;
					} else if (ua1.getOut().compareTo(ua2.getOut()) == 1) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			double posicaoOut = 1;
			List<BigDecimal> percentOut = new ArrayList<BigDecimal>();
			HashMap<String, BigDecimal> mapOut = new HashMap<>();

			for (Ua outubro : listaItensVenda) {

				System.out.println(
						"NumeroUA: " + outubro.getNumeroUa() + " Mes: Outubro " + " Vazao: " + outubro.getOut());

				BigDecimal media = new BigDecimal(String.valueOf(posicaoOut)).divide(qtdBigDec, 4, RoundingMode.UP);
				percentOut.add(media);
				mapOut.merge(String.valueOf(media), new BigDecimal(String.valueOf(outubro.getOut())), BigDecimal::add);

				System.out.println("TAMANHO DA LISTA: " + qtdBigDec);
				System.out.println("MEDIA : " + media + " POSICAO " + posicaoOut);
				System.out.println("--------------------------------------------");
				posicaoOut++;
			}
			// Trabalhando com valores HashMap
			System.out.println("HashMap - 0.33 : " + mapOut.get("0.33"));
			System.out.println("HashMap - 0.66 : " + mapOut.get("0.66"));
			System.out.println("HashMap - 1.00 : " + mapOut.get("1.00"));

			System.out.println("--------------------------------------------");
			System.out.println("Percent Out");

			percentOut.forEach(media -> System.out.println(media));
			System.out.println("--------------------------------------------");
			System.out.println("INTERPOLAÇÃO!");

			// garantiaOut = new
			// BigDecimal(String.valueOf(garantiaOut)).divide(new
			// BigDecimal("100"),2,RoundingMode.DOWN); // Valor informado pelo
			// usuário

			Set<String> chavesOut = mapOut.keySet();

			// Achar maior valor outX2
			BigDecimal outX2 = BigDecimal.ZERO;
			for (BigDecimal valor : percentOut) {

				if (valor.compareTo(garantiaOut) == 1) {

					outX2 = valor;
					break;
				}
			}
			// Achar menor valor outY2
			BigDecimal outY2 = BigDecimal.ZERO;
			for (String c : chavesOut) {
				if (mapOut.get(c) == mapOut.get(String.valueOf(outX2))) {
					outY2 = mapOut.get(c);
					System.out.println("OOOOOFEV Y2: " + outY2);

				}
			}
			// Achar menor valor outX1
			BigDecimal outX1 = BigDecimal.ZERO;
			for (int i = percentOut.size() - 1; i > -1; i--) {
				BigDecimal valor = percentOut.get(i);
				if (valor.compareTo(garantiaOut) == -1) {
					outX1 = valor;
					break;
				}
			}
			// Achar maior valor outY1
			BigDecimal outY1 = BigDecimal.ZERO;
			for (String c : chavesOut) {
				if (mapOut.get(c) == mapOut.get(String.valueOf(outX1))) {
					outY1 = mapOut.get(c);
					System.out.println("OOOOOFevY1: " + outY1);
				}
			}
			System.out.println("--------------------------------------------");
			System.out.println("PONTOS DE REFERENCIA PARA INTERPOLAR");
			System.out.println("OutX1: " + outX1);
			System.out.println("OutX2: " + outX2);
			System.out.println("OutZ: " + garantiaOut);
			System.out.println("OutY1: " + outY1);
			System.out.println("OutY2: " + outY2);
			System.out.println("--------------------------------------------");

			Interpolar interpolarOut = new Interpolar();
			System.out.println("INTERPOLACAO OUT: " + interpolarOut.calcular(outX1, outX2, garantiaOut, outY1, outY2));
			System.out.println("--------------------------------------------");

			BigDecimal calc1 = interpolarOut.calcular(outX1, outX2, garantiaOut, outY1, outY2);

			BigDecimal calc2 = new BigDecimal(String.valueOf(calc1)).divide(new BigDecimal(String.valueOf(areaUa)), 4,
					RoundingMode.UP);

			garantiaOut = new BigDecimal(String.valueOf(calc2)).multiply(new BigDecimal(String.valueOf(areaDrenagem)));

			// garantiaOut = interpolarOut.calcular(outX1, outX2, garantiaOut,
			// outY1, outY2);

		} else {

			garantiaOut = BigDecimal.ZERO;
		}
		rgarantiaOut = garantiaOut;
		// ua.setOut(garantiaOut);
		// rgarantiaNov=garantiaNov;
		System.out.println("GARANTIA OUTUBRO FINAL" + garantiaOut);

		// FIM OUTUBRO
		if (!garantiaNov.equals(BigDecimal.ZERO)) {

			System.out.println("##########INICIO NOVEMBRO##############");
			// Ordenanação Novembro
			Collections.sort(listaItensVenda, new Comparator<Ua>() {
				@Override
				public int compare(Ua ua1, Ua ua2) {

					if (ua2.getNov().compareTo(ua1.getNov()) == 1) {
						return 1;
					} else if (ua1.getNov().compareTo(ua2.getNov()) == 1) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			double posicaoNov = 1;
			List<BigDecimal> percentNov = new ArrayList<BigDecimal>();
			HashMap<String, BigDecimal> mapNov = new HashMap<>();
			for (Ua novembro : listaItensVenda) {

				System.out.println(
						"NumeroUA: " + novembro.getNumeroUa() + " Mes: Novembro " + " Vazao: " + novembro.getNov());

				BigDecimal media = new BigDecimal(String.valueOf(posicaoNov)).divide(qtdBigDec, 4, RoundingMode.UP);
				percentNov.add(media);
				mapNov.merge(String.valueOf(media), new BigDecimal(String.valueOf(novembro.getNov())), BigDecimal::add);

				System.out.println("TAMANHO DA LISTA: " + qtdBigDec);
				System.out.println("MEDIA : " + media + " POSICAO " + posicaoNov);
				System.out.println("--------------------------------------------");
				posicaoNov++;
			}
			System.out.println("--------------------------------------------");

			// Trabalhando com valores HashMap
			System.out.println("HashMap - 0.33 : " + mapNov.get("0.33"));
			System.out.println("HashMap - 0.66 : " + mapNov.get("0.66"));
			System.out.println("HashMap - 1.00 : " + mapNov.get("1.00"));

			System.out.println("--------------------------------------------");
			System.out.println("Percent Nov");

			percentNov.forEach(media -> System.out.println(media));
			System.out.println("--------------------------------------------");
			System.out.println("INTERPOLAÇÃO!");

			// garantiaNov = new
			// BigDecimal(String.valueOf(garantiaNov)).divide(new
			// BigDecimal("100"),2,RoundingMode.DOWN); // Valor informado pelo
			// usuário
			Set<String> chavesNov = mapNov.keySet();

			// Achar maior valor novX2
			BigDecimal novX2 = BigDecimal.ZERO;
			for (BigDecimal valor : percentNov) {

				if (valor.compareTo(garantiaNov) == 1) {

					novX2 = valor;
					break;
				}
			}
			// Achar menor valor novY2
			BigDecimal novY2 = BigDecimal.ZERO;
			for (String c : chavesNov) {
				if (mapNov.get(c) == mapNov.get(String.valueOf(novX2))) {
					novY2 = mapNov.get(c);
					System.out.println("OOOOONOVEMBRO Y2: " + novY2);

				}
			}
			// Achar menor valor novX1
			BigDecimal novX1 = BigDecimal.ZERO;
			for (int i = percentNov.size() - 1; i > -1; i--) {
				BigDecimal valor = percentNov.get(i);
				if (valor.compareTo(garantiaNov) == -1) {
					novX1 = valor;
					break;
				}
			}
			// Achar maior valor novY1
			BigDecimal novY1 = BigDecimal.ZERO;
			for (String c : chavesNov) {
				if (mapNov.get(c) == mapNov.get(String.valueOf(novX1))) {
					novY1 = mapNov.get(c);
					System.out.println("OOOOONOVY1: " + novY1);
				}
			}
			System.out.println("--------------------------------------------");
			System.out.println("PONTOS DE REFERENCIA PARA INTERPOLAR");
			System.out.println("NovX1: " + novX1);
			System.out.println("NovX2: " + novX2);
			System.out.println("NovZ: " + garantiaNov);
			System.out.println("NovY1: " + novY1);
			System.out.println("NovY2: " + novY2);
			System.out.println("--------------------------------------------");

			Interpolar interpolarNov = new Interpolar();
			System.out.println(
					"INTERPOLACAO NOVEMBRO: " + interpolarNov.calcular(novX1, novX2, garantiaNov, novY1, novY2));
			System.out.println("--------------------------------------------");

			BigDecimal calc1 = interpolarNov.calcular(novX1, novX2, garantiaNov, novY1, novY2);

			BigDecimal calc2 = new BigDecimal(String.valueOf(calc1)).divide(new BigDecimal(String.valueOf(areaUa)), 4,
					RoundingMode.UP);

			garantiaNov = new BigDecimal(String.valueOf(calc2)).multiply(new BigDecimal(String.valueOf(areaDrenagem)));

			// garantiaNov = interpolarNov.calcular(novX1, novX2, garantiaNov,
			// novY1, novY2);

		} else {

			garantiaNov = BigDecimal.ZERO;
		}

		rgarantiaNov = garantiaNov;
		// ua.setNov(garantiaNov);
		System.out.println("GARANTIA NOVEMBRO FINAL" + garantiaNov);
		// FIM NOVEMBRO
		// rgarantiaDez=garantiaDez;
		if (!garantiaDez.equals(BigDecimal.ZERO)) {
			System.out.println("##########INICIO DEZEMBRO##############");
			// Ordenanação Dezembro
			Collections.sort(listaItensVenda, new Comparator<Ua>() {
				@Override
				public int compare(Ua ua1, Ua ua2) {

					if (ua2.getDez().compareTo(ua1.getDez()) == 1) {
						return 1;
					} else if (ua1.getDez().compareTo(ua2.getDez()) == 1) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			int posicaoDez = 1;
			List<BigDecimal> percentDez = new ArrayList<BigDecimal>();
			HashMap<String, BigDecimal> mapDez = new HashMap<>();
			for (Ua dezembro : listaItensVenda) {

				System.out.println(
						"NumeroUA: " + dezembro.getNumeroUa() + " Mes: Dezembro " + " Vazao: " + dezembro.getDez());

				BigDecimal media = new BigDecimal(String.valueOf(posicaoDez)).divide(qtdBigDec, 4, RoundingMode.UP);
				percentDez.add(media);
				mapDez.merge(String.valueOf(media), new BigDecimal(String.valueOf(dezembro.getDez())), BigDecimal::add);

				System.out.println("TAMANHO DA LISTA: " + qtdBigDec);
				System.out.println("MEDIA : " + media + " POSICAO " + posicaoDez);
				System.out.println("--------------------------------------------");
				posicaoDez++;
			}
			System.out.println("--------------------------------------------");

			// Trabalhando com valores HashMap
			System.out.println("HashMap - 0.33 : " + mapDez.get("0.33"));
			System.out.println("HashMap - 0.66 : " + mapDez.get("0.66"));
			System.out.println("HashMap - 1.00 : " + mapDez.get("1.00"));

			System.out.println("--------------------------------------------");
			System.out.println("Percent Dez");

			percentDez.forEach(media -> System.out.println(media));
			System.out.println("--------------------------------------------");
			System.out.println("INTERPOLAÇÃO!");

			// garantiaDez = new
			// BigDecimal(String.valueOf(garantiaDez)).divide(new
			// BigDecimal("100"),2,RoundingMode.DOWN); // Valor informado pelo
			// usuário

			Set<String> chavesDez = mapDez.keySet();

			// Achar maior valor dezX2
			BigDecimal dezX2 = BigDecimal.ZERO;
			for (BigDecimal valor : percentDez) {

				if (valor.compareTo(garantiaDez) == 1) {

					dezX2 = valor;
					break;
				}
			}
			// Achar menor valor dezY2
			BigDecimal dezY2 = BigDecimal.ZERO;
			for (String c : chavesDez) {
				if (mapDez.get(c) == mapDez.get(String.valueOf(dezX2))) {
					dezY2 = mapDez.get(c);
					System.out.println("OOOOODEZEMBRO Y2: " + dezY2);

				}
			}
			// Achar menor valor dezX1
			BigDecimal dezX1 = BigDecimal.ZERO;
			for (int i = percentDez.size() - 1; i > -1; i--) {
				BigDecimal valor = percentDez.get(i);
				if (valor.compareTo(garantiaDez) == -1) {
					dezX1 = valor;
					break;
				}
			}
			// Achar maior valor dezY1
			BigDecimal dezY1 = BigDecimal.ZERO;
			for (String c : chavesDez) {
				if (mapDez.get(c) == mapDez.get(String.valueOf(dezX1))) {
					dezY1 = mapDez.get(c);
					System.out.println("OOOOODEZEMBRO Y1: " + dezY1);
				}
			}
			System.out.println("--------------------------------------------");
			System.out.println("PONTOS DE REFERENCIA PARA INTERPOLAR");
			System.out.println("DezX1: " + dezX1);
			System.out.println("DezX2: " + dezX2);
			System.out.println("DezZ: " + garantiaDez);
			System.out.println("DezY1: " + dezY1);
			System.out.println("DezY2: " + dezY2);
			System.out.println("--------------------------------------------");

			Interpolar interpolarDez = new Interpolar();
			System.out.println(
					"INTERPOLACAO DEZEMBRO: " + interpolarDez.calcular(dezX1, dezX2, garantiaDez, dezY1, dezY2));
			System.out.println("--------------------------------------------");

			BigDecimal calc1 = interpolarDez.calcular(dezX1, dezX2, garantiaDez, dezY1, dezY2);

			BigDecimal calc2 = new BigDecimal(String.valueOf(calc1)).divide(new BigDecimal(String.valueOf(areaUa)), 4,
					RoundingMode.UP);

			garantiaDez = new BigDecimal(String.valueOf(calc2)).multiply(new BigDecimal(String.valueOf(areaDrenagem)));

			// garantiaDez = interpolarDez.calcular(dezX1, dezX2, garantiaDez,
			// dezY1, dezY2);

			// FIM DEZEMBRO
		} else {
			garantiaDez = BigDecimal.ZERO;

		}
		rgarantiaDez = garantiaDez;

		// ua.setDez(garantiaDez);

		System.out.println("GARANTIA FINAL DEZEMBRO" + garantiaDez);

		venda.setNumeroUa(num);
		venda.setAreaDrenagem(areaDrenagem);
		venda.setAreaUa(areaUa);
		venda.setJan(rgarantiaJan); // Valores do método calcular incluso
		venda.setFev(rgarantiaFev);
		venda.setMar(rgarantiaMar);
		venda.setAbr(rgarantiaAbr);
		venda.setMai(rgarantiaMai);
		venda.setJun(rgarantiaJun);
		venda.setJul(rgarantiaJul);
		venda.setAgo(rgarantiaAgo);
		venda.setSet(rgarantiaSet);
		venda.setOut(rgarantiaOut);
		venda.setNov(rgarantiaNov);
		venda.setDez(rgarantiaDez);
		venda.setProcessoJusante(processoJusante);
		venda.setProcessoMotante(processoMontante);

		encaixar();
		cacularDisponibilidade();
	}

}
