import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import br.com.pgo.domain.Ua;
import br.com.pgo.util.Interpolacao;

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
		int posicaoFev = 1;
		List<BigDecimal> percentFev = new ArrayList<BigDecimal>();
		HashMap<String, BigDecimal> mapFev = new HashMap<>();
		for (Ua fevereiro : listaItensVenda) {

			System.out.println(
					"NumeroUA: " + fevereiro.getNumeroUa() + " Mes: Fevereiro " + " Vazao: " + fevereiro.getFev());

			BigDecimal media = new BigDecimal(String.valueOf(posicaoFev)).divide(qtdBigDec, 2, RoundingMode.DOWN);
			percentFev.add(media);
			mapFev.merge(String.valueOf(media), new BigDecimal(String.valueOf(fevereiro.getFev())), BigDecimal::add);

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
		
		
		
		Set<String> chavesFev = mapFev.keySet();
		
		//Achar maior valor fevX2
		BigDecimal fevX2 = BigDecimal.ZERO;
		for(BigDecimal valor : percentFev){
			
			if(valor.compareTo(z) == 1){
				
				fevX2 = valor;
				break;
			   }
			}
		//Achar menor valor fevY2		
		BigDecimal fevY2 = BigDecimal.ZERO;
		for (String c : chavesFev){
			if(mapFev.get(c) == mapFev.get(String.valueOf(fevX2))){
				fevY2 = mapFev.get(c);
				System.out.println("OOOOOFEV Y2: "+fevX2);
				
			}
			
		}
		
		//Achar menor valor fevX1
		BigDecimal fevX1 = BigDecimal.ZERO;
		for (int i = percentFev.size()-1; i>-1; i--){
			BigDecimal valor = percentFev.get(i);
			if(valor.compareTo(z)==-1){
				fevX1 = valor;
				break;
			}
		}
		//Achar maior valor fevY1
		BigDecimal fevY1 = BigDecimal.ZERO;
		for(String c : chavesFev){
			if(mapFev.get(c)==mapFev.get(String.valueOf(fevX1))){
				fevY1=mapFev.get(c);
				System.out.println("OOOOOFevY1: "+fevY1);
			}
		}
		System.out.println("--------------------------------------------");
		System.out.println("PONTOS DE REFERENCIA PARA INTERPOLAR");
		System.out.println("FevX1: " + fevX1);
		System.out.println("FevX2: " + fevX2);
		System.out.println("FevZ: " + z);
		System.out.println("FevY1: " + fevY1);
		System.out.println("FevY2: " + fevY2);
		System.out.println("--------------------------------------------");
		
		Interpolacao interpolarFev = new Interpolacao();
		System.out.println("INTERPOLACAO FEV: " + interpolarFev.calcular(fevX1, fevX2, z, fevY1, fevY2));
		System.out.println("--------------------------------------------");
		
		//FIM FEVEREIRO
