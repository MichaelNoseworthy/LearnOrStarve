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
    public static HighscoreSorter highscoreSorter;

    public static String HighscoreArray[] = new String[]{
            "King ", "30",
            "Queen ", "25",
            "Princess ", "20",
            "Prince ", "15",
            "Knight ", "10",
            "Archer ", "5",
            "Peasant ", "1",
            "Peasant ", "1",
            "Peasant ", "1",
            "Peasant ", "1"};

    static Sound enterSound;
    static Sound bounceSound;
    static Sound cannonSound;
    static Music defaultBackgroundMusic;
    static Sound splatSound;
  
    static GameScreenTestingPlace gameScreenTestingPlace;

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

        gameScreenTestingPlace = new GameScreenTestingPlace();

        //setScreen(menuScreen);
        setScreen(gameScreenTestingPlace);
    }

}
