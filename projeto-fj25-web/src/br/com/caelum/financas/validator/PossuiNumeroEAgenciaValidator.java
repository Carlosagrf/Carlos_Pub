package br.com.caelum.financas.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.caelum.financas.modelo.Conta;

public class PossuiNumeroEAgenciaValidator implements ConstraintValidator<PossuiNumeroEAgencia, Conta>{

	@Override
	public void initialize(PossuiNumeroEAgencia pna) {
		
	}

	@Override
	public boolean isValid(Conta conta, ConstraintValidatorContext cvc) {
		if(conta == null) {
			return true;
		}
		return ! (conta.getAgencia() == null ^ conta.getNumero() == null);
	}
}
