package com.frcnetto.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.frcnetto.curso.boot.domain.Departamento;

@Repository
public class DepartamentoDAOImpl extends AbstractDAO<Departamento, Long> implements DepartamentoDAO{}
