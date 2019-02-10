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

class HUD {
    Stage stage;
    private Viewport viewport;

    private Label Globalpitch;
    private Label Globalpan;
    private Label LSHIFT;
    private Label RSHIFT;
    private Label SPACE;

    private BitmapFont pixelFont = new BitmapFont(
            //File.separator, acts as a / for distinguishing folders within folders
            Gdx.files.internal("Font" + File.separator + "pixelOperatorHB.fnt"),
            false
    );

    HUD(SpriteBatch batch) {
        viewport = new ScreenViewport(new OrthographicCamera());
        stage = new Stage(viewport, batch);


        //Display Table for top of screen (pitch and pan)
        Table displayTable = new Table();
        //.top .center and such says where certain items should be displayed on screen
        displayTable.top();
        displayTable.setFillParent(true);

        //Display table for bottom left of screen (LSHIFT)
        Table bottomleftTable = new Table();
        bottomleftTable.left().bottom();
        bottomleftTable.setFillParent(true);

        //Display table for bottom right of screen (RSHIFT)
        Table bottomrightTable = new Table();
        bottomrightTable.right().bottom();
        bottomrightTable.setFillParent(true);

        //Display table for bottom middle of screen (SPACE)
        Table bottomTable = new Table();
        bottomTable.bottom();
        bottomTable.setFillParent(true);

        //Color choices to display item
        Globalpitch = new Label("Globalpitch", new Label.LabelStyle(pixelFont, Color.WHITE));
        Globalpan = new Label ("Globalpan", new Label.LabelStyle(pixelFont, Color.WHITE));
        LSHIFT = new Label("LSHIFT", new Label.LabelStyle(pixelFont, Color.WHITE));
        RSHIFT = new Label("RSHIFT", new Label.LabelStyle(pixelFont, Color.WHITE));
        SPACE = new Label("SPACE", new Label.LabelStyle(pixelFont, Color.WHITE));

        //Size of text: (1-2 good)
        Globalpitch.setFontScale(1.3F);
        Globalpan.setFontScale(1.3F);

        //expandX makes all displayed things equidistant in certain area rather side by side
        //Value after padTop is distance from top of screen score should be (10 good)
        displayTable.add(Globalpitch).expandX().padTop(50);
        displayTable.add(Globalpan).expandX().padTop(50);

        bottomleftTable.add(LSHIFT).padLeft(100).padBottom(50);
        bottomrightTable.add(RSHIFT).padRight(100).padBottom(50);

        bottomTable.add(SPACE).padBottom(50);

        stage.addActor(displayTable);
        stage.addActor(bottomleftTable);
        stage.addActor(bottomrightTable);
        stage.addActor(bottomTable);
    }


    void update () {

        //Changes size of LSHIFT if pressed
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            LSHIFT.setFontScale(2f);
        } else {
            LSHIFT.setFontScale(1.3f);
        }

        //Changes size of RSHIFT if pressed
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
            RSHIFT.setFontScale(2f);
        } else {
            RSHIFT.setFontScale(1.3f);
        }

        //Controls size of SPACE if pressed
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            SPACE.setFontScale(2f);
        } else {
            SPACE.setFontScale(1.3f);
        }


        //Says natural pitch if pitch at normal value
        if (Audio.Globalpitch == 1f) {
            updatePitch("Pitch: Natural");
        } else {
            updatePitch("Pitch: " + Audio.Globalpitch);
        }

        //Says pan neutral if at normal value
        if (Audio.Globalpan == 0f) {
            updatePan("Pan: Neutral");
        } else {
            updatePan("Pan: " + Audio.Globalpan);
        }


        updateLSHIFT("LSHIFT");
        updateRSHIFT("RSHIFT");
        updateSPACE("SPACE");
    }

    private void updatePitch (String Globalpitchupdate) {Globalpitch.setText(Globalpitchupdate);}
    private void updatePan (String Globalpanupdate) {Globalpan.setText(Globalpanupdate);}
    private void updateLSHIFT (String LSHIFTupdate) {LSHIFT.setText(LSHIFTupdate);}
    private void updateRSHIFT (String RSHIFTupdate) {RSHIFT.setText(RSHIFTupdate);}
    private void updateSPACE (String SHIFTupdate) {SPACE.setText(SHIFTupdate);}

}
