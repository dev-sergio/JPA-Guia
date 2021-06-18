package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cliente;

public class EstadosEntity {

	public static void main(String... string) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Clientes-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Estado novo
		Cliente cliente = new Cliente();
		cliente.setNome("Itubaina");

		entityManager.getTransaction().begin();

		// Estado gerenciado
		entityManager.persist(cliente);

		// Estado desanexado (nenhuma opera��o ser� feita)
		entityManager.detach(cliente);

		// Volta ao estado gerenciado
		cliente = entityManager.merge(cliente);

		// Estado removido (ser� removido da base de dados)
		entityManager.remove(cliente);

		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
