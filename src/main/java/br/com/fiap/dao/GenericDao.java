package br.com.fiap.dao;

import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntidadeNaoEcontradaException;

public interface GenericDao <E,K>{
	
	//CRUD
	void salvar (E entidade);
	
	void deletar (K id) throws EntidadeNaoEcontradaException;
	
	E pesquisar(K id) throws EntidadeNaoEcontradaException;
	
	void commit() throws CommitException;
}
