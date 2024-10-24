package com.dojan.marinevsorko.utiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Imagen{
	
	private Texture t;
	private Sprite s;
	private float x = 0,y = 0;
	
	
	
	public Imagen (String ruta) {
		t = new Texture(ruta);
		s = new Sprite(t);
	}
	
	public void dibujar() {
		s.draw(Render.batch);
	}
	

	
	public void dispose(){
		t.dispose();
	}
	
	
	
	public void setTransparencia(Float a) {
		s.setAlpha(a);
	}
	
	
	
	public void setSize(float width, float height) {
		s.setSize(width, height);
	}
	
	
}
