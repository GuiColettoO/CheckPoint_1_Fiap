package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.ContratoDao;
import br.com.fiap.dao.ContratoDaoImpl;
import br.com.fiap.entity.Contrato;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.sigleton.EntityManagerFactorySingleton;

public class ContratoView {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
	
		ContratoDao dao = new ContratoDaoImpl(em);
		
		Contrato contrato = new Contrato(5000, new GregorianCalendar(2023, Calendar.JANUARY, 27), new GregorianCalendar(2023, Calendar.DECEMBER, 31));
		
		try {
			dao.salvar(contrato);
			dao.commit();
			System.out.println("Contrato cadastrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
	
		try {
			Contrato busca = dao.pesquisar(100);
			System.out.println(busca.getDataInicio());
		} catch (EntidadeNaoEcontradaException e) {
			System.err.println(e.getMessage());
		}
	
		try {
			contrato.setCodigo(1);
			contrato.setValortotal(4680);
			dao.salvar(contrato);
			dao.commit();
			System.out.println("Contrato atualizado!");
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}
	
		try {
			dao.deletar(6);
			dao.commit();
			System.out.println("Contrato removido!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
