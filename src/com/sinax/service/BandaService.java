package com.sinax.service;

import java.util.List;

import com.sinax.model.Banda;

public interface BandaService {
	
	public List<Banda> listBanda();
	
	public List<Banda> findBanda(String nome);
	
	public String addBanda(Banda m);

}
