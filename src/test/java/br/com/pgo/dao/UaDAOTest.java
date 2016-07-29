package br.com.pgo.dao;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.pgo.domain.Ua;

public class UaDAOTest {

	@Test
	// Ignore
	public void salvar() {

		Ua cadastrarUa = new Ua();
		cadastrarUa.setNumeroUa(900);
		cadastrarUa.setAno(2086);
		//cadastrarUa.setJan(10.0);
		//cadastrarUa.setFev(10.090);
		//cadastrarUa.setMar(20.879);
		//cadastrarUa.setAbr(90.00);
		//cadastrarUa.setMai(10.99787);
		//cadastrarUa.setJun(09.99);
		//cadastrarUa.setJul(15.98);
		//cadastrarUa.setAgo(10.876);
		//cadastrarUa.setSet(30.857);
		//cadastrarUa.setOut(10.758);
		//cadastrarUa.setNov(10.876);
		//cadastrarUa.setDez(80.534);

		UaDAO cadastrarUaDAO = new UaDAO();

		cadastrarUaDAO.salvar(cadastrarUa);

	}

	@Test
	@Ignore
	public void listar() {

		UaDAO listarUA = new UaDAO();
		List<Ua> resultado = listarUA.listar();

		for (Ua ua : resultado) {
			System.out.println(ua.getJan());
			System.out.println(ua.getFev());
			System.out.println(ua.getMar());
			System.out.println(ua.getAbr());
			System.out.println(ua.getAno());

		}

	}

	@Test
	@Ignore
	public void buscar() {

		Long codigo = 1L;

		UaDAO BuscarUA = new UaDAO();
		Ua ua = BuscarUA.buscar(codigo);

		if (ua == null) {
			System.out.println("Nenhum registro encontrado");
		} else {

			System.out.println(ua.getCodigo());
			System.out.println(ua.getJan());
			System.out.println(ua.getFev());
			System.out.println(ua.getMar());
			System.out.println(ua.getAbr());
			System.out.println(ua.getAno());
		}

	}

	@Test
	@Ignore
	public void excluir() {

		Long codigo = 5L;
		UaDAO uaDAO = new UaDAO();
		Ua ua = uaDAO.buscar(codigo);

		if (ua == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			uaDAO.excluir(ua);

			System.out.println("Excluido com sucesso!");
		}
	}

	@Test
	@Ignore
	public void atualizar() {

		Long codigo = 10L;
		UaDAO uaDAO = new UaDAO();
		Ua ua = uaDAO.buscar(codigo);
		if (ua == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			ua.setAno(2080);
			uaDAO.editar(ua);
		}

	}
}
