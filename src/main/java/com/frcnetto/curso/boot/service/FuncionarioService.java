package com.frcnetto.curso.boot.service;

import java.time.LocalDate;
import java.util.List;

import com.frcnetto.curso.boot.domain.Funcionario;

public interface FuncionarioService {
	
	void salvar(Funcionario funcionario);
	void editar(Funcionario funcionario);
	void excluir(Long primaryKey);
	Funcionario buscarPorId(Long primaryKey);
	List<Funcionario> buscarTodos();
	List<Funcionario> buscaPorNome( String nome );
	List<Funcionario> buscarPorCargo( Long id );
	List<Funcionario> buscarPorDatas( LocalDate entrada, LocalDate saida );

}
