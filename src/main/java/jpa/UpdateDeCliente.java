package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Cliente;

public class UpdateDeCliente {

	public static void main(String... string) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Clientes-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Cliente cliente = entityManager.find(Cliente.class, 1);

		entityManager.getTransaction().begin();
		cliente.setNome("Coca Cola");
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
