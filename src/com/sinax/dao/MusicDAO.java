package com.sinax.dao;

import java.util.List;

import com.sinax.model.Music;

public interface MusicDAO {
	
	public List<Music> listMusic();
	
	public String addMusic(Music m);
	
	public List<Music> findMusic(String nome);

}
