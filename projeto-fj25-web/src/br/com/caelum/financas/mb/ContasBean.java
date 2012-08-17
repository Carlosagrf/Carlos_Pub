package br.com.caelum.financas.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.modelo.Conta;



@ManagedBean
public class ContasBean {
	private Conta conta = new Conta();
	private List<Conta> contas;	

	@ManagedProperty(name="em", value="#{requestScope.em}")
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public void grava() {
        ContaDAO cd = new ContaDAO(em);
      
        cd.adiciona(conta);
        contas = cd.lista();
        
        if(conta.getId() == null) {
        	cd.adiciona(conta);
        } else {
        	cd.altera(conta);
        }
      
        limpaFormularioDoJSF();       
	}
	


	public void remove() {
		ContaDAO cd = new ContaDAO(em);
        Conta contaParaRemover = cd.busca(this.conta.getId());
        
        cd.remove(contaParaRemover);
        contas = cd.lista();
        
        limpaFormularioDoJSF();        	
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
	public List<Conta> getContas() {
        
        if(contas == null) {
        	ContaDAO cd = new ContaDAO(em);
        	contas = cd.lista();
        	
        }
		return contas;
	}
	
	private void limpaFormularioDoJSF() {
        this.conta = new Conta();
	}	
}
