package br.com.caelum.financas.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Movimentacao;

@ManagedBean
public class MovimentacoesPorTitularBean {

	private List<Movimentacao> movs;
	private String titular;
	@ManagedProperty(name="em",value="#{requestScope.em}")
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

	public List<Movimentacao> lista() {
		MovimentacaoDAO md = new MovimentacaoDAO(em);
		movs = md.buscaPorTitular(titular);
		
		return movs;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movs;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

}
