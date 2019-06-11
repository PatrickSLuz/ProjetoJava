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
	
	public void excluir(Integer codigo) {
		em = getEntityManager();
		em.getTransaction().begin();
		Cliente cli = em.find(Cliente.class, codigo); // faz uma busca no banco pelo codigo;
		em.remove(cli);
		em.getTransaction().commit();
	}
	
	public List<Cliente> listarClientes(){
		em = getEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select object(c) from Cliente as c");
		return q.getResultList();
	}
	
	public List<Cliente> buscarClientes(String nome){
		System.out.println("Entrou em - ClienteDAOImpl.buscarClientes()");
		em = getEntityManager();
		Query q = em.createQuery("select c from Cliente c where c.nome like :pnome");
		try {
			System.out.println("Entrou no try em - ClienteDAOImpl.buscarClientes()");
			q.setParameter("pnome", "%"+nome+"%");
		} catch(Exception e) {
			System.out.println("Entrou no catch em - ClienteDAOImpl.buscarClientes()");
			e.printStackTrace();
		} finally {
			System.out.println("Entrou no finally em - ClienteDAOImpl.buscarClientes()");
			//em.close();
		}
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
			System.out.println("Nome: "+ cliente.getNome()+
					"RG: "+cliente.getRg()+
					"CPF: "+cliente.getCpf()+
					"Login: "+cliente.getLogin()+
					"Senha: "+cliente.getSenha());
		} catch (Exception e) {
			System.out.println("Entrou no Catch - ClienteDAOImpl.autenticar()");
			cliente = null;
		} finally {
			em.close();
		}
		return cliente;
	}

	
	
}
