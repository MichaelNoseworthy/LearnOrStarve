package com.learnorstarve.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
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

public class InstructionsScreen extends ScreenBeta {
    TextButton toMainMenu;
    instructionsBtn instrBtn;
    Label label1;
    Sound enterSound = MyGame.enterSound;

    @Override
    public void initialize() {

        //uiTable.background(skin.getDrawable("window-c"));
        uiStage.addActor(tableContainer);

        label1 = new Label("LABEL", labelStyle);
        label1.setWrap(true);
        label1.setWidth(WIDTH * 0.8f);
        label1.setAlignment(Align.center);
        label1.setFontScale(2);
        label1.setText("Tap on the fruit that the King calls out and fires from his cannon. Missing the food means that you'll starve, and collecting the wrong food will poison you.");

        toMainMenu = new TextButton("Main Menu", skin.get(("default"), TextButton.TextButtonStyle.class));
        toMainMenu.setOrigin(Align.center);
        toMainMenu.setTransform(true);
        toMainMenu.setScale(3);

        setUpButton();

        instrBtn = new instructionsBtn();
        uiTable.add(instrBtn).size(instrBtn.getWidth(), instrBtn.getHeight()).expandX();
        uiTable.row().pad(HEIGHT/5);
        uiTable.add(label1).size(label1.getWidth(),label1.getHeight());
        uiTable.row().pad(HEIGHT/25);
        uiTable.add(toMainMenu).size(toMainMenu.getWidth(), toMainMenu.getHeight()).expandX();

    }

    public void setUpButton() {
        Gdx.app.log("Location",""+toMainMenu.getOriginX()+" "+toMainMenu.getOriginY());

        toMainMenu.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
                Gdx.app.log("To Main?","+1");

                enterSound.play();
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
