package com.frcnetto.curso.boot.service;

import java.util.List;

import com.frcnetto.curso.boot.domain.Cargo;

public interface CargoService {
	
	void salvar(Cargo cargo);
	void editar(Cargo cargo);
	void excluir(Long primaryKey);
	Cargo buscarPorId(Long primaryKey);
	List<Cargo> buscarTodos();
	boolean temFuncionarios( Long primaryKey );

}
