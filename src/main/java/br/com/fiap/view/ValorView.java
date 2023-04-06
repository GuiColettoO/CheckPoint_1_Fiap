package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.ValorDao;
import br.com.fiap.dao.ValorDaoImpl;
import br.com.fiap.entity.Valor;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.sigleton.EntityManagerFactorySingleton;

public class ValorView {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		ValorDao dao = new ValorDaoImpl(em);
		
		Valor valor = new Valor(600, 750);
		
		try {
			dao.salvar(valor);
			dao.commit();
			System.out.println("Valor cadastrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		try {
			Valor busca = dao.pesquisar(100);
			System.out.println(busca.getValorContrato());
		} catch (EntidadeNaoEcontradaException e) {
			System.err.println(e.getMessage());
		}

		try {
			valor.setCodigo(1);
			valor.setValorContrato(1200);
			dao.salvar(valor);
			dao.commit();
			System.out.println("Valor atualizado!");
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}

		try {
			dao.deletar(6);
			dao.commit();
			System.out.println("Valor removido!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}

