package br.com.caelum.financas.actions;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;


public class InsereConta {
	public static void main(String[] args) {
		
		@SuppressWarnings("static-access")
		EntityManager em = new JPAUtil().getEntityManager();
		
		ContaDAO cd = new ContaDAO(em);
		Conta t = new Conta();
		t.setTitular(JOptionPane.showInputDialog("Digite o seu nome"));
		t.setBanco(JOptionPane.showInputDialog("Digite o seu banco"));
		t.setAgencia(JOptionPane.showInputDialog("Digite a sua agencia"));
		t.setNumero(JOptionPane.showInputDialog("Digite o numero da sua conta"));
		em.getTransaction().begin();
		cd.adiciona(t);
		em.getTransaction().commit();
		em.close();
		
		JOptionPane.showMessageDialog(null, "sucess!!");
	}

}
