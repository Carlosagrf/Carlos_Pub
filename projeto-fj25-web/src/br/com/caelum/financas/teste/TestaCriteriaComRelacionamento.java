package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;

public class TestaCriteriaComRelacionamento {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		MovimentacaoDAO md = new MovimentacaoDAO(em);
		BigDecimal soma = md.somaMovimentacoesDoTitular("Marcos");
		System.out.println(soma);

	}

}
