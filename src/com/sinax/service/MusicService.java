package com.sinax.service;

import java.util.List;

import com.sinax.model.Music;

public interface MusicService {
	
	public List<Music> listMusic();
	
	public List<Music> findMusic(String nome);
	
	public String addMusic(Music m);

}
