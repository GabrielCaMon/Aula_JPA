import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseGen {
	public static void main(String[] args) {
		Properties config = new Properties();
		config.put("hibernate.hbm2ddl.auto", "create");

		EntityManagerFactory factory = Persistence.
				createEntityManagerFactory("uni7-pu", config);
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		Produto produto = new Produto(null,"IphoneX",6900.0);
		em.persist(produto);
		
		em.getTransaction().commit();

		em.close();
		factory.close();
	}
}
