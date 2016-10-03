package com.sinax.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sinax.model.Banda;

public class BandaDAOImpl implements BandaDAO {

	@Override
	public List<Banda> listBanda() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqldb");
		EntityManager manager = factory.createEntityManager();

		@SuppressWarnings("unchecked")
		List<Banda> listBanda = manager.createQuery("SELECT m FROM Banda m").getResultList();
		return listBanda;
	}

	@Override
	public String addBanda(Banda b) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqldb");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();    
		manager.persist(b);
		manager.getTransaction().commit();
		
		return "Música adicionada com sucesso!";
	}

	@Override
	public List<Banda> findBanda(String nome) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqldb");
		EntityManager manager = factory.createEntityManager();

		@SuppressWarnings("unchecked")
		List<Banda> listBanda = manager.createQuery("SELECT m FROM Banda m where upper(m.nome) like upper('%"+nome+"%')").getResultList();
		return listBanda;
	}
	
	

}
