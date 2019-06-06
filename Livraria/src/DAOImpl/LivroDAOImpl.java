package DAOImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import DAO.DAO;
import DAO.LivroDAO;
import bean.Livro;

public class LivroDAOImpl extends DAO implements LivroDAO{

	EntityManager em;
	
	@Override
	public void salvarLivro(Livro livro) {
		System.out.println("Entro em - LivroDAOImpl.salvarLivro()");		
		em = getEntityManager();
		try {
			if(livro.getCodigo()==null) {
				System.out.println("Entrou no IF - sem codigo - Livro Novo");
				em.getTransaction().begin(); // Abre a transa��o com o BD;
				System.out.println("Deopis do - em.getTransaction().begin()");
				em.persist(livro); // Persiste um objeto no Banco;
				System.out.println("Deopis do - em.persist(livro);");
				em.getTransaction().commit(); // Confirma/Comita a execu��o anterior;
				System.out.println("Deopis do - em.getTransaction().commit();");
			}else {
				System.out.println("Entrou no Else - com codigo - Livro existente");
				em.getTransaction().begin(); // Abre a transa��o com o BD;
				em.merge(livro); // Atualiza um objeto no Banco;
				em.getTransaction().commit(); // Confirma/Comita a execu��o anterior;
			}
		} catch(Exception e) {
			System.out.println("Entro em Catch - LivroDAOImpl.salvarLivro()");
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}		
	}
	
	public List<Livro> listarLivros(){
		em = getEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select object(l) from Livro as l");
		return q.getResultList();
	}

}

