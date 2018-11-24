package com.learnorstarve.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Align;
import com.learnorstarve.game.MyGame;
import com.learnorstarve.game.ScreenBeta;

/**
 * Created by mehol on 2018-11-18.
 */

public class OptionsScreen extends ScreenBeta {
    /**
     * Created by mehol on 2018-11-18.
     */

    TextButton toMainMenu;
    Image easy;
    Image medium;
    Image hard;

    @Override
    public void initialize() {

        easy = new Image(new Texture("UI/easy.png"));
        medium = new Image(new Texture("UI/medium.png"));
        hard = new Image(new Texture("UI/hard.png"));
        uiTable.background(skin.getDrawable("window-c"));
        uiStage.addActor(tableContainer);

        uiStage.addActor(tableContainer);
        toMainMenu = new TextButton("Main Menu", skin.get(("default"), TextButton.TextButtonStyle.class));
        toMainMenu.setOrigin(Align.center);
        toMainMenu.setTransform(true);
        toMainMenu.setScale(3);

        setUpButton();

        uiTable.row().padTop(HEIGHT / 12).padBottom(HEIGHT / 12);
        uiTable.add(easy).size(easy.getWidth(), easy.getHeight()).expandX();
        uiTable.row().padTop(HEIGHT / 12).padBottom(HEIGHT / 12);
        uiTable.add(medium).size(medium.getWidth(), medium.getHeight()).expandX();
        uiTable.row().padTop(HEIGHT / 12).padBottom(HEIGHT / 12);
        uiTable.add(hard).size(hard.getWidth(), hard.getHeight()).expandX();
        uiTable.row().padTop(HEIGHT / 12).padBottom(HEIGHT / 12);
        uiTable.add(toMainMenu).size(toMainMenu.getWidth(), toMainMenu.getHeight()).expandX();

    }

    public void setUpButton() {

        toMainMenu.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Yay?","+1");
                super.touchDown(event, x, y, pointer, button);
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
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        super.touchUp(screenX, screenY, pointer, button);

        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        super.touchDragged(screenX, screenY, pointer);

        return true;
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
