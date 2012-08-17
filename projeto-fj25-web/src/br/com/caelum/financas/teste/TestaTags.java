package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.Tag;

public class TestaTags {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		Movimentacao mov = em.find(Movimentacao.class, 21);
		
		for (Tag tag : mov.getTags()) {
			JOptionPane.showMessageDialog(null, tag.getNome());
		}
	}

}
