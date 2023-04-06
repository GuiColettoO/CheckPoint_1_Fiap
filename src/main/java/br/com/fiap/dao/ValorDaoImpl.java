package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Valor;

public class ValorDaoImpl extends GenericDaoImpl<Valor, Integer> implements ValorDao {
	
	public ValorDaoImpl(EntityManager em) {
		super(em);
	}

}
