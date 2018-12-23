package com.frcnetto.curso.boot.dao;

import java.util.List;

import com.frcnetto.curso.boot.domain.Departamento;

public interface DepartamentoDAO {

	void save(Departamento departamento);
	
	void update(Departamento departamento);
	
	void delete(Long primaryKey);
	
	Departamento find(Long primaryKey);
	
	List<Departamento> findAll();
	
}
