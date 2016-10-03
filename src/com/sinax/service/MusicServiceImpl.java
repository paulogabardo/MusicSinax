package com.sinax.service;

import java.util.List;

import com.sinax.dao.MusicDAO;
import com.sinax.dao.MusicDAOImpl;
import com.sinax.model.Music;

public class MusicServiceImpl implements MusicService {

	@Override
	public List<Music> listMusic() {
		MusicDAO musicDAOImpl =  new MusicDAOImpl();
		return musicDAOImpl.listMusic();
	}

	@Override
	public String addMusic(Music m) {
		MusicDAO musicDAOImpl =  new MusicDAOImpl();
		return musicDAOImpl.addMusic(m);
	}

	@Override
	public List<Music> findMusic(String nome) {
		MusicDAO musicDAOImpl =  new MusicDAOImpl();
		return musicDAOImpl.findMusic(nome);
	}
	
	

}
