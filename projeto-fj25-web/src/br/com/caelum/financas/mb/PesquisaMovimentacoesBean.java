package br.com.caelum.financas.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

@ManagedBean
public class PesquisaMovimentacoesBean {

	@ManagedProperty(name = "em", value = "#{requestScope.em}")
	private EntityManager em;
	private Conta conta = new Conta();
	private Integer mes;
	private TipoMovimentacao tipo;
	private List<Movimentacao> movs;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void pesquisa() {
		MovimentacaoDAO md = new MovimentacaoDAO(em);
		movs = md.pesquisa(getConta(), tipo, getMes());
	}

	public List<Movimentacao> getMovimentacoes() {
		return movs;
	}

	public Conta getConta() {
		if(conta.getId()!=null && conta.getId()==0) {
			conta.setId(null);
		}
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Integer getMes() {	
		if(mes!=null && mes==0) {
			mes=null;
		}
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipo;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipo = tipo;
	}

}
