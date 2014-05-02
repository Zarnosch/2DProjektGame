package com.game.project.play;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class TileMap {

    TiledMap map;
    OrthogonalTiledMapRenderer renderer;
    TmxMapLoader tmxLoader;

    public TileMap() {
        tmxLoader = new TmxMapLoader();
        map = tmxLoader.load("map.tmx");

        renderer = new OrthogonalTiledMapRenderer(map);
        renderer.getSpriteBatch().begin();
    }


}
