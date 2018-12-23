package com.frcnetto.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.frcnetto.curso.boot.domain.Funcionario;

@Repository
public class FuncionarioDAOImpl extends AbstractDAO<Funcionario, Long> implements FuncionarioDAO{}
