package br.com.pgo.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.pgo.domain.Outorgante;
import br.com.pgo.domain.Ua;

public class OutorganteDAOTest {

	@Test
	// @Ignore
	public void salvar() throws ParseException {

		UaDAO uaDAO = new UaDAO();
		Ua numeroUa = uaDAO.buscar(3L);
		Outorgante outorgante = new Outorgante();

		outorgante.setDemandaPontual(8888.88);
		outorgante.setLiberado(true);
		outorgante.setNumeroUa(numeroUa);
		outorgante.setProcesso(600);
		outorgante.setVencimento(new SimpleDateFormat("dd/MM/yyy").parse("28/11/2016")); //Inserir a data manual

		OutorganteDAO outorganteDAO = new OutorganteDAO();
		outorganteDAO.salvar(outorgante);

		System.out.println("Outorgante salvo com sucesso!");
	}

	@Test
	@Ignore
	public void listar() {

		OutorganteDAO outorganteDAO = new OutorganteDAO();

		List<Outorgante> resultado = outorganteDAO.listar();

		for (Outorgante outorgante : resultado) {

			System.out.println("Demanda Pontual: " + outorgante.getDemandaPontual());
			System.out.println("Processo: " + outorgante.getProcesso());
			System.out.println("Codigo: " + outorgante.getCodigo());
			System.out.println("Liberado: " + outorgante.getLiberado());
			System.out.println("Numero UA: " + outorgante.getNumeroUa().getNumeroUa());
			System.out.println("Vencimento: " + outorgante.getVencimento());
			System.out.println("--------------------------------------");
		}

	}

	@Test
	@Ignore
	public void buscar() {

		OutorganteDAO outorganteDAO = new OutorganteDAO();
		Long codigo = 5L;
		Outorgante outorgante = outorganteDAO.buscar(codigo);

		if (outorgante == null) {
			System.out.println("Outorgante não encontrado!");
		} else {

			System.out.println("Demanda Pontual: " + outorgante.getDemandaPontual());
			System.out.println("Processo: " + outorgante.getProcesso());
			System.out.println("Codigo: " + outorgante.getCodigo());
			System.out.println("Liberado: " + outorgante.getLiberado());
			System.out.println("Numero UA: " + outorgante.getNumeroUa().getNumeroUa());
			System.out.println("Vencimento: " + outorgante.getVencimento());
			System.out.println("--------------------------------------");

		}

	}

	@Test
	@Ignore
	public void excluir() {

		Long codigo = 5L;
		OutorganteDAO outorganteDAO = new OutorganteDAO();
		Outorgante outorgante = outorganteDAO.buscar(codigo);

		if (outorgante == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			outorganteDAO.excluir(outorgante);

			System.out.println("Excluido com sucesso!");
		}
	}

	@Test
	@Ignore
	public void atualizar() {

		OutorganteDAO outorganteDAO = new OutorganteDAO();
		Long codigo = 4L;
		Outorgante outorgante = outorganteDAO.buscar(codigo);

		if (outorgante == null) {
			System.out.println("Outorgante não encontrado");
		} else {

			outorgante.setDemandaPontual(198700.00);
			outorganteDAO.editar(outorgante);
			System.out.println("Atualizado com sucesso!");
		}

	}

}
