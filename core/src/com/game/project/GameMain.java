package com.game.project;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.game.project.play.PlayMain;

public class GameMain extends Game {
	AssetManager assetManager = new AssetManager();

	@Override
	public void create () {
		assetManager.load("images/badlogic.jpg", Texture.class);
        setScreen(new PlayMain());
	}

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }
}
