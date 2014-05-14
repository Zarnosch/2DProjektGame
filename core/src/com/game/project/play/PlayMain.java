package com.game.project.play;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class PlayMain extends ScreenAdapter {

    OrthographicCamera camera;
    SpriteBatch batch;
    TiledMap map;
    OrthogonalTiledMapRenderer renderer;
    TmxMapLoader tmxLoader;
    Player player;

    public void show() {
        camera = new OrthographicCamera();
        //camera.translate(640, 360);
        batch = new SpriteBatch();

        tmxLoader = new TmxMapLoader();
        map = tmxLoader.load("maps/devmap.tmx");

        renderer = new OrthogonalTiledMapRenderer(map);
        player = new Player(new Sprite(new Texture("images/front.png")), (TiledMapTileLayer) map.getLayers().get(0));
        player.setPosition(200, 200);

        Gdx.input.setInputProcessor(player);
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.position.set(640,360, 0);
        camera.update();

        renderer.setView(camera);
        renderer.render();
        renderer.getSpriteBatch().begin();
        player.draw(renderer.getSpriteBatch());
        renderer.getSpriteBatch().end();
    }

    @Override
    public void resize (int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
    }

    @Override
    public void hide () {
        super.hide();
    }

    @Override
    public void pause () {
        super.show();
    }

    @Override
    public void resume () {
        super.resume();
    }

    @Override
    public void dispose () {
        batch.dispose();
        map.dispose();
        renderer.dispose();
        player.dispose();
    }
}
