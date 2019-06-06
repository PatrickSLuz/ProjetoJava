package DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import DAO.ClienteDAO;
import DAO.DAO;
import bean.Cliente;

public class ClienteDAOImpl extends DAO implements ClienteDAO{

	EntityManager em;
	
	@Override
	public void salvarCliente(Cliente cliente) {
		em = getEntityManager();
		try {
			if(cliente.getCodigo()==null) {
				em.getTransaction().begin(); // Abre a transação com o BD;
				em.persist(cliente); // Persiste um objeto no Banco;
				em.getTransaction().commit(); // Confirma/Comita a execução anterior;
			}else {
				em.getTransaction().begin(); // Abre a transação com o BD;
				em.merge(cliente); // Atualiza um objeto no Banco;
				em.getTransaction().commit(); // Confirma/Comita a execução anterior;
			}
		} catch(Exception e) {
			e.getStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public List<Cliente> listarClientes(){
		em = getEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select object(c) from Cliente as c");
		return q.getResultList();
	}
	
	public Cliente autenticar(Cliente cliente) {
		System.out.println("Enrtou em - ClienteDAOImpl.autenticar()");
		em = getEntityManager();
		try {
			Query q = em.createQuery("from Cliente where login = :login and senha = :senha");
			q.setParameter("login", cliente.getLogin());
			q.setParameter("senha", cliente.getSenha());
			cliente = (Cliente) q.getSingleResult();
			System.out.println("Após a Query - ClienteDAOImpl.autenticar()");
		} catch (Exception e) {
			System.out.println("Entrou no Catch - ClienteDAOImpl.autenticar()");
			cliente = null;
		} finally {
			em.close();
		}
		return cliente;
	}

	
	
}
