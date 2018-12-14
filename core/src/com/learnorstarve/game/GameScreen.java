package com.learnorstarve.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.learnorstarve.game.ActorBeta;

import javax.xml.soap.Text;

/**
 * Created by markapptist on 2018-11-12.
 */

public class GameScreen extends ScreenBeta {

//    Cannon cannon;
    Button toMainMenu;
    Button toWinScreen;
    Button toLoseScreen;

    ActorBeta foreground;
    ActorBeta background;

    @Override
    public void initialize() {
//        cannon = new Cannon();
//        Texture holding = new Texture("UI/cannon.png");
//        cannon.setTexture(holding);
        toMainMenu = new TextButton("Main Menu", skin.get(("default"), TextButton.TextButtonStyle.class));
        toMainMenu.setScale(5);
        toWinScreen = new TextButton("Win Screen", skin.get(("default"), TextButton.TextButtonStyle.class));
        toWinScreen.setScale(5);
        toLoseScreen = new TextButton("Lose Screen", skin.get(("default"), TextButton.TextButtonStyle.class));
        toLoseScreen.setScale(5);

        ActorBeta.setWorldBounds(WIDTH, HEIGHT);

        foreground = new ActorBeta(0, 0, mainStage);
        foreground.loadTexture("sprites/backgrounds/background0_59.png");
        foreground.setSize(WIDTH, HEIGHT);

        background = new ActorBeta(900, 300, mainStage);
        background.loadTexture("sprites/backgrounds/background0_20.png");
        background.setScale(2.0f);

        uiStage.addActor(tableContainer);

        setUpButtons();
//        cannon.setPosition(0, Gdx.graphics.getHeight() - cannon.getHeight());

//        mainStage.addActor(cannon);
        uiTable.row().padTop(HEIGHT / 2);
        uiTable.add(toMainMenu).size(toMainMenu.getWidth(),toMainMenu.getHeight());
        uiTable.add(toWinScreen).size(toWinScreen.getWidth(),toWinScreen.getHeight());
        uiTable.add(toLoseScreen).size(toLoseScreen.getWidth(),toLoseScreen.getHeight());

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
        toWinScreen.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
                Gdx.app.log("To Main?", "+1");
                if (MyGame.winScreen == null) {
                    MyGame.winScreen = new WinScreen();
                }
                MyGame.setActiveScreen(MyGame.winScreen);
            }
        });
        toLoseScreen.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
                Gdx.app.log("To Main?", "+1");
                if (MyGame.loseScreen == null) {
                    MyGame.loseScreen = new LoseScreen();
                }
                MyGame.setActiveScreen(MyGame.loseScreen);
            }
        });
    }
}
