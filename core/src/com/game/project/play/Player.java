package com.game.project.play;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite implements InputProcessor {

    Vector2 velocity = new Vector2(0,0);
    float speed = 60*2;
    TiledMapTileLayer collLayer;
    Animation animation;
    Texture left;
    Texture right;
    Texture back;
    Texture front;

    public Player(Sprite image, TiledMapTileLayer collLayer) {
        super(image);
        this.collLayer = collLayer;

        left = new Texture("images/left.png");
        right = new Texture("images/right.png");
        front = new Texture("images/front.png");
        back = new Texture("images/back.png");
        // if animation
        // animation = new Animation(0.5f, new TextureRegion(new Texture("images/left.png")), new TextureRegion(new Texture("images/right")), new TextureRegion(new Texture("images/back.png")));
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        update(Gdx.graphics.getDeltaTime());
    }

    public void update(float delta) {

/*
        if (velocity.x > 0)
            velocity.x -= delta * 10;
        if (velocity.x < 0)
            velocity.x += delta * 10;

        if (velocity.y > 0)
            velocity.y -= delta * 10;
        if (velocity.y < 0)
            velocity.y += delta * 10;

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            velocity.y = speed;
            //setY(getY() + 12);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            velocity.y = -speed;
            //setY(getY() - 12);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            velocity.x = speed;
            //setX(getX() + 12);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            velocity.x = - speed;
            //setX(getX() - 12);
        }
*/

        // Collision
        float oldX = getX();
        float oldY = getY();
        boolean collideX = false, collideY = false;
        float tileWidth = collLayer.getTileWidth();
        float tileHeight = collLayer.getTileHeight();

        setX(getX() + velocity.x * delta);

        if (velocity.x < 0) {
            // top
            collideX = collLayer.getCell((int)(getX() / tileWidth), (int)((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("solid");

            //middle
            if (!collideX)
                collideX = collLayer.getCell((int)(getX() / tileWidth), (int)((getY() + (getHeight() / 2)) / tileHeight)).getTile().getProperties().containsKey("solid");

            //bottom
            if (!collideX)
                collideX = collLayer.getCell((int)(getX() / tileWidth), (int)((getY()) / tileHeight)).getTile().getProperties().containsKey("solid");
        } else if (velocity.x > 0) {
            // top
            collideX = collLayer.getCell((int)((getX() + getWidth()) / tileWidth), (int)((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("solid");

            //middle
            if (!collideX)
                collideX = collLayer.getCell((int)((getX() + getWidth()) / tileWidth), (int)((getY() + (getHeight() / 2)) / tileHeight)).getTile().getProperties().containsKey("solid");

            //bottom
            if (!collideX)
                collideX = collLayer.getCell((int)((getX() + getWidth()) / tileWidth), (int)((getY()) / tileHeight)).getTile().getProperties().containsKey("solid");
        }

        if (collideX) {
            setX(oldX);
            velocity.x = 0;
        }

        setY(getY() + velocity.y * delta);

        if (velocity.y < 0) {
            // left
            collideY = collLayer.getCell((int)(getX() / tileWidth), (int)((getY()) / tileHeight)).getTile().getProperties().containsKey("solid");

            //middle
            if (!collideY)
                collideY = collLayer.getCell((int)((getX() + (getWidth() / 2)) / tileWidth), (int)((getY()) / tileHeight)).getTile().getProperties().containsKey("solid");

            //right
            if (!collideY)
                collideY = collLayer.getCell((int)((getX() + getWidth()) / tileWidth), (int)((getY()) / tileHeight)).getTile().getProperties().containsKey("solid");

        } else if (velocity.y > 0) {
            // left
            collideY = collLayer.getCell((int)(getX() / tileWidth), (int)((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("solid");

            //middle
            if (!collideY)
                collideY = collLayer.getCell((int)((getX() + (getWidth() / 2)) / tileWidth), (int)((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("solid");

            //right
            if (!collideY)
                collideY = collLayer.getCell((int)((getX() + getWidth()) / tileWidth), (int)((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("solid");
        }

        if (collideY) {
            setY(oldY);
            velocity.y = 0;
        }


    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                velocity.y = speed;
                setTexture(back);
                break;
            case Input.Keys.S:
                velocity.y = -speed;
                setTexture(front);
                break;
            case Input.Keys.A:
                velocity.x = -speed;
                setTexture(left);
                break;
            case Input.Keys.D:
                velocity.x = speed;
                setTexture(right);
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                velocity.y = 0;
                break;
            case Input.Keys.S:
                velocity.y = 0;
                break;
            case Input.Keys.A:
                velocity.x = 0;
                break;
            case Input.Keys.D:
                velocity.x = 0;
                break;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
