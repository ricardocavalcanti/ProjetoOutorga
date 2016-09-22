package br.com.pgo.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
	
	public Venda buscarProcessoApac (int processo){
		 
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try{

		Criteria busca = sessao.createCriteria(Venda.class);
		busca.add(Restrictions.idEq(processo)).createAlias("processo", "p").add(Restrictions.like("p.processoApac", processo));
		Venda resultado = (Venda) busca.uniqueResult();
		return resultado;

		}catch (RuntimeException erro){

		throw(erro);

		}finally{

		sessao.close();


		}
	}    
	
	public Venda procurarProcesso(int processo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = sessao.createCriteria(Venda.class);
			consulta.createAlias("outorgante", "o");
			consulta.add(Restrictions.eq("o.processoApac", processo));   
			Venda resultado = (Venda) consulta.uniqueResult();
			return resultado;
			
		} catch (RuntimeException erro) {

			throw erro;

		} finally {
			sessao.close();
		}

	}
	
	@SuppressWarnings("unchecked")
	public HashSet<Venda> listarHashSet() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = sessao.createCriteria(Venda.class);
			HashSet<Venda> resultado = (HashSet<Venda>) consulta.list();
			return resultado;

		} catch (RuntimeException erro) {

			throw erro;

		} finally {
			sessao.close();
		}

	}
	public void mergeVenda(Iterator<Venda> atual) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.merge(atual);
			transacao.commit();
		} catch (RuntimeException erro) {

			if (transacao != null) {
				transacao.rollback();
				throw erro;

			}
		} finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public HashSet<Venda> listarVenda() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = sessao.createCriteria(Venda.class);
			HashSet<Venda> resultado = (HashSet<Venda>) consulta.list();
			return resultado;

		} catch (RuntimeException erro) {

			throw erro;

		} finally {
			sessao.close();
		}

	}
	
	
	
}

