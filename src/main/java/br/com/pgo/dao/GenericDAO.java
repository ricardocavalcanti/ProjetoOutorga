package br.com.pgo.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import br.com.pgo.util.HibernateUtil;

public class GenericDAO<Entidade> {

	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null)
				transacao.rollback();
			throw erro;

		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;

		} catch (RuntimeException erro) {

			throw erro;

		} finally {
			sessao.close();
		}

	}
	
	@SuppressWarnings("unchecked")//Ordenação crescente
	public List<Entidade> listar(String campoOrdenação) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = sessao.createCriteria(classe);
			consulta.addOrder(Order.asc(campoOrdenação));
			List<Entidade> resultado = consulta.list();
			return resultado;

		} catch (RuntimeException erro) {

			throw erro;

		} finally {
			sessao.close();
		}

	}

	@SuppressWarnings("unchecked")
	public Entidade buscar(Long codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria busca = sessao.createCriteria(classe);
			busca.add(Restrictions.idEq(codigo));
			Entidade resultado = (Entidade) busca.uniqueResult();
			return resultado;
		} catch (RuntimeException erro) {

			throw erro;
		} finally {
			sessao.close();
		}

	}

	public void excluir(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null)
				transacao.rollback();
			throw erro;

		} finally {
			sessao.close();
		}
	}

	public void editar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			if (transacao != null)
				transacao.rollback();
			throw erro;

		} finally {
			sessao.close();
		}
	}

	// Metódo merge procura e altera o elmento indicado
	public void merge(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.merge(entidade);
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
}
