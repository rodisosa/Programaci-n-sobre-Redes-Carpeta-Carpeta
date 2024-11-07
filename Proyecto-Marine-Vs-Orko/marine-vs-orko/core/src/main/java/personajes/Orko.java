package personajes;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Orko extends PersonajePrefab {
	
	@Override
    public String getNombre() {
        return "Orko";
    }

	@Override
	public void setAnimsiones() {
    
		textureAtlas = new TextureAtlas("SpriteSheets/Orko/Estatico.atlas");
		est = new Animation<TextureRegion>(1f/4F, textureAtlas.getRegions());

		textureAtlas = new TextureAtlas("SpriteSheets/Orko/Caminar.atlas");
		camDer = new Animation<TextureRegion>(1f/8F, textureAtlas.getRegions());


		textureAtlas = new TextureAtlas("SpriteSheets/Orko/Disparar.atlas");
		dis = new Animation<TextureRegion>(1f/3F, textureAtlas.getRegions());

		textureAtlas = new TextureAtlas("SpriteSheets/Orko/Golpear.atlas");
		gol = new Animation<TextureRegion>(1f/5F, textureAtlas.getRegions());
    
		textureAtlas = new TextureAtlas("SpriteSheets/Orko/Dano.atlas");
		dan = new Animation<TextureRegion>(1f/3F, textureAtlas.getRegions());

		textureAtlas = new TextureAtlas("SpriteSheets/Orko/Morir.atlas");
		mue = new Animation<TextureRegion>(1f/6F, textureAtlas.getRegions());
		
		textureAtlas = new TextureAtlas("SpriteSheets/Orko/Levantar.atlas");
		lev = new Animation<TextureRegion>(1f/4F, textureAtlas.getRegions());

		textureAtlas = new TextureAtlas("SpriteSheets/Orko/Festejar.atlas");
		fes = new Animation<TextureRegion>(1f/2F, textureAtlas.getRegions());

	}

    }

