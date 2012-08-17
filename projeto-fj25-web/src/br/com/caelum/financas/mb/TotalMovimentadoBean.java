package br.com.caelum.financas.mb;

import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

@ManagedBean
public class TotalMovimentadoBean {
	private BigDecimal total;
	private Conta conta = new Conta();
	private TipoMovimentacao tipo;
	@ManagedProperty(name="em",value="#{requestScope.em}")
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	

	public BigDecimal calcula() {
		MovimentacaoDAO md = new MovimentacaoDAO(em);
		total = md.calculaTotalMovimentado(conta, tipo);
		
		return total;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipo;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipo) {
		this.tipo = tipo;
	}

}
