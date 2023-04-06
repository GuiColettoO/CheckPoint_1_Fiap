package br.com.fiap.sigleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	private static EntityManagerFactory emFactory;
	
	private EntityManagerFactorySingleton() {}
	
	public static EntityManagerFactory getInstance() {
		if (emFactory == null) {
			emFactory = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return emFactory;	
	}
}
