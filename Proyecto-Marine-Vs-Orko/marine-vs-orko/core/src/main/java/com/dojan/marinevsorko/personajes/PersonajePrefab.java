package com.dojan.marinevsorko.personajes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;


public class PersonajePrefab extends Sprite {
	

	public Vector2 velocidad = new Vector2();
	public float rapidez = 60 * 2;



	private float gravedad = 60 * 0.8f;
	public float tiempoAnimacion = 0;
	private TiledMapTileLayer capaColision;
	
	public boolean puedeSaltar = false;
	
	Animation<TextureRegion> est, camDer, camIzq, dis, gol, dan, lev, mue, fes;
	
	public PersonajePrefab (Animation<TextureRegion> est, Animation<TextureRegion> camDer, Animation<TextureRegion> camIzq,
							Animation<TextureRegion> dis, Animation<TextureRegion> gol,Animation<TextureRegion> dan,
							Animation<TextureRegion> lev, Animation<TextureRegion> mue,
							Animation<TextureRegion> fes, TiledMapTileLayer capaColision) {
		
		super(est.getKeyFrame(0));
		this.est = est;
		this.camDer = camDer;
		this.camIzq = camIzq;
		this.dis = dis;
		this.gol = gol;
		this.dan = dan;
		this.lev = lev;
		this.mue = mue;
		this.fes = fes;	
		
		this.capaColision = capaColision;
	}
	
	

	public void draw( Batch Batch) {
		update(Gdx.graphics.getDeltaTime());
		super.draw(Batch);
	}
	
	public void show() {
		
		
	}
	
	public void update (float delta) {
		velocidad.y -= gravedad * delta; // aplicar gravedad
		
		if (velocidad.y > rapidez) {
			velocidad.y -= gravedad;
		} else if (velocidad.y < rapidez) {		//limitar velocidad
			velocidad.y = -rapidez;
		}
			
		
		float antX = getX(), antY = getY(), tileWidth = capaColision.getTileWidth(), tileHeight = capaColision.getTileHeight();	
		boolean colX = false, colY = false;
		
		
		setX(getX() + velocidad.x * delta);   // en X
			
		if (velocidad.x < 0) { 
				
				//arriba a la izquierda
				colX = capaColision.getCell( (int) ( getX() / tileWidth ) , (int) ( ( getY() + getHeight() ) / tileHeight ) ).getTile().getProperties().containsKey("blocked");
				
				//izquierda
				if (!colX) {
				colX = capaColision.getCell( (int) ( getX() / tileWidth ) , (int) ( ( getY() + getHeight() / 2 ) / tileHeight ) ).getTile().getProperties().containsKey("blocked");
				}
				
				//abajo a la izquierda
				if(!colX) {
				colX = capaColision.getCell( (int) ( getX() / tileWidth ) , (int) ( getY()  / tileHeight ) ).getTile().getProperties().containsKey("blocked");
				}
				
				
				
			} else if (velocidad.x > 0 ) {
				
				//arriba a la derecha
				colX = capaColision.getCell( (int) ( ( getX() + getWidth() ) / tileWidth ) , (int) ( ( getY() + getHeight() ) / tileHeight ) ).getTile().getProperties().containsKey("blocked");
				
				//derecha
				if (!colX) {
				colX = capaColision.getCell( (int) ( ( getX() + getWidth() ) / tileWidth ) , (int) ( ( getY() + getHeight() / 2 ) / tileHeight ) ).getTile().getProperties().containsKey("blocked");
				}
				
				//abajo a la derecha
				if(!colX) {
				colX = capaColision.getCell( (int) ( ( getX() + getWidth() ) / tileWidth ) , (int) ( getY()  / tileHeight ) ).getTile().getProperties().containsKey("blocked");
				}	
				
				
				
			}
		
		//Reaccionar a una colisión en X
		if(colX) {
			setX(antX);
			velocidad.x = 0;
		}
		
		
		
		
		setY(getY() + velocidad.y * delta);	   // en Y
		
		if (velocidad.y < 0) { 
			
			//
			colY = capaColision.getCell( (int) ( getX() / tileWidth ) , (int) ( getY() / tileHeight ) ).getTile().getProperties().containsKey("blocked");
			
			//
			if (!colY) {
			colY = capaColision.getCell( (int) ( ( getX() + getWidth() / 2 ) / tileWidth ) , (int) ( getY() / tileHeight ) ).getTile().getProperties().containsKey("blocked");
			}
			
			//
			if(!colY) {
			colY = capaColision.getCell( (int) ( ( getX() + getWidth() ) / tileWidth ) , (int) ( getY()  / tileHeight ) ).getTile().getProperties().containsKey("blocked");
			}
			puedeSaltar = false;
		} else if (velocidad.y > 0 ) {
			
			//
			colY = capaColision.getCell( (int) ( getX() / tileWidth ) , (int) ( ( getY() + getHeight() ) / tileHeight ) ).getTile().getProperties().containsKey("blocked");
			
			//
			if (!colY) {
			colY = capaColision.getCell( (int) ( ( getX() + getWidth() / 2 ) / tileWidth ) , (int) ( ( getY() + getHeight() ) / tileHeight ) ).getTile().getProperties().containsKey("blocked");
			}
			
			//
			if(!colY) {
			colY = capaColision.getCell( (int) ( ( getX() + getWidth() ) / tileWidth ) , (int) ( ( getY() + getHeight() ) / tileHeight ) ).getTile().getProperties().containsKey("blocked");
			}
			
		}
		
		//Reaccionar a una colisión en Y
		if(colY) {
			setY(antY);
			velocidad.y = 0;
			puedeSaltar = true;
		}
		
		
		tiempoAnimacion += delta;
		setRegion(velocidad.x < 0 ? camIzq.getKeyFrame(tiempoAnimacion) : velocidad.x > 0 ? camDer.getKeyFrame(tiempoAnimacion) : est.getKeyFrame(tiempoAnimacion));
		
	}


	public Vector2 getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(Vector2 velocidad) {
		this.velocidad = velocidad;
	}

	public float getRapidez() {
		return rapidez;
	}

	public void setRapidez(float rapidez) {
		this.rapidez = rapidez;
	}

	public float getGravedad() {
		return gravedad;
	}

	public void setGravedad(float gravedad) {
		this.gravedad = gravedad;
	}

	public TiledMapTileLayer getCapaColision() {
		return capaColision;
	}

	public void setCapaColision(TiledMapTileLayer capaColision) {
		this.capaColision = capaColision;
	}



	


	
	
	
	
	
	
	
	
	
	
	
	
	
}
