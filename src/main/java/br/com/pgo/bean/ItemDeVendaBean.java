package br.com.pgo.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import br.com.pgo.dao.UaDAO;
import br.com.pgo.domain.ItemDeVenda;
import br.com.pgo.domain.Ua;
import br.com.pgo.util.Interpolar;

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

	public void calcular() {

		double quantidade = listaItensVenda.size();
		BigDecimal qtdBigDec = new BigDecimal(listaItensVenda.size());

		// Ordenação Janeiro
		Collections.sort(listaItensVenda, new Comparator<Ua>() {
			@Override
			public int compare(Ua ua1, Ua ua2) {

				if (ua1.getJan() < ua2.getJan()) {
					return 1;
				} else if (ua1.getJan() > ua2.getJan()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		
		int posicaoJan = 1; 
		double x1 = 0;
		double x2 = 0;
		
		double y1 = 0;
		double y2 = 0;

		// Adiconar os valores percentuais para fazer comparação
		List<BigDecimal> percentJan = new ArrayList<BigDecimal>();
		// Para imprimir valores
		for (Ua janeiro : listaItensVenda) {

			System.out.println("NumeroUA: " + janeiro.getNumeroUa() + " - Mes: Janeiro " + " - Vazao: " + janeiro.getJan());  
 
			// double jan = janeiro.getJan(); posicão / quantidade (3)
						
			BigDecimal media = new BigDecimal(posicaoJan).divide(qtdBigDec, 2, RoundingMode.DOWN);		 	
			percentJan.add(media);
			// x2 = media;
			System.out.println("TAMANHO DA LISTA: " + qtdBigDec);
			System.out.println("MEDIA : " + media + " POSICAO " + posicaoJan);
		
			posicaoJan++; 
		}
		System.out.println("--------------------------------------------");
		System.out.println("Percent Jan");
		
		percentJan.forEach(media->System.out.println(media));
		
		System.out.println("--------------------------------------------");

		System.out.println("HARD!");
		
		double menor = 0;
		double maior = 0;
		BigDecimal maiorBigDec = BigDecimal.ZERO;
		BigDecimal menorBigDec = BigDecimal.ZERO;

        int x = -1;
        double z = 0.8;        
        BigDecimal zBigDec = new BigDecimal("0.1");
		
		for (BigDecimal media : percentJan) {
			
			if (media.compareTo(zBigDec) == 1) {

				maiorBigDec = media;
				break;
			}
		}
		
		for (int i = percentJan.size() - 1; i > -1; i--) {
			
			BigDecimal mediaTemp = percentJan.get(i);					
			
			if (mediaTemp.compareTo(zBigDec) == -1) {

				menorBigDec = mediaTemp;
				break;
			}
		}

//		while (x < percentJan.size()) {
//			x++;
//			// achar o primeiro maior
//			if (z < percentJan.get(x)) {
//
//				maior = percentJan.get(x);
//				break;
//			}
//
//		}
//     
		System.out.println("--------------------------------------------");

		System.out.println("WHILE menor: !" + menorBigDec);
		System.out.println("WHILE maior: !" + maiorBigDec);
		System.out.println("--------------------------------------------");
                                                                               
		// Ordenação Fevereiro
		Collections.sort(listaItensVenda, new Comparator<Ua>() {
			@Override
			public int compare(Ua ua1, Ua ua2) {

				if (ua1.getFev() < ua2.getFev()) {
					return 1;
				} else if (ua1.getFev() > ua2.getFev()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		double posicaoFev = 1;
		for (Ua fevereiro : listaItensVenda) {

			System.out.println(
					"NumeroUA: " + fevereiro.getNumeroUa() + " Mes: Fevereiro " + " Vazao: " + fevereiro.getFev());

			// double fev = fevereiro.getFev();
			double media = (posicaoFev / quantidade);

			System.out.println("TAMANHO DA LISTA: " + quantidade);
			System.out.println("MEDIA : " + media + " POSICAO " + posicaoFev);
			System.out.println("--------------------------------------------");
			posicaoFev++;

		}

		// Ordenação Março
		Collections.sort(listaItensVenda, new Comparator<Ua>() {
			@Override
			public int compare(Ua ua1, Ua ua2) {

				if (ua1.getMar() < ua2.getMar()) {
					return 1;
				} else if (ua1.getMar() > ua2.getMar()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		double posicaoMar = 1;
		for (Ua marco : listaItensVenda) {

			System.out.println("NumeroUA: " + marco.getNumeroUa() + " Mes: Março " + " Vazao: " + marco.getMar());

			// double mar = marco.getMar();
			double media = (posicaoMar / quantidade);

			System.out.println("TAMANHO DA LISTA: " + quantidade);
			System.out.println("MEDIA : " + media + " POSICAO " + posicaoMar);
			System.out.println("--------------------------------------------");
			posicaoMar++;
		}

		// Ordenação Abril
		Collections.sort(listaItensVenda, new Comparator<Ua>() {
			@Override
			public int compare(Ua ua1, Ua ua2) {

				if (ua1.getAbr() < ua2.getAbr()) {
					return 1;
				} else if (ua1.getFev() > ua2.getFev()) {
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
		Collections.sort(listaItensVenda, new Comparator<Ua>() {
			@Override
			public int compare(Ua ua1, Ua ua2) {

				if (ua1.getMai() < ua2.getMai()) {
					return 1;
				} else if (ua1.getMai() > ua2.getMai()) {
					return -1;
				} else {
					return 0;
				}
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

				if (ua1.getJun() < ua2.getJun()) {
					return 1;
				} else if (ua1.getJun() > ua2.getJun()) {
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

				if (ua1.getJul() < ua2.getJul()) {
					return 1;
				} else if (ua1.getJul() > ua2.getJul()) {
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

				if (ua1.getAgo() < ua2.getAgo()) {
					return 1;
				} else if (ua1.getAgo() > ua2.getAgo()) {
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

				if (ua1.getSet() < ua2.getSet()) {
					return 1;
				} else if (ua1.getSet() > ua2.getSet()) {
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

				if (ua1.getOut() < ua2.getOut()) {
					return 1;
				} else if (ua1.getOut() > ua2.getOut()) {
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

				if (ua1.getNov() < ua2.getNov()) {
					return 1;
				} else if (ua1.getNov() > ua2.getNov()) {
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

				if (ua1.getDez() < ua2.getDez()) {
					return 1;
				} else if (ua1.getDez() > ua2.getDez()) {
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

	private BigDecimal newBigDecimal(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
