package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

class Options extends AbstractImage {

    private static int heightconstant = 100;
    private static int widthconstant = 100;
    private static int posxconstant = 100;
    private static int posyconstant = 500;

    //Sets the location the image can be touched as its width and height
    private int leftx = posxconstant;
    private int rightx = posxconstant + widthconstant;
    private int bottomy = posyconstant;
    private int topy = posyconstant + heightconstant;


    Options(SpriteBatch batch) {
        super(
            batch,
            new Texture("Meme.jpg"),
            posxconstant,
            posyconstant,
            widthconstant,
            heightconstant
        );
    }


    void update () {
        //Whenever image is clicked, will take action
        if(Gdx.input.isTouched()) {
            if (Gdx.input.getX() > leftx && Gdx.input.getX() < rightx) {
                if (Gdx.input.getY() > bottomy && Gdx.input.getY() < topy) {

                    //Sends image off screen (test)
                    posx = MyGdxGame.V_WIDTH;

                }
            }
        }
    }

    @Override
    void render() {batch.draw(texture,posx,posy,width,height);}
}
