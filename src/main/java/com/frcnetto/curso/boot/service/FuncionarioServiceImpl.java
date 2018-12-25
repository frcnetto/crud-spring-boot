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
	public void salvar(Funcionario funcionario) {
		dao.save(funcionario);
	}

	@Override
	public void editar(Funcionario funcionario) {
		dao.update(funcionario);
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
