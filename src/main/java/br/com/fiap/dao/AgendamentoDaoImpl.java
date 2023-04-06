package br.com.fiap.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Agendamento;

public class AgendamentoDaoImpl extends GenericDaoImpl<Agendamento, Integer> implements AgendamentoDao{

	public AgendamentoDaoImpl(EntityManager em) {
		super(em);
	}
	


}
