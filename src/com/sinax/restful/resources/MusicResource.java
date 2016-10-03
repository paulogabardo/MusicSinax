package com.sinax.restful.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.sinax.model.Music;
import com.sinax.service.BandaService;
import com.sinax.service.BandaServiceImpl;
import com.sinax.service.MusicService;
import com.sinax.service.MusicServiceImpl;

@Path("/music")
public class MusicResource {
	
	@Path("/listar")
	@GET
	@Produces("application/json")
	public List<Music> getMusicList() {
		MusicService musicServiceImpl = new MusicServiceImpl();
		return musicServiceImpl.listMusic();
	}
	
	@Path("/{nome}")
	@GET
	@Produces("application/json")
	public List<Music> getMusic(@PathParam("nome") String nome) {
		MusicService musicServiceImpl = new MusicServiceImpl();
		return musicServiceImpl.findMusic(nome);
	}
	
	@POST
	@Produces("text/plain")
	public String addBandaMusic(Music m) {
		
		BandaService bandaServiceImpl = new BandaServiceImpl();
		bandaServiceImpl.addBanda(m.getBanda());
		
		MusicService musicServiceImpl = new MusicServiceImpl();
		return musicServiceImpl.addMusic(m);
	}

}
