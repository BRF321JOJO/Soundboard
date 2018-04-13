package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

class Options {

    Texture texture;
    int height;
    int width;
    int posx;
    int posy;

    private int leftx = 0;
    private int rightx = 0;
    private int bottomy = 0;
    private int topy = 0;


    Options() {
        texture = new Texture("Meme.jpg");
        posx = 100;
        posy = 500;
        width = 100;
        height = 100;
    }


    void update () {

        if(Gdx.input.isTouched()) {
            if (Gdx.input.getX() > leftx && Gdx.input.getX() < rightx) {
                if (Gdx.input.getY() > bottomy && Gdx.input.getY() < topy) {

                    posx = 1000;

                }
            }
        }
    }
}
