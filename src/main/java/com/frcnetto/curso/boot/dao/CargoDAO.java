package com.frcnetto.curso.boot.dao;

import java.util.List;

import com.frcnetto.curso.boot.domain.Cargo;

public interface CargoDAO {

	void save(Cargo cargo);

	void update(Cargo cargo);

	void delete(Long primaryKey);

	Cargo find(Long primaryKey);

	List<Cargo> findAll();

}
