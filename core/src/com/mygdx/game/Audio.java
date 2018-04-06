package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;

public class Audio {

    //Fields

    //For Debug
    private boolean Debugmodeon = false;

    private int buttonpressed;
    private static final int numberofbuttons = 2;

    //Controls global values
    private static float Globalpanchange = 0.5f;
    private static float Globalpitchchange = 0.02f;


    //Array of sound names
    private static String[] filename = {
            "Spaget.mp3",
            "ImQazi.mp3"
    };

    //Arrays (miscellaneous)
    static float[] volumes = new float[numberofbuttons];
    static float[] pitches = new float[numberofbuttons];
    static float[] pans = new float[numberofbuttons];

    //Array of sounds
    private static Sound[] songs = new Sound[numberofbuttons];

    //Method to assign sound
    private Sound createSong(String songname) {
        return Gdx.audio.newSound(Gdx.files.internal(songname));
    }

    //Constructor
    Audio() {

        //Sets volumes
        for (int v = 0; v < volumes.length; v++) {
            volumes[v] = 1f;
        }

        //Sets pitches
        for (int p = 0; p < volumes.length; p++) {
            pitches[p] = 1f;
        }

        //Sets pans
        for (int a = 0; a < volumes.length; a++) {
            pans[a] = 0f;
        }

        //Creates song
        for (int s = 0; s < songs.length; s++) {
            songs[s] = createSong(filename[s]);
        }
    }

    //Method
    public static void playSong(int buttonpresses) {
        songs[buttonpresses].play(volumes[buttonpresses], pitches[buttonpresses], pans[buttonpresses]);
        System.out.println("Song " + buttonpresses + " was played");
    }

    public static void stopSong() {
        for (int i = 0; i<songs.length; i++) {
            songs[i].stop();
        }
    }

    //Update
    public void update(float delta) {

        //Global pitch control
        //Have to hold Left Shift
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {

            //If pressing up, increase pitch
            if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {

                for (int i = 0; i < pitches.length; i++) {
                    pitches[i] += Globalpitchchange;
                }
            }
            //If pressing down, decrease pitch
            if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {

                for (int i = 0; i < pitches.length; i++) {
                    pitches[i] -= Globalpitchchange;
                }
            }
        }

        //Global pan control
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {

                for (int i = 0; i < pans.length; i++) {
                    pans[i] += Globalpanchange;
                }
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
                for (int i = 0; i < pans.length; i++) {
                    pans[i] -= Globalpanchange;
                }
            }
        }


        //Prevents large unnecessary changes to pitch or pan
        if (pitches[0] > 2.0) {
            pitches[0] = 2.0f;
        }
        if (pitches[0] < 0.5) {
            pitches[0] = 0.5f;
        }
        if (pans[0] < -1) {
            pans[0] = -1;
        }
        if (pans[0] > 1) {
            pans[0] = 1;
        }

        //Play Sounds
        //Only works if Tab not pressed

        if (Gdx.input.isKeyJustPressed(Input.Keys.TAB)) {
            if (Debugmodeon) {
                Debugmodeon = false;
            } else {
                Debugmodeon = true;
            }
        }

        if (!Debugmodeon) {

            //Tries to play a sound
            try {
                if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
                    buttonpressed = 0;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.B)) {
                    buttonpressed = 1;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.C)) {
                    buttonpressed = 2;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
                    buttonpressed = 3;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.E)) {
                    buttonpressed = 4;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.F)) {
                    buttonpressed = 5;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.G)) {
                    buttonpressed = 6;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.H)) {
                    buttonpressed = 7;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.I)) {
                    buttonpressed = 8;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.J)) {
                    buttonpressed = 9;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.K)) {
                    buttonpressed = 10;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.L)) {
                    buttonpressed = 11;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.M)) {
                    buttonpressed = 12;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.N)) {
                    buttonpressed = 13;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.O)) {
                    buttonpressed = 14;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
                    buttonpressed = 15;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
                    buttonpressed = 16;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
                    buttonpressed = 17;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
                    buttonpressed = 18;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.T)) {
                    buttonpressed = 19;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.U)) {
                    buttonpressed = 20;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.V)) {
                    buttonpressed = 21;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
                    buttonpressed = 22;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.X)) {
                    buttonpressed = 23;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.Y)) {
                    buttonpressed = 24;
                    playSong(buttonpressed);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.Z)) {
                    buttonpressed = 25;
                    playSong(buttonpressed);
                }

                //Stops all sounds
                if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                    stopSong();
                    System.out.println("All songs stopped");
                }

                //Catches out of bound errors
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("That button does not play a sound!");
            }


        }
    }
}
