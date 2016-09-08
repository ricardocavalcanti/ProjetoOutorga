package br.com.pgo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;


import br.com.pgo.domain.Ua;
import br.com.pgo.domain.Venda;
import br.com.pgo.util.HibernateUtil;

public class VendaDAO extends GenericDAO<Venda> {

	@SuppressWarnings("unchecked")
	public List<Ua> buscarUa(int numeroUa) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {

			Query consulta = sessao.createQuery("from Ua where numeroUa=?");
			consulta.setParameter(0, numeroUa);
			List<Ua> resultado = consulta.list();
			return resultado;

		} catch (RuntimeException erro) {

			throw erro;

		} finally {
			sessao.close();
		}
	}

	
	/*public Venda buscarProcesso(Class processo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria busca = sessao.createCriteria(processo);
			busca.add(Restrictions.idEq(processo));
			Venda resultado = (Venda) busca.uniqueResult();
			return resultado;
		} catch (RuntimeException erro) {

			throw erro;
		} finally {
			sessao.close();
		}

	}*/
	
	
	public Venda buscarProcesso (int processo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {

			Query consulta = sessao.createQuery("from Venda v where v.outorgante.processoApac=?");
			consulta.setParameter(0, processo);
			Venda resultado = (Venda) consulta.uniqueResult();
			return resultado;

		} catch (RuntimeException erro) {

			throw erro;

		} finally {
			sessao.close();
		}
	}
	public void venda2(int venda){
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		 Criteria criteria = sessao.createCriteria(Venda.class);
		 List lista = criteria.list();
		
	}
	       
	
}

