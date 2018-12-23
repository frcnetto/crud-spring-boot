package com.frcnetto.curso.boot.service;

import java.util.List;

import com.frcnetto.curso.boot.domain.Funcionario;

public interface FuncionarioService {
	
	void salvar(Funcionario funcionario);
	void editar(Funcionario funcionario);
	void excluir(Long primaryKey);
	Funcionario buscarPorId(Long primaryKey);
	List<Funcionario> buscarTodos();

}
