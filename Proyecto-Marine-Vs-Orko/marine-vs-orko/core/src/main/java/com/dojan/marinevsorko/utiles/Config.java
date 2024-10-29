package com.dojan.marinevsorko.utiles;


import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


public class Config {
	
	public static final int WIDTH = 896;		// Ancho de la pantalla  
	public static final int HEIGHT = 480;		// Alto de la pantalla
	
	public static final float GRAVEDAD = 0.4f;
	
	public static final int TAMANIO_TILE = 32;
	
	public static Camera camara;
	
	public static SpriteBatch b;
	
	private static Viewport v;
	
	public static  void iniciarCamara(){
			camara = new OrthographicCamera(WIDTH,HEIGHT);
	        camara.normalizeUp();
	        v = new FitViewport(WIDTH, HEIGHT, camara); 
	        v.update(WIDTH, HEIGHT,true);
	        Render.batch.setProjectionMatrix(camara.combined);
	}
	 
	
	public static Viewport getViewport() {
		return v; 
	}
	 
	
	
	public static void updateCamara(){
		camara.update();
	}
	 
	
	
	
	
	
	
	
	 
	
	
	 
	
	
	
	
	
	
	
	
	 
	 
}
