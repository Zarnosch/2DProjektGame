package com.game.project.boot;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.project.GameMain;


public class BootMain extends ScreenAdapter {
	private SpriteBatch batch;
	private Texture img;
	
	private AssetManager assetManager_;
	
	public BootMain(AssetManager assetManager){
		assetManager_ = assetManager;
		batch = new SpriteBatch();
	}

	public void render () {
//				Gdx.gl.glClearColor(0, 0, 0, 1);
				Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		assetManager_.update();

		img = assetManager_.get("images/badlogic.jpg",  Texture.class);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();			
	}
}
