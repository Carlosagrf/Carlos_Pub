package br.com.caelum.financas.mb;

import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

@ManagedBean
public class MovimentacoesPorValorETipoBean {
	private List<Movimentacao> movs;
	private BigDecimal valor;
	private TipoMovimentacao tipoMovimentacao;
	@ManagedProperty(name="em",value="#{requestScope.em}")
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

	public List<Movimentacao> lista() {
		MovimentacaoDAO md = new MovimentacaoDAO(em);
		movs = md.listaPorValorETipo(valor, tipoMovimentacao);
		
		return movs;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movs;
	}

}
