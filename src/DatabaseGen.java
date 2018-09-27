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
		
		Produto produto1 = new Produto(null,"IphoneX",6900.0);
		Produto produto2 = new Produto(null,"galaxy",5400.0);
		
		Fabricante fabricante = new Fabricante(null,"Apple","California");
		fabricante.getProduto().add(produto1);
		fabricante.getProduto().add(produto2);
		
		produto1.setFabricante(fabricante);
		produto2.setFabricante(fabricante);
		
		em.persist(fabricante);
		
		//
		// Fabricante fabricante = em.find(Fabricante.class,1);
		//if(fabricante != null){
		//	List<Produto> produto = fabricante.getProduto();
		//for(Produto p: produto){
		// p.setPreco(p.getPreco() * 0.9);
		//
		//}
		em.getTransaction().commit();

		em.close();
		factory.close();
	}
}
