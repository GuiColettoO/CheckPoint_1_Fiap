package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Profissional;

public class ProfissionalDaoImpl extends GenericDaoImpl<Profissional, Integer> implements ProfissionalDao{

	public ProfissionalDaoImpl(EntityManager em) {
		super(em);
	}

}
