package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.ServicoDao;
import br.com.fiap.dao.ServicoDaoImpl;
import br.com.fiap.entity.Servico;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.sigleton.EntityManagerFactorySingleton;

public class ServicoView {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
	
		ServicoDao dao = new ServicoDaoImpl(em);
		
		Servico servico = new Servico("Corte de cabelo NEY", "Este corte é igual o do jogador neymar", 5000);
		
		try {
			dao.salvar(servico);
			dao.commit();
			System.out.println("Servico cadastrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
	
		try {
			Servico busca = dao.pesquisar(100);
			System.out.println(busca.getNome());
		} catch (EntidadeNaoEcontradaException e) {
			System.err.println(e.getMessage());
		}
	
		try {
			servico.setCodigo(1);
			servico.setNome("Jorge");
			dao.salvar(servico);
			dao.commit();
			System.out.println("Servico atualizado!");
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}
	
		try {
			dao.deletar(6);
			dao.commit();
			System.out.println("Servico removido!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}