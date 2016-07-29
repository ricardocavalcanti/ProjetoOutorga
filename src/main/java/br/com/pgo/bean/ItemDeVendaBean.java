package br.com.pgo.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;
import br.com.pgo.dao.UaDAO;
import br.com.pgo.domain.ItemDeVenda;
import br.com.pgo.domain.Ua;
import br.com.pgo.util.Interpolacao;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ItemDeVendaBean implements Serializable {

	private Ua ua;
	private List<Ua> listaUa;
	private List<Ua> listaItensVenda;
	private ItemDeVenda itemDeVenda;

	public void novo() {

		itemDeVenda = new ItemDeVenda();

	}

	public Ua getUa() {
		return ua;
	}

	public void setUa(Ua ua) {
		this.ua = ua;
	}

	public List<Ua> getListaUa() {
		return listaUa;
	}

	public void setListaUa(List<Ua> listaUa) {
		this.listaUa = listaUa;
	}

	public List<Ua> getListaItensVenda() {
		return listaItensVenda;
	}

	public void setListaItensVenda(List<Ua> listaItensVenda) {
		this.listaItensVenda = listaItensVenda;
	}

	public ItemDeVenda getItemDeVenda() {
		return itemDeVenda;
	}

	public void setItemDeVenda(ItemDeVenda itemDeVenda) {
		this.itemDeVenda = itemDeVenda;
	}

	@PostConstruct
	public void listar() {

		try {

			UaDAO uaDAO = new UaDAO();
			listaUa = uaDAO.listar("numeroUa");

			listaItensVenda = new ArrayList<>();

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao tentar carregar 'Seleção UA'");
			erro.printStackTrace();
		}

	}

	public void adicionar(ActionEvent evento) {

		ua = (Ua) evento.getComponent().getAttributes().get("uaSelecionada");

		ua.setAno(ua.getAno());
		ua.setNumeroUa(ua.getNumeroUa());
		ua.setJan(ua.getJan());
		ua.setFev(ua.getFev());
		ua.setMar(ua.getMar());
		ua.setAbr(ua.getAbr());
		ua.setMai(ua.getMai());
		ua.setJun(ua.getJun());
		ua.setJul(ua.getJul());
		ua.setAgo(ua.getAgo());
		ua.setSet(ua.getSet());
		ua.setOut(ua.getOut());
		ua.setNov(ua.getNov());
		ua.setDez(ua.getDez());

		listaItensVenda.add(ua);

	}

	// Método para calcular a interpolação dos pontos
	public void calcular() {

		// Para contar o tamanho da quantidade de elementos da lista, para ser
		// utilizado na divisão = (posiçãoJan/Quantidade).
		double quantidade = listaItensVenda.size();
		BigDecimal qtdBigDec = new BigDecimal(String.valueOf(listaItensVenda.size()));

		// -------------------------------------INICIO//
		// JANEIRO---------------------------------------------------------------------------------------------------------//

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
		// Posição inicial de Janeiro para ser utilizado na divisão =
		// (posiçãoJan/Quantidade)
		int posicaoJan = 1;
		// Adiconar os valores percentuais para fazer a busca dos valores que
		// estão antes de depois do valor informado para ser interpolado.
		List<BigDecimal> percentJan = new ArrayList<BigDecimal>();
		HashMap<String, BigDecimal> mapJan = new HashMap<>();
		// Para calcular os percentuais (posição/quantidade)
		for (Ua janeiro : listaItensVenda) {

			System.out.println(
					"NumeroUA: " + janeiro.getNumeroUa() + " - Mes: Janeiro " + " - Vazao: " + janeiro.getJan());

			// Adiconando a medeia ao List percentJan
			BigDecimal media = new BigDecimal(String.valueOf(posicaoJan)).divide(qtdBigDec, 2, RoundingMode.DOWN);
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
		BigDecimal z = new BigDecimal("0.4"); // Valor informado pelo usuário
		// Pegar as keys do HashMap da lista de Janeiro
		Set<String> chaves = mapJan.keySet();

		// Achar maior valor x2
		for (BigDecimal valor : percentJan) {

			if (valor.compareTo(z) == 1) {

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

			if (valor.compareTo(z) == -1) {

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
		System.out.println("Z: " + z);
		System.out.println("Y1: " + y1);
		System.out.println("Y2: " + y2);
		System.out.println("--------------------------------------------");

		Interpolacao InterpolarJan = new Interpolacao();

		System.out.println("INTERPOLACAO JAN: " + InterpolarJan.calcular(x1, x2, z, y1, y2));
		System.out.println("--------------------------------------------");
		// Interpolar.calcular(x1, x2, z, y1, y2) ;

		// -------------------------------------FIM //
		// JANEIRO---------------------------------------------------------------------------------------------------------//

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

		// Achar maior valor fevX2
		BigDecimal fevX2 = BigDecimal.ZERO;
		for (BigDecimal valor : percentFev) {

			if (valor.compareTo(z) == 1) {

				fevX2 = valor;
				break;
			}
		}
		// Achar menor valor fevY2
		BigDecimal fevY2 = BigDecimal.ZERO;
		for (String c : chavesFev) {
			if (mapFev.get(c) == mapFev.get(String.valueOf(fevX2))) {
				fevY2 = mapFev.get(c);
				System.out.println("OOOOOFEV Y2: " + fevX2);

			}

		}

		// Achar menor valor fevX1
		BigDecimal fevX1 = BigDecimal.ZERO;
		for (int i = percentFev.size() - 1; i > -1; i--) {
			BigDecimal valor = percentFev.get(i);
			if (valor.compareTo(z) == -1) {
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
		System.out.println("FevZ: " + z);
		System.out.println("FevY1: " + fevY1);
		System.out.println("FevY2: " + fevY2);
		System.out.println("--------------------------------------------");

		Interpolacao interpolarFev = new Interpolacao();
		System.out.println("INTERPOLACAO FEV: " + interpolarFev.calcular(fevX1, fevX2, z, fevY1, fevY2));
		System.out.println("--------------------------------------------");

		// FIM FEVEREIRO

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
		double posicaoMar = 1;
		List<BigDecimal> percentMar = new ArrayList<BigDecimal>();
		HashMap<String, BigDecimal> mapMar = new HashMap<>();
		for (Ua marco : listaItensVenda) {

			System.out.println("NumeroUA: " + marco.getNumeroUa() + " Mes: Março " + " Vazao: " + marco.getMar());
			BigDecimal media = new BigDecimal(String.valueOf(posicaoMar)).divide(qtdBigDec, 2, RoundingMode.DOWN);
			percentMar.add(media);
			mapMar.merge(String.valueOf(media), new BigDecimal(String.valueOf(marco.getMar())), BigDecimal::add);

			System.out.println("TAMANHO DA LISTA: " + qtdBigDec);
			System.out.println("MEDIA : " + media + " POSICAO " + posicaoFev);
			System.out.println("--------------------------------------------");
			posicaoFev++;

		}
		System.out.println("--------------------------------------------");
		// Trabalhando com valores HashMap
				System.out.println("HashMap - 0.33 : " + mapMar.get("0.33"));
				System.out.println("HashMap - 0.66 : " + mapMar.get("0.66"));
				System.out.println("HashMap - 1.00 : " + mapMar.get("1.00"));

				System.out.println("--------------------------------------------");
				System.out.println("Percent Fev");
				percentMar.forEach(media -> System.out.println(media));
				System.out.println("--------------------------------------------");
				System.out.println("INTERPOLAÇÃO!");
				
				Set<String> chavesMar = mapMar.keySet();
				
				//Achar maior valor fevX2
				BigDecimal marX2 = BigDecimal.ZERO;
				for(BigDecimal valor : percentMar){
					
					if(valor.compareTo(z) == 1){
						
						marX2 = valor;
						break;
					   }
					}
				//Achar menor valor fevY2		
				BigDecimal marY2 = BigDecimal.ZERO;
				for (String c : chavesFev){
					if(mapMar.get(c) == mapMar.get(String.valueOf(marX2))){
						marY2 = mapMar.get(c);
						System.out.println("OOOOOFEV Y2: "+marX2);
						
					}					
				}
				//Achar menor valor fevX1
				BigDecimal marX1 = BigDecimal.ZERO;
				for (int i = percentFev.size()-1; i>-1; i--){
					BigDecimal valor = percentMar.get(i);
					if(valor.compareTo(z)==-1){
						marX1 = valor;
						break;
					}
				}
				
				//Achar maior valor fevY1
				BigDecimal marY1 = BigDecimal.ZERO;
				for(String c : chavesMar){
					if(mapMar.get(c)==mapMar.get(String.valueOf(marX1))){
						fevY1=mapMar.get(c);
						System.out.println("OOOOOFevY1: "+marY1);
					}
				}
				
				System.out.println("--------------------------------------------");
				System.out.println("PONTOS DE REFERENCIA PARA INTERPOLAR");
				System.out.println("FevX1: " + marX1);
				System.out.println("FevX2: " + marX2);
				System.out.println("FevZ: " + z);
				System.out.println("FevY1: " + marY1);
				System.out.println("FevY2: " + marY2);
				System.out.println("--------------------------------------------");
				
				Interpolacao interpolarMar = new Interpolacao();
				System.out.println("INTERPOLACAO FEV: " + interpolarMar.calcular(marX1, marX2, z, marY1, marY2));
				System.out.println("--------------------------------------------");
				//FIM DE MARÇO
				

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
		for (Ua abril : listaItensVenda) {

			System.out.println("NumeroUA: " + abril.getNumeroUa() + " Mes: Abril " + " Vazao: " + abril.getAbr());

			// double abr = abril.getAbr();
			double media = (posicaoAbr / quantidade);

			System.out.println("TAMANHO DA LISTA: " + quantidade);
			System.out.println("MEDIA : " + media + " POSICAO " + posicaoAbr);
			System.out.println("--------------------------------------------");
			posicaoAbr++;
		}

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

		for (Ua maio : listaItensVenda) {

			System.out.println("NumeroUA: " + maio.getNumeroUa() + " Mes: Maio " + " Vazao: " + maio.getMai());

			// double mai = maio.getMai();
			double media = (posicaoMai / quantidade);

			System.out.println("TAMANHO DA LISTA: " + quantidade);
			System.out.println("MEDIA : " + media + " POSICAO " + posicaoMai);
			System.out.println("--------------------------------------------");
			posicaoMai++;
		}

		// Ordenação Junho
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
		for (Ua junho : listaItensVenda) {

			System.out.println("NumeroUA: " + junho.getNumeroUa() + " Mes: Junho " + " Vazao: " + junho.getJun());

			// double jun = junho.getJun();
			double media = (posicaoJun / quantidade);

			System.out.println("TAMANHO DA LISTA: " + quantidade);
			System.out.println("MEDIA : " + media + " POSICAO " + posicaoJun);
			System.out.println("--------------------------------------------");
			posicaoJun++;
		}

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
		for (Ua julho : listaItensVenda) {

			System.out.println("NumeroUA: " + julho.getNumeroUa() + " Mes: Julho " + " Vazao: " + julho.getJul());

			// double jul = julho.getJul();
			double media = (posicaoJul / quantidade);

			System.out.println("TAMANHO DA LISTA: " + quantidade);
			System.out.println("MEDIA : " + media + " POSICAO " + posicaoJul);
			System.out.println("--------------------------------------------");
			posicaoJul++;
		}

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
		for (Ua agosto : listaItensVenda) {

			System.out.println("NumeroUA: " + agosto.getNumeroUa() + " Mes: Agosto " + " Vazao: " + agosto.getAgo());

			// double ago = agosto.getAgo();
			double media = (posicaoAgo / quantidade);

			System.out.println("TAMANHO DA LISTA: " + quantidade);
			System.out.println("MEDIA : " + media + " POSICAO " + posicaoAgo);
			System.out.println("--------------------------------------------");
			posicaoAgo++;
		}

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
		for (Ua setembro : listaItensVenda) {

			System.out.println(
					"NumeroUA: " + setembro.getNumeroUa() + " Mes: Setembro " + " Vazao: " + setembro.getSet());

			// double set = setembro.getSet();
			double media = (posicaoSet / quantidade);

			System.out.println("TAMANHO DA LISTA: " + quantidade);
			System.out.println("MEDIA : " + media + " POSICAO " + posicaoSet);
			System.out.println("--------------------------------------------");
			posicaoSet++;
		}
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
		for (Ua outubro : listaItensVenda) {

			System.out.println("NumeroUA: " + outubro.getNumeroUa() + " Mes: Outubro " + " Vazao: " + outubro.getOut());

			// double out = outubro.getOut();
			double media = (posicaoOut / quantidade);

			System.out.println("TAMANHO DA LISTA: " + quantidade);
			System.out.println("MEDIA : " + media + " POSICAO " + posicaoOut);
			System.out.println("--------------------------------------------");
			posicaoOut++;
		}

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
		for (Ua novembro : listaItensVenda) {

			System.out.println(
					"NumeroUA: " + novembro.getNumeroUa() + " Mes: Novembro " + " Vazao: " + novembro.getNov());

			// double nov = novembro.getNov();
			double media = (posicaoNov / quantidade);

			System.out.println("TAMANHO DA LISTA: " + quantidade);
			System.out.println("MEDIA : " + media + " POSICAO " + posicaoNov);
			System.out.println("--------------------------------------------");
			posicaoNov++;
		}

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
		double posicaoDez = 1;
		for (Ua dezembro : listaItensVenda) {

			System.out.println(
					"NumeroUA: " + dezembro.getNumeroUa() + " Mes: Dezembro " + " Vazao: " + dezembro.getDez());

			// double dez = dezembro.getDez();
			double media = (posicaoDez / quantidade);

			System.out.println("TAMANHO DA LISTA: " + quantidade);
			System.out.println("MEDIA : " + media + " POSICAO " + posicaoDez);
			System.out.println("--------------------------------------------");
			posicaoDez++;
		}
	}

}
