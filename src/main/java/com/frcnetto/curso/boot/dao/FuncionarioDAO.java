package com.frcnetto.curso.boot.dao;

import java.util.List;

import com.frcnetto.curso.boot.domain.Funcionario;

public interface FuncionarioDAO {

	void save(Funcionario funcionario);

	void update(Funcionario funcionario);

	void delete(Long primaryKey);

	Funcionario find(Long primaryKey);

	List<Funcionario> findAll();

}
