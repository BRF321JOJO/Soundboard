package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.GdxRuntimeException;

import java.io.File;

class Audio {

    //Fields

    //For Debug
    private boolean Debugmodeon = false;
    private static final int numberofbuttons = 3;
    private static int lastbuttonpressed;

    //Controls global values
    private static float panchange = 0.5f;
    private static float pitchchange = 0.02f;

    static float Globalpitch = 1f;
    static float Globalpan = 0f;


    private static int stopsongtrynumber = 1;

    //Array of sound names

    //This method of naming directly named the songs within this class.
//    private static final String[] filename = {
//            "Spaget.mp3",
//            "ImQazi.mp3",
//            "DBS Ultra Insinct Music.mp3"
//    };

    //This next method borrows the names from another user friendly class
    private static final String[] filename = CreateAudio.Listofsongs;

    //Arrays (miscellaneous)
    private static float[] volumes = new float[numberofbuttons];
    private static float[] pitches = new float[numberofbuttons];
    private static float[] pans = new float[numberofbuttons];

    //Array of sounds
    private static Sound[] songs = new Sound[numberofbuttons];


    //Method to assign sound
    //Only used so that sounds can be placed in the SoundAssets folder specifically
    private Sound createSong(String songname) {
        return Gdx.audio.newSound(Gdx.files.internal("SoundAssets" + File.separator + songname));
    }

    //Constructor
    Audio() {

        //Sets volume, pitch, pan
        for (int i = 0; i < numberofbuttons; i++) {
            volumes[i] = 1f;
            pitches[i] = 1f;
            pans[i] = 0f;

            //Try/catch to prevent creation on song not contained in SoundAssets folder
            try {
                //Creates song
                songs[i] = createSong(filename[i]);
            } catch (GdxRuntimeException e) {
                System.err.println("You must place all sound files in the SoundAssets package!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Not all songs have been named in the code!");
            }
        }

    }

    //Method
    //Plays songs
    private static void playSong(int buttonpressed) {
        try {
            songs[buttonpressed].play(volumes[buttonpressed], pitches[buttonpressed], pans[buttonpressed]);
            System.out.println("Song " + buttonpressed + " was played");

            //Makes a new variable which can be used as the last button pressed
            lastbuttonpressed = buttonpressed;
        } catch (NullPointerException e) {
            System.err.println("This sound was not placed in the SoundAssets package!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("That button does not play a sound!");
        }
    }

    //Stops songs
    private static void stopSong() {

        for (int i = 0; i< numberofbuttons; i++) {
            try {
                songs[i].stop();
                stopsongtrynumber++;

            } catch (NullPointerException e) {
                //Divides by number of buttons to account for repetition of for statement
                System.err.println("Cannot stop a song if it doesn't exist! Number of broken song: " + stopsongtrynumber);
                //Resets number of times tried
                stopsongtrynumber = 1;
            }
        }
    }


    //The following two methods are both used in attempt to make the code even shorter

    //Faster way to create inputs
    private boolean keyJustPressed(String key) {
        return Gdx.input.isKeyJustPressed(Input.Keys.valueOf(key));
    }
//    private boolean keyPressed(String key) {
//        return Gdx.input.isKeyPressed(Input.Keys.valueOf(key));
//    }

    //Associate setting a key and playing a song
    private void createKeyandSong (String createkey, int createbutton) {
        if (keyJustPressed(createkey)) {
            playSong(createbutton);
        }
    }


    //Update
    void update() {

        //Unknown, for some reason, Globalpan and Globalpitch increment double that of its value. So divide by 2 to fix.

        //Global pitch/pan control control
        for (int i = 0; i < numberofbuttons; i++) {

            //Doesn't work if LSHIFT is pressed
            if (!Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {

                //If pressing up, increase pitch (and global)
                if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
                    pitches[i] += pitchchange;
                    //Divides because for statement runs through change multiple times
                    Globalpitch += pitchchange/numberofbuttons;
                }

                //If pressing down, decrease pitch (and global)
                if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
                    pitches[i] -= pitchchange;
                    //Divides because for statement runs through change multiple times
                    Globalpitch -= pitchchange/numberofbuttons;
                }
                //If press left, decrease pan (and global)
                if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
                    pans[i] -= panchange;
                    //Divides because for statement runs through change multiple times
                    Globalpan -= panchange/numberofbuttons;
                }

                //If press right, increase pan (and global)
                if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
                    pans[i] += panchange;
                    //Divides because for statement runs through change multiple times
                    Globalpan += panchange/numberofbuttons;
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

            //Penultimate shortening using method
            //Creates sounds (Key, index of name)
            createKeyandSong("A", 0);
            createKeyandSong("B", 1);
            createKeyandSong("C", 2);
            createKeyandSong("D", 3);
            createKeyandSong("E", 4);
            createKeyandSong("F", 5);
            createKeyandSong("G", 6);
            createKeyandSong("H", 7);
            createKeyandSong("I", 8);
            createKeyandSong("J", 9);
            createKeyandSong("K", 10);
            createKeyandSong("L", 11);
            createKeyandSong("M", 12);
            createKeyandSong("N", 13);
            createKeyandSong("O", 14);
            createKeyandSong("P", 15);
            createKeyandSong("Q", 16);
            createKeyandSong("R", 17);
            createKeyandSong("S", 18);
            createKeyandSong("T", 19);
            createKeyandSong("U", 20);
            createKeyandSong("V", 21);
            createKeyandSong("W", 22);
            createKeyandSong("X", 23);
            createKeyandSong("Y", 24);
            createKeyandSong("Z", 25);

            //Stops all sounds
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                stopSong();
                System.out.println("All songs stopped");
            }
        }
    }
}
