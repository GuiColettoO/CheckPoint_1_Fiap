package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.ClienteDao;
import br.com.fiap.dao.ClienteDaoImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.sigleton.EntityManagerFactorySingleton;

public class ClienteView {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		ClienteDao dao = new ClienteDaoImpl(em);
		
		Cliente cliente = new Cliente("Thiago", "Rua logolapertodeca", 912542321, "ThiagoFiap@fiap.com.br");
		
		try {
			dao.salvar(cliente);
			dao.commit();
			System.out.println("Cliente cadastrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		try {
			Cliente busca = dao.pesquisar(100);
			System.out.println(busca.getNome());
		} catch (EntidadeNaoEcontradaException e) {
			System.err.println(e.getMessage());
		}

		try {
			cliente.setCodigo(1);
			cliente.setNome("Jorge");
			dao.salvar(cliente);
			dao.commit();
			System.out.println("Nome atualizado!");
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}

		try {
			dao.deletar(6);
			dao.commit();
			System.out.println("Cliente removido!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}


}
