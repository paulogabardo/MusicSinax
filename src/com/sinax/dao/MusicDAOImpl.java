package com.sinax.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sinax.model.Music;

public class MusicDAOImpl implements MusicDAO {

	@Override
	public List<Music> listMusic() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqldb");
		EntityManager manager = factory.createEntityManager();

		@SuppressWarnings("unchecked")
		List<Music> listMusic = manager.createQuery("SELECT m FROM Music m").getResultList();
		return listMusic;
	}

	@Override
	public String addMusic(Music m) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqldb");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();    
		manager.persist(m);
		manager.getTransaction().commit();
		
		return "Música adicionada com sucesso!";
	}

	@Override
	public List<Music> findMusic(String nome) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqldb");
		EntityManager manager = factory.createEntityManager();

		@SuppressWarnings("unchecked")
		List<Music> listMusic = manager.createQuery("SELECT m FROM Music m where upper(m.nome) like upper('%"+nome+"%')").getResultList();
		return listMusic;
	}
	
	

}
