package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.AgendamentoDao;
import br.com.fiap.dao.AgendamentoDaoImpl;
import br.com.fiap.entity.Agendamento;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.sigleton.EntityManagerFactorySingleton;

public class AgendamentoView {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
	
		AgendamentoDao dao = new AgendamentoDaoImpl(em);
		
		Agendamento agendamento = new Agendamento(5000, new GregorianCalendar(2022, Calendar.MAY, 30));
		
		try {
			dao.salvar(agendamento);
			dao.commit();
			System.out.println("Agendamento cadastrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
	
		try {
			Agendamento busca = dao.pesquisar(100);
			System.out.println(busca.getDataAgendamento());
		} catch (EntidadeNaoEcontradaException e) {
			System.err.println(e.getMessage());
		}
	
		try {
			agendamento.setCodigo(1);
			agendamento.setValorAgendamento(988);
			dao.salvar(agendamento);
			dao.commit();
			System.out.println("Agendamento atualizado!");
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}
	
		try {
			dao.deletar(6);
			dao.commit();
			System.out.println("Agendamento removido!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
