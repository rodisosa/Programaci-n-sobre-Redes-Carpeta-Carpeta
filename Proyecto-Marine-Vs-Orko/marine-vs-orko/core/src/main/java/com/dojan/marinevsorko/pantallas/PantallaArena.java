package com.dojan.marinevsorko.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.graphics.g2d.Animation;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.dojan.marinevsorko.entradas.TecladoMouse;
import com.dojan.marinevsorko.personajes.*;
import com.dojan.marinevsorko.utiles.*;

public class PantallaArena implements Screen {

	World oWorld;
	SpriteBatch b;
	Imagen fondo;
	Box2DDebugRenderer renderer;
	private TiledMap mapa;
	private OrthogonalTiledMapRenderer r;
	private PersonajePrefab p1;
	
	private TextureAtlas p1Atlas;
	
	public float tiempo = 0;
	TecladoMouse entradas = new TecladoMouse(this);

	@Override
	public void show() {
		//fondo = new Imagen (Recursos.FONDO_ARENA);
		b = Render.batch;
		mapa =  new TmxMapLoader().load(Recursos.MAPA);
		r = new OrthogonalTiledMapRenderer(mapa);
		
		
		p1Atlas = new TextureAtlas (Recursos.ATLAS_MARINE);
		
		Animation<TextureRegion> est, camDer, camIzq, dis, gol, dan, lev, mue, fes;
		est = new Animation<TextureRegion>(1/2f,p1Atlas.findRegions("estatico"), Animation.PlayMode.LOOP);
		camDer = new Animation<TextureRegion>(1/15f,p1Atlas.findRegions("camDer"), Animation.PlayMode.LOOP);
		camIzq = new Animation<TextureRegion>(1/15f,p1Atlas.findRegions("camIzq"), Animation.PlayMode.LOOP);
		dis = new Animation<TextureRegion> (1/2f, p1Atlas.findRegions("disparar"));
		gol = new Animation<TextureRegion> (1/2f, p1Atlas.findRegions("golpear"));
		dan = new Animation<TextureRegion> (1/2f, p1Atlas.findRegions("dano"));
		lev = new Animation<TextureRegion> (1/2f, p1Atlas.findRegions("levantarse"));
		mue = new Animation<TextureRegion> (1/2f, p1Atlas.findRegions("muerto"));
		fes = new Animation<TextureRegion>(1/2f, p1Atlas.findRegions("festejo"), Animation.PlayMode.LOOP);
		
		
		
					
		
		
		p1 = new PersonajePrefab (est, camDer, camIzq, mue, lev, dis, fes, gol, dan, (TiledMapTileLayer) mapa.getLayers().get(0));
		p1.setPosition(12 * p1.getCapaColision().getWidth(), 22 * p1.getCapaColision().getHeight());
		
		p1.setSize(60f,60f);
		
		Gdx.input.setInputProcessor(entradas);
		
	}

	
	
	@Override
	public void render(float delta) {
		Render.LimpPant();
		r.setView((OrthographicCamera) Config.camara);
		r.render();
		r.getBatch().begin();
		p1.draw(r.getBatch());
		r.getBatch().end();
		
		tiempo += delta;
		
		
		
		if(entradas.isA()) {
			p1.velocidad.x = -p1.rapidez;
			//p1.tiempoAnimacion = 0;
		} else {
			p1.velocidad.x = 0;
			//p1.tiempoAnimacion = 0;
		}
		if(entradas.isD()) {
			p1.velocidad.x = p1.rapidez;
			//p1.tiempoAnimacion = 0;
		}
		if(entradas.isW()) {
			if (tiempo > 1) {
				
				tiempo = 0;
				if(p1.puedeSaltar) {
					p1.velocidad.y = 1000;
					
					} else {
						p1.velocidad.y = 0;
						p1.puedeSaltar = false;
					}
			}
			
			
		}
		if(entradas.isX()) {
			
		}
		
		
		
		
		
		
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
		p1Atlas.dispose();
	}
	
}
