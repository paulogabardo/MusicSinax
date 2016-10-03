package com.sinax.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sinax.model.Banda;
import com.sinax.model.Music;


public class TesteManagerFactory {
	
	public static void main(String[] args) {
		
		MusicDAO musicDAOImpl =  new MusicDAOImpl();
		musicDAOImpl.listMusic();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hsqldb");
		EntityManager manager = factory.createEntityManager();

		Banda b = new Banda();
		b.setNome("ACDC");
		List<Music> listaMusicas = new ArrayList<Music>();
		
		List<Music> listMusic = manager.createQuery("SELECT m FROM Music m").getResultList();
		
		/*Music music = new Music();
		music.setBanda(b);
		music.setDuracao("00:04:47");
		music.setNome("Thunders Truck");
		
		
		listaMusicas.add(music);
		b.setListaMusicas(listaMusicas);
		
		manager.getTransaction().begin();    
		manager.persist(b);
		manager.getTransaction().commit();*/

	}

}
