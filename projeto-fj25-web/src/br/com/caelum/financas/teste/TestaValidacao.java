package br.com.caelum.financas.teste;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.ValidatorUtil;

public class TestaValidacao {
	public static void main(String[] args) {
		Validator validator = new ValidatorUtil().getValidator();
		
		Conta conta = new Conta();
		conta.setTitular("Teste");
		conta.setAgencia("Teste");
		
		Set<ConstraintViolation<Conta>> errors = validator.validate(conta);
		for (ConstraintViolation<Conta> erro : errors) {
			System.out.println(erro.getMessage());
		}

	}

}
