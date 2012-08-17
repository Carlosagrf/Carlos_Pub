package br.com.caelum.financas.actions;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Movimentacao;

public class BuscaContaDaMovimentacao {
	public static void main(String[] args) {
		@SuppressWarnings("static-access")
		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDAO md = new MovimentacaoDAO(em);
				
		Integer id = new Integer(JOptionPane.showInputDialog("Digite o id do titular"));
		Movimentacao mov = md.busca(id); 
		
		System.out.println(mov.getConta().getTitular());
	}

}
