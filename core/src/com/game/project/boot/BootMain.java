package com.game.project.boot;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class BootMain extends ScreenAdapter {
	private SpriteBatch batch;
	Texture img;

	private AssetManager assetManager_;

	public BootMain(AssetManager assMan){
		assetManager_ = assMan;
		img = assetManager_.get("images/loading.jpg", Texture.class);

	}

	public void show() {
		batch = new SpriteBatch();
	}

	public void resize(int width, int height) {
		super.resize(width, height);
	}
	public void render(float delta) {
		resize(1920, 1080);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		assetManager_.update();
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	@Override
	public void hide () {
	}

	@Override
	public void pause () {
	}

	@Override
	public void resume () {
	}

	@Override
	public void dispose () {
	}
}
