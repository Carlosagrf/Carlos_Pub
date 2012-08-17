package br.com.caelum.financas.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.modelo.ValorPorMes;

public class DAO<T> {

	private final Class<T> classe;
	private final EntityManager em;

	public DAO(EntityManager em, Class<T> classe) {
		this.em = em;
		this.classe = classe;

	}
	
	public void adiciona(T t) {
		this.em.persist(t);
	}
	
	public void remove(T t) {
		this.em.remove(t);
	}
	
	public T busca(Integer id) {
		return this.em.find(classe,id);
	}

	public void altera(T t) {
		em.merge(t);
	}
		
	@SuppressWarnings("unchecked")
	public List<T> lista() {
		Query query = this.em.createQuery("from "+classe.getName());
		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listaPorTipo(BigDecimal valor, TipoMovimentacao tipo) {
		String jpql = "from " +classe.getName() + " where valor <= " + valor 
				+ " and tipoMovimentacao = '" + tipo + "'";
		
		Query query = this.em.createQuery(jpql);
		
		return query.getResultList();		
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listaAPorraToda(Conta conta) {
		String jpql = "from " + classe.getName() +  " m where m.conta = " + conta.getId()
				+ " order by m.valor desc";
				
		Query query = this.em.createQuery(jpql);
		
		return query.getResultList();		
	}
	
	public BigDecimal calcula(Conta conta, TipoMovimentacao tipo) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> cq = cb.createQuery(BigDecimal.class);
		Root<Movimentacao> root = cq.from(Movimentacao.class);
		cq.select(cb.sum(root.<BigDecimal>get("valor")));
		cq.where(cb.equal(root.<Conta>get("conta"), conta));
		 		
		return this.em.createQuery(cq).getSingleResult();
//		String jpql = "select sum(m.valor) from " + classe.getName() + " m where m.conta = " + conta.getId() 
//				+ " and m.tipoMovimentacao = '" + tipo + "'";
//		
//		TypedQuery<BigDecimal> query = this.em.createQuery(jpql, BigDecimal.class);
//		
//		return query.getSingleResult();		
	}
	
	@SuppressWarnings("unchecked")
	public List<Movimentacao> buscaPorTitular(String titular) {
		String jpql = "from " + classe.getName() + " m where conta.titular like '%" + titular + "%' ";
		
		Query query = this.em.createQuery(jpql);
				
		return query.getResultList();		
	}
	
	@SuppressWarnings("unchecked")
	public List<ValorPorMes> listaMesesComMovimentacoes(Conta conta, TipoMovimentacao tipo) {
		String jpql = "select new br.com.caelum.financas.modelo.ValorPorMes (month(m.data), sum(m.valor)) from " + classe.getName() + " m " 
				+ "group by month(m.data), m.conta, m.tipoMovimentacao having m.conta = " + conta.getId() + " and " 
				+ "m.tipoMovimentacao = '" + tipo + "' order by sum(m.valor) desc";
		
		Query query = this.em.createQuery(jpql);
		
		
		return query.getResultList();
	}
	
}