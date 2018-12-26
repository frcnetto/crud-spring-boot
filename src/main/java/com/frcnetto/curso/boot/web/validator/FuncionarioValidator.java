package com.frcnetto.curso.boot.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.frcnetto.curso.boot.domain.Funcionario;

public class FuncionarioValidator implements Validator {

	@Override
	public boolean supports( Class< ? > clazz ) {
		return Funcionario.class.equals( clazz );
	}

	@Override
	public void validate( Object target, Errors errors ) {

		Funcionario funcionario = ( Funcionario ) target;

		if ( funcionario.getDataSaida() != null && funcionario.getDataSaida().isBefore( funcionario.getDataEntrada() ) )
			errors.rejectValue( "dataSaida", "PosteriorDataEntrada.funcionario.dataSaida" );

	}

}
