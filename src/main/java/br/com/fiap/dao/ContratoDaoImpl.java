package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Contrato;

public class ContratoDaoImpl extends GenericDaoImpl<Contrato, Integer> implements ContratoDao{

	public ContratoDaoImpl(EntityManager em) {
		super(em);
	}

}
