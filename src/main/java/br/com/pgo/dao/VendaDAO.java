package br.com.pgo.dao;
import java.util.HashSet;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import br.com.pgo.domain.Ua;
import br.com.pgo.domain.Venda;
import br.com.pgo.util.HibernateUtil;

public class VendaDAO extends GenericDAO<Venda> {

	//Buscar Ua pelo número informado
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
	
	//Listar venda
	@SuppressWarnings("unchecked")
	public HashSet<Venda> listarVenda() {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			Criteria consulta = sessao.createCriteria(Venda.class);
			List <Venda> resultadoList = consulta.list();
			HashSet<Venda> resultado = new HashSet<>();
			
			for(Venda venda: resultadoList){
				resultado.add(venda);
			}			
			return resultado;

		} catch (RuntimeException erro) {

			throw erro;

		} finally {
			sessao.close();
		} 

	}
	
	 /*   //Buscar Processo Montante pelo número informado
		@SuppressWarnings("unchecked")
		public List<Ua> buscarProcessoMontante(int numeroProcessoMontante) {
			Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

			try {

				Query consulta = sessao.createQuery("from Ua where numeroUa=?");
				consulta.setParameter(0, numeroProcessoMontante);
				List<Ua> resultado = consulta.list();
				return resultado;

			} catch (RuntimeException erro) {

				throw erro;

			} finally {
				sessao.close();
			}
		}
		
		//Buscar Processo Jusante pelo número informado
		@SuppressWarnings("unchecked")
		public List<Ua> buscarProcessoJusante(int numeroProcessoJusante) {
					Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

				try {

					Query consulta = sessao.createQuery("from Ua where numeroUa=?");
					consulta.setParameter(0, numeroProcessoJusante);
					List<Ua> resultado = consulta.list();
					return resultado;

				} catch (RuntimeException erro) {

					throw erro;

				} finally {
					sessao.close();
				}
			}
	
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
	public void mergeVenda(Venda venda) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			
			transacao = sessao.beginTransaction();
			sessao.merge(venda);
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
	
	
	*/
	
	
	
	
}

