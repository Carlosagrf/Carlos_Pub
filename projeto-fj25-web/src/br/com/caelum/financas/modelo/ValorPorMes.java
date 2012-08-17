package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.util.List;

public class ValorPorMes {
	int mes;
	BigDecimal valor;
	List<Integer> listmes;
		
	public ValorPorMes(int mes, BigDecimal valor) {
		super();
		this.mes = mes;
		this.valor = valor;
	}
	
	public int getMes() {
		return mes;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
