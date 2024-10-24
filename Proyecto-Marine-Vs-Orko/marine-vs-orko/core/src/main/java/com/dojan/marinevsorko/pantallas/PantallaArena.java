package com.dojan.marinevsorko.pantallas;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;


import com.dojan.marinevsorko.utiles.*;

public class PantallaArena implements Screen {

	SpriteBatch b;
	Imagen fondo;
	
	private TiledMap mapa;
	private OrthogonalTiledMapRenderer r;
	
	
	@Override
	public void show() {
		
		fondo = new Imagen (Recursos.FONDO_ARENA);
		b = Render.batch;
		
		mapa =  new TmxMapLoader().load(Recursos.MAPA);
		
		r = new OrthogonalTiledMapRenderer(mapa);
		
		
		
		
		
	}

	@Override
	public void render(float delta) {
		Render.LimpPant();
		
		b.begin();
		fondo.dibujar();
		b.end();
		
		r.setView((OrthographicCamera) Config.camara);
		r.render();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void dispose() {
		dispose();
		r.dispose();
		
	}

}
