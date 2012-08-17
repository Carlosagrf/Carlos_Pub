package br.com.caelum.financas.mb;

import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.dao.TagDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.Tag;
import br.com.caelum.financas.modelo.TipoMovimentacao;


@ManagedBean
public class MovimentacoesBean {
	private List<Movimentacao> movs;
	private Movimentacao mov = new Movimentacao();
	private Integer contaId;
	private String tags;
	
	@ManagedProperty(name="em",value="#{requestScope.em}")
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	public void grava() {
		ContaDAO cd = new ContaDAO(em);
        MovimentacaoDAO md = new MovimentacaoDAO(em);
        Conta contaDaMovimentacao = cd.busca(contaId);
        
        mov.setConta(contaDaMovimentacao);
        gravaEAssociaAsTags(em);
        md.adiciona(mov);
        
        this.movs = md.lista();
                
        limpaFormularioDoJSF(); 
	}
	

	public void remove() {
		ContaDAO cd = new ContaDAO(em);
        MovimentacaoDAO md = new MovimentacaoDAO(em);
        Conta contaDaMovimentacao = cd.busca(contaId);
        
        mov.setConta(contaDaMovimentacao);
        md.remove(mov);
        
        limpaFormularioDoJSF();
	}

	public List<Movimentacao> getMovimentacoes() {
		if(movs == null) {
			MovimentacaoDAO md = new MovimentacaoDAO(em);
			movs = md.lista();
		}
		return movs;
	}
	
	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	

	public Movimentacao getMovimentacao() {
		if(mov.getData()==null) {
			mov.setData(Calendar.getInstance());
		}
		return mov;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.mov = movimentacao;
	}

	public Integer getContaId() {
		return contaId;
	}

	public void setContaId(Integer contaId) {
		this.contaId = contaId;
	}

	private void limpaFormularioDoJSF() {
		this.mov = new Movimentacao();
		this.tags = null;
	}

	public TipoMovimentacao[] getTiposDeMovimentacao() {
		return TipoMovimentacao.values();
	}
	
	private void gravaEAssociaAsTags(EntityManager em) {
		String[] nomeDasTags = this.tags.split(" ");
		TagDAO td = new TagDAO(em);
		
		for(String nome: nomeDasTags) {
			Tag tag = td.adicionaOuBuscaTagComNome(nome);
			mov.getTags().add(tag);			
		}
	}
	
}
