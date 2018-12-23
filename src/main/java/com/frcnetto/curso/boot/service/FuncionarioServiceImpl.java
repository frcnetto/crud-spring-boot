package com.frcnetto.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frcnetto.curso.boot.dao.FuncionarioDAO;
import com.frcnetto.curso.boot.domain.Funcionario;

@Service @Transactional
public class FuncionarioServiceImpl implements FuncionarioService{
	
	@Autowired
	private FuncionarioDAO dao;

	@Override
	public void salvar(Funcionario departamento) {
		dao.save(departamento);
	}

	@Override
	public void editar(Funcionario departamento) {
		dao.update(departamento);
	}

	@Override
	public void excluir(Long primaryKey) {
		dao.delete(primaryKey);
	}

	@Override @Transactional(readOnly = true)
	public Funcionario buscarPorId(Long primaryKey) {
		return dao.find(primaryKey);
	}

	@Override @Transactional(readOnly = true)
	public List<Funcionario> buscarTodos() {
		return dao.findAll();
	}

}
