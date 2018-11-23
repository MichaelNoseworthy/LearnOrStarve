package com.learnorstarve.game.Temp;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;

public abstract class GameBeta2 extends Game {

    private static GameBeta2 game2;

    public GameBeta2() {
        game2 = this;
    }

    @Override
    public void create()
    {
        InputMultiplexer im = new InputMultiplexer();

        Gdx.input.setInputProcessor( im );
    }

    public static void setActiveScreen(ScreenBeta2 s)
    {
        game2.setScreen(s);
    }
}