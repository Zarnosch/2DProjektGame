package com.game.project;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.project.boot.BootMain;
import com.game.project.menu.MenuMain;

public class GameMain extends Game {
<<<<<<< HEAD
	//Initialize assetManager
	public AssetManager assetManager = new AssetManager();
	
	//Loading States	
	public void LoadBoot() {
		BootMain bootMain = new BootMain(assetManager);
		assetManager.load("images/badlogic.jpg",  Texture.class);
		while(assetManager.getProgress() != 1.0){
			assetManager.update();
		}
		System.out.println(assetManager.isLoaded("images/badlogic.jpg"));
		
		super.setScreen(bootMain);
		bootMain.render();
	}
	
	public void LoadMenu() {
		assetManager.load("images/badlogic.jpg",  Texture.class);
		super.setScreen(new MenuMain());
	}
	
	public void LoadPlay() {
		assetManager.load("images/loading.jpg",  Texture.class);
	}
	
	public void LoadScore() {
		assetManager.load("images/badlogic.jpg",  Texture.class);
	}

	@Override
	public void create () {
		LoadBoot();

	}
	
	public void draw(){
		super.render();
	}


	public void gameStates () {
	}
=======
    //Initialize assetManager
    public AssetManager assetManager = new AssetManager();
>>>>>>> 67d6a55f2474597650ce3525934fd5c5627f87c8

    //Loading States
/*    public void LoadBoot() {
        assetManager.load("images/badlogic.jpg",  Texture.class);
        while(assetManager.getProgress() != 1.0){
            assetManager.update();
        }
        System.out.println(assetManager.isLoaded("images/badlogic.jpg"));

        setScreen(new BootMain(assetManager));
    }

    public void LoadMenu() {
        assetManager.load("images/badlogic.jpg",  Texture.class);
        super.setScreen(new MenuMain());
    }

    public void LoadPlay() {
        assetManager.load("images/loading.jpg",  Texture.class);
    }

    public void LoadScore() {
        assetManager.load("images/badlogic.jpg", Texture.class);
    }*/

    @Override
    public void create () {
        assetManager.load("images/badlogic.jpg",  Texture.class);
        while(assetManager.getProgress() != 1.0){
            assetManager.update();
        }
        System.out.println(assetManager.isLoaded("images/badlogic.jpg"));
        setScreen(new BootMain(assetManager));
    }

    public void render(){
        super.render();
    }

    public void resize(int width, int height) {
        super.resize(width, height);
    }

    public void pause() {
        super.pause();
    }

    public void resume() {
        super.resume();
    }

    public void dispose() {
        super.dispose();
    }
}
