package com.game.project.play;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayMain extends ScreenAdapter {

    OrthographicCamera camera;
    SpriteBatch batch;

    public void show() {
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(Gdx.gl20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.begin();
        batch.end();
    }
}
