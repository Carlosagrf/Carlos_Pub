package br.com.caelum.financas.actions;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class PesquisaPorId {
	public static void main(String[] args) {
		@SuppressWarnings("static-access")
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO cd = new ContaDAO(em);
		em.getTransaction().begin();
		
		String ids = JOptionPane.showInputDialog("Digite o id para pesquisa.");
		Integer id = Integer.parseInt(ids);
		
		Conta c = cd.busca(id);
		JOptionPane.showMessageDialog(null, c.getTitular(), "Nome do Titular", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, c.getBanco(), "Banco", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, c.getAgencia(), "Agência", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, c.getNumero(), "Número", JOptionPane.INFORMATION_MESSAGE);
		
		em.getTransaction().commit();
		em.close();
	}

}
