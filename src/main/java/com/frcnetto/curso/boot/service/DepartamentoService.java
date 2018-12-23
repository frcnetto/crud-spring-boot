package com.frcnetto.curso.boot.service;

import java.util.List;

import com.frcnetto.curso.boot.domain.Departamento;

public interface DepartamentoService {
	
	void salvar(Departamento departamento);
	void editar(Departamento departamento);
	void excluir(Long primaryKey);
	Departamento buscarPorId(Long primaryKey);
	List<Departamento> buscarTodos();
	boolean temCargos(Long primaryKey);

}
