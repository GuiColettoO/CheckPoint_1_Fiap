package br.com.fiap.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.ProfissionalDao;
import br.com.fiap.dao.ProfissionalDaoImpl;
import br.com.fiap.entity.Especializacao;
import br.com.fiap.entity.Profissional;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.EntidadeNaoEcontradaException;
import br.com.fiap.sigleton.EntityManagerFactorySingleton;

public class ProfissionalView {
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		ProfissionalDao dao = new ProfissionalDaoImpl(em);
		
		Profissional profissional = new Profissional("Eduardo", Especializacao.JARDINEIRO, 987654321, "Rua LogoAliPertoDeCa", "EduardoFiap@fiap.com.br");
		
		try {
			dao.salvar(profissional);
			dao.commit();
			System.out.println("Profissional cadastrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		try {
			Profissional busca = dao.pesquisar(100);
			System.out.println(busca.getNome());
		} catch (EntidadeNaoEcontradaException e) {
			System.err.println(e.getMessage());
		}

		try {
			profissional.setCodigo(1);
			profissional.setNome("Jorge");
			dao.salvar(profissional);
			dao.commit();
			System.out.println("Nome atualizado!");
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}

		try {
			dao.deletar(6);
			dao.commit();
			System.out.println("Profissional removido!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
}
