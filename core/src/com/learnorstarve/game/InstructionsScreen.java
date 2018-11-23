package com.learnorstarve.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Align;
import com.learnorstarve.game.MyGame;
import com.learnorstarve.game.ScreenBeta;

/**
 * Created by mehol on 2018-11-18.
 */

public class InstructionsScreen extends ScreenBeta {
    TextButton toMainMenu;

    @Override
    public void initialize() {

        uiTable.background(skin.getDrawable("window-c"));
        uiStage.addActor(tableContainer);

        toMainMenu = new TextButton("Main Menu", skin.get(("default"), TextButton.TextButtonStyle.class));
        toMainMenu.setOrigin(Align.center);
        toMainMenu.setTransform(true);
        toMainMenu.setScale(3);

        setUpButton();

        uiTable.row().padTop(HEIGHT / 12).padBottom(HEIGHT / 12);
        uiTable.add(toMainMenu).size(toMainMenu.getWidth(), toMainMenu.getHeight()).expandX();

    }

    public void setUpButton() {
        Gdx.app.log("Location",""+toMainMenu.getOriginX()+" "+toMainMenu.getOriginY());

        toMainMenu.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
                Gdx.app.log("To Main?","+1");
                if (MyGame.menuScreen == null) {
                    MyGame.menuScreen = new MenuScreen();
                }
                MyGame.setActiveScreen(MyGame.menuScreen);
            }
        });
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void hide() { super.hide(); }

    @Override
    public void update(float dt) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void dispose() {

    }

}
