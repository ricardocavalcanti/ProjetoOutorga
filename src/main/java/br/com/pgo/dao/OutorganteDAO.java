package br.com.pgo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.pgo.domain.Outorgante;
import br.com.pgo.util.HibernateUtil;

public class OutorganteDAO extends GenericDAO<Outorgante> {
	
	@SuppressWarnings("unchecked")//Ordenação crescente
	public List<Outorgante> listarOrdenado() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = sessao.createCriteria(Outorgante.class);
			consulta.createAlias("usuario", "u");
			consulta.addOrder(Order.asc("u.nomeRazao"));
			List<Outorgante> resultado = consulta.list();
			return resultado;

		} catch (RuntimeException erro) {

			throw erro;

		} finally {
			sessao.close();
		}

	}

}
