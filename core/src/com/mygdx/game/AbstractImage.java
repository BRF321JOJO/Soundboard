package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AbstractImage {

    SpriteBatch batch;
    Texture texture;
    int posx;
    int posy;
    int width;
    int height;

    AbstractImage(SpriteBatch batch, Texture texture, int posx, int posy, int width, int height) {
        this.batch = batch;
        this.texture = texture;
        this.posx = posx;
        this.posy = posy;
        this.width = width;
        this.height = height;
    }

    abstract void render();
}
