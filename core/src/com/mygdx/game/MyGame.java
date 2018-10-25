package com.mygdx.game;

/**
 * Created by markapptist on 2018-09-26.
 */

public class MyGame extends GameBeta {

    LevelOne levelOne;

    boolean paused = false;

    @Override
    public void create() {

        super.create();

        levelOne = new LevelOne();

        setScreen(levelOne);
    }

}
