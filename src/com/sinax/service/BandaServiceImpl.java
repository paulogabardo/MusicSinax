package com.sinax.service;

import java.util.List;

import com.sinax.dao.BandaDAO;
import com.sinax.dao.BandaDAOImpl;
import com.sinax.model.Banda;

public class BandaServiceImpl implements BandaService {

	@Override
	public List<Banda> listBanda() {
		BandaDAO bandaDAOImpl =  new BandaDAOImpl();
		return bandaDAOImpl.listBanda();
	}

	@Override
	public String addBanda(Banda m) {
		BandaDAO bandaDAOImpl =  new BandaDAOImpl();
		return bandaDAOImpl.addBanda(m);
	}

	@Override
	public List<Banda> findBanda(String nome) {
		BandaDAO bandaDAOImpl =  new BandaDAOImpl();
		return bandaDAOImpl.findBanda(nome);
	}
	
	

}
