package com.dojan.marinevsorko.personajes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class PersonajePrefab extends Sprite {
	
	
	private Vector2 velocidad = new Vector2();
	private float rapidez = 60 * 2, gravedad = 60 * 1.8f;
	
	private TiledMapTileLayer capaColision;
	
	public PersonajePrefab (Sprite sprite, TiledMapTileLayer capaColision) {
		super(sprite);
		this.capaColision = capaColision;
	}
	
	
	public void draw( Batch Batch) {
		update(Gdx.graphics.getDeltaTime());
		super.draw(Batch);
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
				}
		
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
