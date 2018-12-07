package com.learnorstarve.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Align;

/**
 * Created by markapptist on 2018-11-12.
 */

public class LoseScreen extends ScreenBeta {

    TextButton toMainMenu;
    Image lose;
    Sound enterSound = MyGame.enterSound;

    @Override
    public void initialize() {

        lose = new Image(new Texture("UI/youlose.png"));
        toMainMenu = new TextButton("Main Menu", skin.get(("default"), TextButton.TextButtonStyle.class));
        toMainMenu.setOrigin(Align.center);
        toMainMenu.setTransform(true);
        toMainMenu.setScale(3);
        uiStage.addActor(tableContainer);

        setUpButtons();
        uiTable.add(lose);
        uiTable.row().padTop(HEIGHT / 2).padBottom(HEIGHT / 25);
        uiTable.add(toMainMenu).size(toMainMenu.getWidth(), toMainMenu.getHeight()).expandX();
    }

    @Override
    public void update(float dt) {

    }

    public void setUpButtons() {

        toMainMenu.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);

                enterSound.play();
                if (MyGame.menuScreen == null) {
                    MyGame.menuScreen = new MenuScreen();
                }
                MyGame.setActiveScreen(MyGame.menuScreen);
            }
        });
    }
}
