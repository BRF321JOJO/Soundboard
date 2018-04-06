package com.mygdx.game;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import java.io.File;

public class HUD {
    Stage stage;
    private Viewport viewport;
    private Label Globalpitch;
    private Label Globalpan;
    private Label LSHIFT;
    private Label RSHIFT;


    HUD(SpriteBatch batch) {
        viewport = new ScreenViewport(new OrthographicCamera());

        BitmapFont pixelFont = new BitmapFont(

                //File.separator acts as a / for distinguishing folders within folders
                Gdx.files.internal("font" + File.separator + "pixelOperatorHB.fnt"),
                false
        );

        stage = new Stage(viewport, batch);

        //Display Table for top of screen
        Table displayTable = new Table();
        //.top .center and such says where certain items should be displayed on screen
        displayTable.top();
        displayTable.setFillParent(true);

        //Display table for bottom left of screen
        Table bottomleftTable = new Table();
        bottomleftTable.left().bottom();
        bottomleftTable.setFillParent(true);

        //Display table for bottom right of screen
        Table bottomrightTable = new Table();
        bottomrightTable.right().bottom();
        bottomrightTable.setFillParent(true);

        //Test says what to display on screen
        //Color choices to display item
        Globalpitch = new Label("Globalpitch", new Label.LabelStyle(pixelFont, Color.WHITE));
        Globalpan = new Label ("Globalpan", new Label.LabelStyle(pixelFont, Color.GOLD));
        LSHIFT = new Label("LSHIFT", new Label.LabelStyle(pixelFont, Color.WHITE));
        RSHIFT = new Label("RSHIFT", new Label.LabelStyle(pixelFont, Color.WHITE));

        //Size of text: (1-2 good)
        Globalpitch.setFontScale(1.3F);
        Globalpan.setFontScale(1.1F);

        //expandX makes all displayed things equidistant in certain area rather side by side
        //Value after padTop is distance from top of screen score should be (10 good)
        displayTable.add(Globalpitch).expandX().padTop(10);
        displayTable.add(Globalpan).expandX().padTop(10);
        bottomleftTable.add(LSHIFT).padLeft(100).padBottom(50);
        bottomrightTable.add(RSHIFT).padRight(100).padBottom(50);

        stage.addActor(displayTable);
        stage.addActor(bottomleftTable);
        stage.addActor(bottomrightTable);
    }


    public void update (float delta) {
        //Changes size of LSHIFT/RSHIFT if pressed
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            LSHIFT.setFontScale(2f);
        } else {
            LSHIFT.setFontScale(1.3f);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
            RSHIFT.setFontScale(2f);
        } else {
            RSHIFT.setFontScale(1.3f);
        }
    }

    public void updatePitch (String Globalpitchupdate) {Globalpitch.setText(Globalpitchupdate);}
    public void updatePan (String Globalpanupdate) {Globalpan.setText(Globalpanupdate);}
    public void updateLSHIFT (String LSHIFTupdate) {LSHIFT.setText(LSHIFTupdate);}
    public void updateRSHIFT (String RSHIFTupdate) {RSHIFT.setText(RSHIFTupdate);}
}
