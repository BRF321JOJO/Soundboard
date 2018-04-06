package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;

public class Audio {

    //Fields

    //For Debug
    private boolean Debugmodeon = false;
    private static final int numberofbuttons = 2;

    //Controls global values
    private static float Globalpanchange = 0.5f;
    private static float Globalpitchchange = 0.02f;


    //Array of sound names
    private static final String[] filename = {
            "Spaget.mp3",
            "ImQazi.mp3"
    };

    //Arrays (miscellaneous)
    private static float[] volumes = new float[numberofbuttons];
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
        for (int i = 0; i < numberofbuttons; i++) {
            volumes[i] = 1f;
            pitches[i] = 1f;
            pans[i] = 0f;

            //Creates song
            songs[i] = createSong(filename[i]);
        }

    }

    //Method
    private static void playSong(int buttonpressed) {
        songs[buttonpressed].play(volumes[buttonpressed], pitches[buttonpressed], pans[buttonpressed]);
        System.out.println("Song " + buttonpressed + " was played");
    }

    private static void stopSong() {
        for (int i = 0; i< numberofbuttons; i++) {
            songs[i].stop();
        }
    }

    //Update
    void update(float delta) {

        //Global pitch control
        //Have to hold Left Shift
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {

            for (int i = 0; i < numberofbuttons; i++) {
                //If pressing up, increase pitch
                if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
                    pitches[i] += Globalpitchchange;
                }

                //If pressing down, decrease pitch
                if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
                    pitches[i] -= Globalpitchchange;
                }
            }
        }

        //Global pan control
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
            for (int i = 0; i < numberofbuttons; i++) {
                if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
                    pans[i] += Globalpanchange;
                }

                if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
                    pans[i] -= Globalpanchange;
                }
            }
        }


        //Prevents large unnecessary changes to pitch or pan
        for (int i = 0; i<numberofbuttons; i++) {
            if (pitches[i] > 2.0) {
                pitches[i] = 2.0f;
            }
            if (pitches[i] < 0.5) {
                pitches[i] = 0.5f;
            }
            if (pans[i] < -1) {
                pans[i] = -1;
            }
            if (pans[i] > 1) {
                pans[i] = 1;
            }
        }

        //Play Sounds
        //Only works if Tab not pressed

        if (Gdx.input.isKeyJustPressed(Input.Keys.TAB)) {
            if (Debugmodeon) {
                Debugmodeon = false;
                System.out.println("Debug off");
            } else {
                Debugmodeon = true;
                System.out.println("Debug on");
            }
        }

        if (!Debugmodeon) {

            //Tries to play a sound
            try {

                if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
                    playSong(0);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.B)) {
                    playSong(1);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.C)) {
                    playSong(2);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
                    playSong(3);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.E)) {
                    playSong(4);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.F)) {
                    playSong(5);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.G)) {
                    playSong(6);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.H)) {
                    playSong(7);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.I)) {
                    playSong(8);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.J)) {
                    playSong(9);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.K)) {
                    playSong(10);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.L)) {
                    playSong(11);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.M)) {
                    playSong(12);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.N)) {
                    playSong(13);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.O)) {
                    playSong(14);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
                    playSong(15);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
                    playSong(16);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
                    playSong(17);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
                    playSong(18);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.T)) {
                    playSong(19);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.U)) {
                    playSong(20);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.V)) {
                    playSong(21);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
                    playSong(22);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.X)) {
                    playSong(23);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.Y)) {
                    playSong(24);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.Z)) {
                    playSong(25);
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
