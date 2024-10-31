package personajes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;

import utiles.Imagen;


public class PersonajePrefab extends Sprite {
	

	public Vector2 velocidad = new Vector2();
	public float rapidez = 60 * 2;
	private float gravedad = 60 * 0.8f;
	public float tiempoAnimacion = 0;
	private TiledMapTileLayer capaColision;
	public Rectangle box1;
	public boolean puedeSaltar = false;

	
	
	protected TextureRegion texRegion;
	protected float x, y, texHeight;
	int texWidth;
	Imagen img;
	protected int vidamax=100;
	protected int opc;
	private Imagen i;
	private  int vidaActual=100;
	public boolean a1, a2, leftW = false;
	public enum Estado{ESTATICO, CAMINAR, CAMINARI, DISPARAR, GOLPEAR, DANO, MORIR, LEVANTAR, FESTEJAR}
	protected Estado estadoActual, estadoAnterior;
	protected float statetimer=0;
	protected static Imagen spriteImagen; 
	
	
	protected TextureAtlas textureAtlas;
	public TextureRegion currentFrame, previusFrame;
	public Animation<TextureRegion> est, camDer;
	public Animation<TextureRegion> camIzq;
	public Animation<TextureRegion> dis;
	public Animation<TextureRegion> gol;
	public Animation<TextureRegion> dan;
	public Animation<TextureRegion> lev;
	public Animation<TextureRegion> mue;
	public Animation<TextureRegion> fes;
	
	private Timer tiempo;
	
	
	public PersonajePrefab(){
        tiempo= new Timer();
    } 
   
	protected void iniciar(){
		tiempo.start();
    }

	public Imagen getImagen() {
		return i;
	}
	
	public void setImagen(Imagen i){
		this.i = i;
    }
	
	public String getNombre(){
		return null;
   	}
	
	public void setInput(int opc){
       	this.opc=opc;
	}
	
	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
       this.y = y;
	}

	public float getX(){
       return x;
	}
   
   	public float getY(){
       return y;
   	}

   	public float getW() {
       return img.getAncho();
   	}
   
	public float getH() {
       return img.getAlto();
	}
	
	public int getVidaActual() {
       return vidaActual;
	}
   
	public int getVidamax() {
       return vidamax;
	}
	
	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}

	public void setVidamax(int vidamax) {
		this.vidamax = vidamax;
	}

	public String getEnd(){
		return null;    
	}

	public Estado getEstado(){
		return estadoActual;
	}
	
	public void setEstado(Estado estado){
       	this.estadoActual = estado;
   	}
   
   	public Estado getEstadoAnterior(){
   		return estadoAnterior;
   	}
   
   	public void setEstadoAnterior(Estado estado){
   		this.estadoAnterior = estado;
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
		//setRegion(velocidad.x < 0 ? camIzq.getKeyFrame(tiempoAnimacion) : velocidad.x > 0 ? camDer.getKeyFrame(tiempoAnimacion) : est.getKeyFrame(tiempoAnimacion));
		
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

	public void setAnimsiones() {
        
    }

	public void dispose() {
		for (int i = 0; i < est.getKeyFrames().length; i++) {
            est.getKeyFrames()[i].getTexture().dispose();
        }
        for (int i = 0; i <  camDer.getKeyFrames().length; i++) {
            camDer.getKeyFrames()[i].getTexture().dispose();
        }
        for (int i = 0; i < camIzq.getKeyFrames().length; i++) {
            camIzq.getKeyFrames()[i].getTexture().dispose();
        }
        for (int i = 0; i < dis.getKeyFrames().length; i++) {
            dis.getKeyFrames()[i].getTexture().dispose();
        }
        for (int i = 0; i < gol.getKeyFrames().length; i++) {
            gol.getKeyFrames()[i].getTexture().dispose();
        }
        for (int i = 0; i < dan.getKeyFrames().length; i++) {
            dan.getKeyFrames()[i].getTexture().dispose();
        }
        for (int i = 0; i < mue.getKeyFrames().length; i++) {
            mue.getKeyFrames()[i].getTexture().dispose();
        }
        for (int i = 0; i < lev.getKeyFrames().length; i++) {
            lev.getKeyFrames()[i].getTexture().dispose();
        }
        for (int i = 0; i < fes.getKeyFrames().length; i++) {
            fes.getKeyFrames()[i].getTexture().dispose();
        }
        
        currentFrame.getTexture().dispose();
        previusFrame.getTexture().dispose();
        texRegion.getTexture().dispose();
        for (int i = 0; i < textureAtlas.getRegions().size; i++) {
                textureAtlas.getRegions().get(i).getTexture().dispose();
     
        }
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
}
