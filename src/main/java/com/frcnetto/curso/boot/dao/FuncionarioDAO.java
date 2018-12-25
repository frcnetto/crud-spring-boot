package com.frcnetto.curso.boot.dao;

import java.time.LocalDate;
import java.util.List;

import com.frcnetto.curso.boot.domain.Funcionario;

public interface FuncionarioDAO {

	void save(Funcionario funcionario);

	void update(Funcionario funcionario);

	void delete(Long primaryKey);

	Funcionario find(Long primaryKey);

	List<Funcionario> findAll();

	List< Funcionario > findByNome( String nome );

	List< Funcionario > findByCargoId( Long id );

	List< Funcionario > findByDataEntradaDataSaida( LocalDate entrada, LocalDate saida );

	List< Funcionario > findByDataEntrada( LocalDate entrada );

	List< Funcionario > findByDataSaida( LocalDate saida );

}
