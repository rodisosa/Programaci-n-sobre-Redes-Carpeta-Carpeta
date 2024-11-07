package com.dojan.marinevsorko;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pantallas.*;
import utiles.*;

public class MarineVsOrko extends Game {

	int y, x;

    @Override
    public void create() {
    	Render.app = this;
        Render.batch = new SpriteBatch();
        
        Config.iniciarCamara();
        //this.setScreen(new PantallaCarga()); 
        this.setScreen(new PantallaMenu()); 
        //this.setScreen(new PantallaArena(null, null, null));
    }

	@Override
    public void render() {
		super.render();
    }
	
    public void update() {  
    }

    @Override
    public void dispose() {
    	Render.batch.dispose();
    }
    
}
