package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;

public class Audio {

    //Fields

    //For Debug
    private boolean Debugmodeon = false;
    private static final int numberofbuttons = 2;
    private static int lastbuttonpressed;

    //Controls global values
    private static float panchange = 0.5f;
    private static float pitchchange = 0.02f;

    protected static float Globalpitch = 1f;
    protected static float Globalpan = 0f;


    //Array of sound names
    private static final String[] filename = {
            "Spaget.mp3",
            "ImQazi.mp3"
    };

    //Arrays (miscellaneous)
    private static float[] volumes = new float[numberofbuttons];
    private static float[] pitches = new float[numberofbuttons];
    private static float[] pans = new float[numberofbuttons];

    //Array of sounds
    private static Sound[] songs = new Sound[numberofbuttons];

    //Method to assign sound
    private Sound createSong(String songname) {
        return Gdx.audio.newSound(Gdx.files.internal(songname));
    }

    //Constructor
    Audio() {

        //Sets volume, pitch, pan
        for (int i = 0; i < numberofbuttons; i++) {
            volumes[i] = 1f;
            pitches[i] = 1f;
            pans[i] = 0f;

            //Creates song
            songs[i] = createSong(filename[i]);
        }

    }

    //Method
    //Plays songs
    private static void playSong(int buttonpressed) {
        songs[buttonpressed].play(volumes[buttonpressed], pitches[buttonpressed], pans[buttonpressed]);
        System.out.println("Song " + buttonpressed + " was played");

        //Makes a new variable which can be used as the last button pressed
        lastbuttonpressed = buttonpressed;
    }

    //Stops songs
    private static void stopSong() {
        for (int i = 0; i< numberofbuttons; i++) {
            songs[i].stop();
        }
    }

    //Update
    void update(float delta) {

        //Unknown, for some reason, Globalpan and Globalpitch increment double that of its value. So divide by 2 to fix.

        //Global pitch/pan control control
        for (int i = 0; i < numberofbuttons; i++) {

            //Doesn't work if LSHIFT is pressed
            if (!Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {

                //If pressing up, increase pitch (and global)
                if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
                    pitches[i] += pitchchange;
                    Globalpitch += pitchchange/2;
                }

                //If pressing down, decrease pitch (and global)
                if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
                    pitches[i] -= pitchchange;
                    Globalpitch -= pitchchange/2;
                }
                //If press left, decrease pan (and global)
                if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
                    pans[i] -= panchange;
                    Globalpan -= panchange/2;
                }

                //If press right, increase pan (and global)
                if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
                    pans[i] += panchange;
                    Globalpan += panchange/2;
                }
            }
        }

        //Controls pitch and pan individually for last button pressed
        if (Gdx.input.isKeyPressed((Input.Keys.SHIFT_LEFT))) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
                pitches[lastbuttonpressed] += pitchchange;
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
                pitches[lastbuttonpressed] -= pitchchange;
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
                pans[lastbuttonpressed] -= panchange;
            }
            if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
                pans[lastbuttonpressed] += panchange;
            }
        }

        //Doesn't do anything right now
//        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
//
//        }

        //Prevents unnecessary changes to global pitch or pan
        if (Globalpitch > 2.0) {
            Globalpitch = 2.0f;
        }
        if (Globalpitch < 0.5) {
            Globalpitch = 0.5f;
        }
        if (Globalpan < -1) {
            Globalpan = -1f;
        }
        if (Globalpan > 1) {
            Globalpan = 1f;
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
                pans[i] = -1f;
            }
            if (pans[i] > 1) {
                pans[i] = 1f;
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
