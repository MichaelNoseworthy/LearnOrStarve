package com.learnorstarve.game.Temp;

/**
 * Created by markapptist on 2018-09-26.
 */

public class MyGame2 extends GameBeta2 {

    static MenuScreen2 menuScreen;
    static GameScreen2 gameScreen;

    boolean paused = false;

    @Override
    public void create() {

        super.create();

        menuScreen = new MenuScreen2();

        setScreen(menuScreen);
    }

}
