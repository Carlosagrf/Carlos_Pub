package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;

public class DAO<T> {
	private final EntityManager em;
	private final Class<T> classe;
		
	public DAO(EntityManager em, Class<T> classe) {
		this.em = em;
		this.classe = classe;
	}
	
	public T busca(Integer id) {
		return em.getReference(classe, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> lista() {
		return em.createQuery("from Conta" ).getResultList();
	}
	
	public void adiciona(Conta t) {
		this.em.persist(t);
	}
	
	public void adiciona(Movimentacao t) {
		this.em.persist(t);
	}
	
	public void exclui(Conta t) {
		this.em.remove(t);
	}
	
	public void exclui(Movimentacao t) {
		this.em.remove(t);
	}
	
}
