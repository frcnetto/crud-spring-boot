package com.frcnetto.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frcnetto.curso.boot.dao.CargoDAO;
import com.frcnetto.curso.boot.domain.Cargo;

@Service @Transactional
public class CargoServiceImpl implements CargoService{
	
	@Autowired
	private CargoDAO dao;

	@Override
	public void salvar(Cargo cargo) {
		dao.save(cargo);
	}

	@Override
	public void editar(Cargo cargo) {
		dao.update(cargo);
	}

	@Override
	public void excluir(Long primaryKey) {
		dao.delete(primaryKey);
	}

	@Override @Transactional(readOnly = true)
	public Cargo buscarPorId(Long primaryKey) {
		return dao.find(primaryKey);
	}

	@Override @Transactional(readOnly = true)
	public List<Cargo> buscarTodos() {
		return dao.findAll();
	}

}
