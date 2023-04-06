package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Cliente;

public class ClienteDaoImpl extends GenericDaoImpl<Cliente, Integer> implements ClienteDao{
 
	public ClienteDaoImpl(EntityManager em) {
		super(em);
	}

}
