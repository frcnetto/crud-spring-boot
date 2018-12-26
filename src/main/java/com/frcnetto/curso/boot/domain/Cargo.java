package com.frcnetto.curso.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CARGOS")
public class Cargo extends AbstractEntity<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3798711924322217822L;

	@NotBlank(message="Imforme o nome do cargo.")
	@Size( max = 60, message = "O nome do cargo deve ter no máximo {max} caracteres." )
	@Column(nullable = false, unique = true, length = 60)
	private String nome;
	
	@NotNull(message="O departamento é obrigatório.")
	@ManyToOne
	@JoinColumn(name = "id_departamento_fk")
	private Departamento departamento;
	
	@OneToMany(mappedBy = "cargo")
	private List<Funcionario> funcionarios;

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String name) {
		this.nome = name;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}
