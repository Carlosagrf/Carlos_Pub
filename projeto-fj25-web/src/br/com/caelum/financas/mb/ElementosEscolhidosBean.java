package br.com.caelum.financas.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import br.com.caelum.financas.infra.search.ElementoDaBusca;

@ManagedBean
public class ElementosEscolhidosBean {
	private List<ElementoDaBusca> elementos = new ArrayList<ElementoDaBusca>();
	
	@ManagedProperty(name="em", value="#{requestScope.em}")
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
		
	public void adiciona(ElementoDaBusca elemento) {
		this.elementos.add(elemento);
	}
	
	public void limpa() {
		this.elementos.clear();
	}
	
	public List<ElementoDaBusca> getElementos() {
		return elementos;
	}

	public void desfazUltima() {
		if (!this.elementos.isEmpty()) {
			this.elementos.remove(elementos.size()-1);
		}
	}
}
