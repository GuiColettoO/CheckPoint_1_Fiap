package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Servico;

public class ServicoDaoImpl extends GenericDaoImpl<Servico, Integer> implements ServicoDao{

	public ServicoDaoImpl(EntityManager em) {
		super(em);
	}

}
