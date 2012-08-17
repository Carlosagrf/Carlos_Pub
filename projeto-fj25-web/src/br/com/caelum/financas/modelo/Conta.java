package br.com.caelum.financas.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import br.com.caelum.financas.validator.PossuiNumeroEAgencia;

@PossuiNumeroEAgencia
@Entity
public class Conta {

	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToMany(mappedBy="conta")
	private List<Movimentacao> movs;
	
	@NotBlank
	@Length(min = 10, message = "Digite o seu nome completo")
	private String titular;
	private String agencia;
	private String numero;
	private String banco;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public List<Movimentacao> getMovs() {
		return movs;
	}

	public void setMovs(List<Movimentacao> movs) {
		this.movs = movs;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

}
