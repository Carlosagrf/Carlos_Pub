package br.com.caelum.financas.actions;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class AlteraConta {
	public static void main(String[] args) {
		@SuppressWarnings("static-access")
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO cd = new ContaDAO(em);
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		List<Conta> lista = cd.lista();
		for (Conta conta : lista) {
			System.out.println("Id: " + conta.getId());
			System.out.println("Nome: " + conta.getTitular());
		}
		
		System.out.println("");
		System.out.println("Digite o id da conta que deseja Alterar.");
		@SuppressWarnings("resource")
		Integer id = new Scanner(System.in).nextInt();
		
		Conta conta = cd.busca(id);
		
		System.out.println("Digite o novo nome.");
		@SuppressWarnings("resource")
		String new_name = new Scanner(System.in).nextLine();
		
		conta.setTitular(new_name);
		
		et.commit();
		em.close();
		
		System.out.println("Alterado com sucesso!");
	}

}
