package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {

    //Fields
    private MyGdxGame game;
    private OrthographicCamera gameCam;
    private Viewport gamePort;
    private final int LEVEL_WIDTH;
    private final int LEVEL_HEIGHT;

    private Audio audio;
    private Image image;
    private HUD hud;
    private Options options;

    //Constructor
    GameScreen(MyGdxGame game) {
        this.game = game;
        //Equates variable values to that declared in MyGdxGame class
        LEVEL_WIDTH = MyGdxGame.V_WIDTH;
        LEVEL_HEIGHT = MyGdxGame.V_HEIGHT;

        audio = new Audio();
        image = new Image();
        hud = new HUD(game.batch);
        options = new Options();

        gameCam = new OrthographicCamera();
        gamePort = new ExtendViewport(LEVEL_WIDTH, LEVEL_HEIGHT, gameCam);
    }

    //Methods
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update();

        //Clears Screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Allows images to be transparent
        //game.batch.enableBlending();

        game.batch.begin();
        game.batch.draw(image.texture, image.posx, image.posy, image.width, image.height);
        game.batch.draw(options.texture, options.posx, options.posy, options.width, options.height);

        game.batch.end();
        hud.stage.draw();
        game.batch.begin();

        game.batch.end();
    }

    //Extra methods provided by Screen implement
    @Override
    public void resize(int width, int height) {
    }
    @Override
    public void pause() {
    }
    @Override
    public void resume() {
    }
    @Override
    public void hide() {
    }
    @Override
    public void dispose() {
    }

    //Updates game using update method in each class
    private void update() {
        audio.update();
        image.update();
        hud.update();
        options.update();
    }
}