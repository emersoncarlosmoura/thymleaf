package com.emerson.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.emerson.curso.boot.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

}
