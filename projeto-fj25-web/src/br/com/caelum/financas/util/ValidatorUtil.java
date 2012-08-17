package br.com.caelum.financas.util;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidatorUtil {
	private static ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
	
	public Validator getValidator() {
		return vf.getValidator();
	}
}
