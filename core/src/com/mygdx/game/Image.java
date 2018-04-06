package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Image {

    Texture texture;
    int height;
    int width;
    int posx;
    int posy;

    private double circleangle;

    //Touching image boundaries
    private int leftx = 0;
    private int rightx = MyGdxGame.V_WIDTH;
    private int bottomy = 0;
    private int topy = MyGdxGame.V_HEIGHT;

    Image() {
        texture = new Texture("test6.jpg");
        posx = 0;
        posy = 0;
        width = MyGdxGame.V_WIDTH;
        height = MyGdxGame.V_HEIGHT;
    }


    public void update(float delta) {

        if (Gdx.input.isTouched()) {

            //Defines the x and y coordinates which mouse can be clicked
            if (Gdx.input.getX() > leftx && Gdx.input.getX() < rightx) {
                if(Gdx.input.getY() > bottomy && Gdx.input.getY() < topy){

                    circleangle += Math.PI / 2;
                    posx += (float)(20 * Math.sin(circleangle));
                    posy += (float)(20 * Math.cos(circleangle));

                }
            }
        }

        if (circleangle == 2*Math.PI) {
            circleangle = 0;
        }
    }
}
