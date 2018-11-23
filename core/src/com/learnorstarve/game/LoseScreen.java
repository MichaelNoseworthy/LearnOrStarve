package com.learnorstarve.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;

/**
 * Created by markapptist on 2018-11-12.
 */

public class LoseScreen extends ScreenBeta {

    Button toMainMenu;
    @Override
    public void initialize() {

        toMainMenu = new Button();
        toMainMenu.setPosition(Gdx.graphics.getWidth()/4, 10);
        uiStage.addActor(tableContainer);

        setUpButtons();
        mainStage.addActor(toMainMenu);

    }

    @Override
    public void update(float dt) {

    }

    public void setUpButtons() {

        toMainMenu.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
                Gdx.app.log("To Main?", "+1");
                if (MyGame.menuScreen == null) {
                    MyGame.menuScreen = new MenuScreen();
                }
                MyGame.setActiveScreen(MyGame.menuScreen);
            }
        });
    }
}
