package com.emerson.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.emerson.curso.boot.domain.Cargo;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {

}
