package com.sinax.dao;

import java.util.List;

import com.sinax.model.Banda;

public interface BandaDAO {
	
	public List<Banda> listBanda();
	
	public String addBanda(Banda b);
	
	public List<Banda> findBanda(String nome);

}
