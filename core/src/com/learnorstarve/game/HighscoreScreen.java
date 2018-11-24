package com.learnorstarve.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Align;
import com.learnorstarve.game.MyGame;
import com.learnorstarve.game.ScreenBeta;

/**
 * Created by mehol on 2018-11-18.
 */

public class HighscoreScreen extends ScreenBeta {
    /**
     * Created by mehol on 2018-11-18.
     */

    TextButton toMainMenu;
    highscoreBtn highscoreButton;
    Label label1;

    @Override
    public void initialize() {



        highscoreButton = new highscoreBtn();

        toMainMenu = new TextButton("Main Menu", skin.get(("default"), TextButton.TextButtonStyle.class));
        toMainMenu.setOrigin(Align.center);
        toMainMenu.setTransform(true);
        toMainMenu.setScale(3);

        label1 = new Label("LABEL", labelStyle);
        label1.setPosition(WIDTH/2-400, HEIGHT/2+500);
        label1.setScale(1);
        label1.setFontScale(1);
        label1.setText("Place holder for scores");

        setUpButton();


        toMainMenu.setPosition(Gdx.graphics.getWidth()/2-100, 200);

        mainStage.addActor(toMainMenu);

        highscoreButton.setPosition(WIDTH/2-260, HEIGHT-135);
        mainStage.addActor(highscoreButton);
        mainStage.addActor(label1);

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
