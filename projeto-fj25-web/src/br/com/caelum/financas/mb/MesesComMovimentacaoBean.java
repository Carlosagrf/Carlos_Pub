package br.com.caelum.financas.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.modelo.ValorPorMes;

@ManagedBean
public class MesesComMovimentacaoBean {

	private final Conta conta = new Conta();

	private TipoMovimentacao tipo;
	
	@ManagedProperty(name="em",value="#{requestScope.em}")
	private EntityManager em;
	private List<ValorPorMes> valoresPorMes;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

	public List<ValorPorMes> lista() {
		MovimentacaoDAO md = new MovimentacaoDAO(em);
		valoresPorMes = md.listaMesesComMovimentacoes(conta, tipo);
		
		return valoresPorMes;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipo;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipo) {
		this.tipo = tipo;
	}

	public Conta getConta() {
		return conta;
	}
	
	public List<ValorPorMes> getValoresPorMes() {
		return valoresPorMes;
	}

}
