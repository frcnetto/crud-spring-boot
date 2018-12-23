package com.frcnetto.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frcnetto.curso.boot.dao.DepartamentoDAO;
import com.frcnetto.curso.boot.domain.Departamento;

@Service @Transactional
public class DepartamentoServiceImpl implements DepartamentoService{
	
	@Autowired
	private DepartamentoDAO dao;

	@Override
	public void salvar(Departamento departamento) {
		dao.save(departamento);
	}

	@Override
	public void editar(Departamento departamento) {
		dao.update(departamento);
	}

	@Override
	public void excluir(Long primaryKey) {
		dao.delete(primaryKey);
	}

	@Override @Transactional(readOnly = true)
	public Departamento buscarPorId(Long primaryKey) {
		return dao.find(primaryKey);
	}

	@Override @Transactional(readOnly = true)
	public List<Departamento> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean temCargos(Long primaryKey) {
		return buscarPorId(primaryKey).getCargos().isEmpty() ? false : true;
	}

}
