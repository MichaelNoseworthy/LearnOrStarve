package com.learnorstarve.game;

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
    static GameScreenTestingPlace gameScreenTestingPlace;

    boolean paused = false;

    @Override
    public void create() {

        super.create();

        menuScreen = new MenuScreen();

        gameScreenTestingPlace = new GameScreenTestingPlace();

        //setScreen(menuScreen);
        setScreen(gameScreenTestingPlace);
    }

}
