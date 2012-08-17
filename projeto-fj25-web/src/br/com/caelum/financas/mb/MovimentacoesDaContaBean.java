package br.com.caelum.financas.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;

@ManagedBean
public class MovimentacoesDaContaBean {
	private List<Movimentacao> movs;
	private Conta conta = new Conta();
	@ManagedProperty(name="em",value="#{requestScope.em}")
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

	public List<Movimentacao> lista() {
		MovimentacaoDAO md = new MovimentacaoDAO(em);
		movs = md.listaAPorraToda(conta);
		
		return movs;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movs;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}


}
