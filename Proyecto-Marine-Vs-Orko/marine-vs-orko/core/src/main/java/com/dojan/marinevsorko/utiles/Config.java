package com.dojan.marinevsorko.utiles;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Config {
	
	public static final int WIDTH = 900;		// Ancho de la pantalla  
	public static final int HEIGHT = 500;		// Alto de la pantalla
	
	private static Camera camara;
	private static Viewport viewport;
	private static int proporcion;
	private static ArrayList<InputEvent> listInput= new ArrayList<InputEvent>();
	 
	
	
	
	
	
	
	
	
	public static void initialize(){
	        
	        camara = new OrthographicCamera(WIDTH,HEIGHT);
	        camara.normalizeUp();
	        viewport = new FitViewport(WIDTH, HEIGHT, camara); 
	        viewport.update(WIDTH, HEIGHT,true);
	        Render.batch.setProjectionMatrix(camara.combined);
	}
	 
	
	public static Viewport getViewport() {
		return viewport; 
	}
	 
	
	
	public static void updateCamara(){
		camara.update();
	}
	 
	
	
	public static float SacarPorcentaje(float nmb, int xyvalue){
        return (nmb*xyvalue/100);
    }
	
	
	
	public static float tamanioDeAlgo(int porc,float f){
		proporcion = porc;
	    return (porc*f/100);
	}
	 
	
	
	public static float centrado(float f){
	    return (f/2-(Config.tamanioDeAlgo(proporcion,f))/2);
	} 
	
	
	
	public static ArrayList<InputEvent> getListInput() {
	    return listInput;
	}
	
	
	
	public static void eraseInput(Object pos){  
	    listInput.remove(pos);
	}
	 
	 
}
