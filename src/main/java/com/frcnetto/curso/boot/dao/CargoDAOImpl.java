package com.frcnetto.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.frcnetto.curso.boot.domain.Cargo;

@Repository
public class CargoDAOImpl extends AbstractDAO<Cargo, Long> implements CargoDAO{}
