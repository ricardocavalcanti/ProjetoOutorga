package br.com.pgo.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.pgo.domain.Ua;

public class VendaDAOTest {

	
	
	@Test
	@Ignore
	public void buscar() {

		int numeroUa = 0;
		

		VendaDAO BuscarUA = new VendaDAO();
		List<Ua> lista = BuscarUA.buscarUa(numeroUa);

		if (lista.isEmpty()) {
			
			System.out.println("Nenhum registro encontrado");
			
		} else {
            int i=0;
			for (Ua ua : lista) {
				i++;
				
				
				System.out.println(ua.getNumeroUa());
				System.out.println("Ano da UA: "+ua.getAno());
				
			}
			System.out.println("Quantidade Ua encontrada: "+i);
		}

	}
	
}
