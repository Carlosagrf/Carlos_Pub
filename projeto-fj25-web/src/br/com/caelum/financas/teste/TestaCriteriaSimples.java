package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Movimentacao;

public class TestaCriteriaSimples {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		MovimentacaoDAO md = new MovimentacaoDAO(em);
		List<Movimentacao> movs = md.todasComCriteria();
		for (Movimentacao mov : movs) {
			System.out.println(mov.getDescricao());
			System.out.println(mov.getValor());
			System.out.println("##########################");
		}

	}

}
