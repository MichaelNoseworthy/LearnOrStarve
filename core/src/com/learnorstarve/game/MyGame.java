package com.learnorstarve.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.learnorstarve.game.HighscoreScreen;
import com.learnorstarve.game.InstructionsScreen;
import com.learnorstarve.game.OptionsScreen;
import com.learnorstarve.game.GameBeta;
import com.learnorstarve.game.GameScreen;
import com.learnorstarve.game.MenuScreen;


/**
 * Created by markapptist on 2018-09-26.
 */

public class MyGame extends GameBeta {

    static MenuScreen menuScreen;
    static GameScreen gameScreen;
    static InstructionsScreen instructionsScreen;
    static OptionsScreen optionsScreen;
    static HighscoreScreen highscoreScreen;
    static LoseScreen loseScreen;
    static WinScreen winScreen;
    static Sound enterSound;
    static Sound bounceSound;
    static Sound cannonSound;
    static Music defaultBackgroundMusic;
    static Sound splatSound;

    boolean paused = false;

    @Override
    public void create() {

        super.create();
        enterSound = Gdx.audio.newSound(Gdx.files.internal("UI/ui-button.mp3.mp3"));
        bounceSound = Gdx.audio.newSound(Gdx.files.internal("UI/bounce.mp3.mp3"));
        cannonSound = Gdx.audio.newSound(Gdx.files.internal("UI/cannon1.mp3.mp3"));
        defaultBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("UI/rolemu_-_Peek-Door_Quest.mp3"));
        splatSound = Gdx.audio.newSound(Gdx.files.internal("UI/splatter.mp3.mp3"));

        defaultBackgroundMusic.play();
        defaultBackgroundMusic.setLooping(true);
        menuScreen = new MenuScreen();

        setScreen(menuScreen);
    }

}
