package br.com.caelum.financas.actions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class ListagemConta {

	public static void main(String[] args) {
		
		@SuppressWarnings("static-access")
		EntityManager em = new JPAUtil().getEntityManager();
		
		ContaDAO cd = new ContaDAO(em);
		
		List<Conta> lista = cd.lista();
		
		for (Conta conta : lista) {
			JOptionPane.showMessageDialog(null, conta.getTitular(), "Nome do Titular", JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null, conta.getBanco(), "Banco", JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null, conta.getAgencia(), "Agência", JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(null, conta.getNumero(), "Número", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
