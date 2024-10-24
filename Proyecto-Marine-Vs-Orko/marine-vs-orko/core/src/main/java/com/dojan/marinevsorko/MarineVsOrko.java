package com.dojan.marinevsorko;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import com.dojan.marinevsorko.pantallas.PantallaCarga;
import com.dojan.marinevsorko.pantallas.PantallaMenu;
import com.dojan.marinevsorko.utiles.*;

public class MarineVsOrko extends Game {

	int y, x;

    @Override
    public void create() {
    	Render.app = this;
        Render.batch = new SpriteBatch();
        //this.setScreen(new PantallaCarga()); 
        this.setScreen(new PantallaMenu()); 

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
