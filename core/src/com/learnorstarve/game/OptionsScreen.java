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

public class OptionsScreen extends ScreenBeta {
    /**
     * Created by mehol on 2018-11-18.
     */

    TextButton toMainMenu;
    easyBtn easyButton;
    optionsBtn optionButton;
    mediumBtn mediumButton;
    hardBtn hardButton;

    int diffultyNum;

    @Override
    public void initialize() {
        diffultyNum = 2;

        toMainMenu = new TextButton("Main Menu", skin.get(("default"), TextButton.TextButtonStyle.class));
        toMainMenu.setOrigin(Align.center);
        toMainMenu.setTransform(true);
        toMainMenu.setScale(3);

        easyButton = new easyBtn();
        easyButton.setScale(0.75f,1);
        optionButton = new optionsBtn();
        mediumButton = new mediumBtn();
        mediumButton.setScale(0.75f,1);
        hardButton = new hardBtn();
        hardButton.setScale(0.75f,1);



        setUpButton();

        easyButton.setPosition(WIDTH/2-260, HEIGHT-535);
        optionButton.setPosition(WIDTH/2-260, HEIGHT-135);
        hardButton.setPosition(WIDTH/2-260, HEIGHT-935);
        mediumButton.setPosition(WIDTH/2-260, HEIGHT-735);

        mainStage.addActor(easyButton);
        mainStage.addActor(optionButton);
        mainStage.addActor(hardButton);
        mainStage.addActor(mediumButton);

        toMainMenu.setPosition(Gdx.graphics.getWidth()/2-100, 200);

        mainStage.addActor(toMainMenu);


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

        easyButton.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Yay?","+1");
                super.touchDown(event, x, y, pointer, button);
                diffultyNum = 3;
            }
        });

        mediumButton.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Yay?","+1");
                super.touchDown(event, x, y, pointer, button);
                diffultyNum =2;
            }
        });

        hardButton.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Yay?","+1");
                super.touchDown(event, x, y, pointer, button);
                diffultyNum = 1;
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
