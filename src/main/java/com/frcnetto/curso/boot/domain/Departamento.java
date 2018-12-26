package com.frcnetto.curso.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table( name = "DEPARTAMENTOS" )
public class Departamento extends AbstractEntity< Long > {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2911700883528798532L;

	@NotBlank( message = "Informe o nome do departamento" )
	@Size( min = 3, max = 60, message = "O nome do departamento deve ter entre {min} e {max}." )
	@Column( nullable = false, unique = true, length = 60 )
	private String nome;

	@OneToMany( mappedBy = "departamento" )
	private List< Cargo > cargos;

	public String getNome() {
		return nome;
	}

	public void setNome( String name ) {
		this.nome = name;
	}

	public List< Cargo > getCargos() {
		return cargos;
	}

	public void setCargos( List< Cargo > cargos ) {
		this.cargos = cargos;
	}

}
