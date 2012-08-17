package br.com.caelum.financas.actions;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class SalvaMovimentacaoComConta {
	public static void main(String[] args) {
		@SuppressWarnings("static-access")
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO cd = new ContaDAO(em);
		MovimentacaoDAO md = new MovimentacaoDAO(em);
		Integer id = null;
		Movimentacao mov = new Movimentacao();
		Conta new_conta = new Conta();
		
		em.getTransaction().begin();
		
		String resp = JOptionPane.showInputDialog("Deseja associar a movimenta��o a uma conta j� existente??(sim ou n�o)");
		
		if(resp.toLowerCase().equals("sim")) {
						
			List<Conta> lista = cd.lista();
			
			for (Conta conta : lista) {
				System.out.println("Id da Conta: " + conta.getId());
				System.out.println("Nome do Titular: " + conta.getTitular());
			}
			String ids = JOptionPane.showInputDialog("Digite o id da conta que deseja associar.");
			id = Integer.parseInt(ids);
			Conta conta = cd.busca(id);
			cd.adiciona(conta);
			mov.setConta(conta);
		} else {
			
			new_conta.setTitular(JOptionPane.showInputDialog(null,"Nome:"));
			new_conta.setBanco(JOptionPane.showInputDialog(null,"Banco:"));
			new_conta.setAgencia(JOptionPane.showInputDialog(null,"Ag�nica:"));
			new_conta.setNumero(JOptionPane.showInputDialog(null,"N�mero:"));
			cd.adiciona(new_conta);
			mov.setConta(new_conta);
		}
		
		
		mov.setDescricao(JOptionPane.showInputDialog(null,"Descri��o:"));
		mov.setData(Calendar.getInstance());
		BigDecimal valor = new BigDecimal(JOptionPane.showInputDialog("Valor:"));
		mov.setValor(valor);
		mov.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		
		md.adiciona(mov);
		
		em.getTransaction().commit();
		em.close();
		
		JOptionPane.showMessageDialog(null, "Sucess!");
		
	}

}
