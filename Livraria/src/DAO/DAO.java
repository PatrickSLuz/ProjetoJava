package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {
	
	private EntityManagerFactory emf;
	
	public DAO() {
		emf = Persistence.createEntityManagerFactory("Livraria");
	}
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
