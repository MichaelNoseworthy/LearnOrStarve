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
        label1.setPosition(WIDTH/2-400, HEIGHT/2+500);
        label1.setScale(1);
        label1.setFontScale(1);
        label1.setText("Place holder for instructions");

        toMainMenu = new TextButton("Main Menu", skin.get(("default"), TextButton.TextButtonStyle.class));
        toMainMenu.setOrigin(Align.center);
        toMainMenu.setTransform(true);
        toMainMenu.setScale(3);

        setUpButton();

        uiTable.row().padTop(HEIGHT / 12).padBottom(HEIGHT / 12);
        uiTable.add(toMainMenu).size(toMainMenu.getWidth(), toMainMenu.getHeight()).expandX();

        toMainMenu.setPosition(Gdx.graphics.getWidth()/2-100, 200);

        uiStage.addActor(toMainMenu);

        instrBtn = new instructionsBtn();
        instrBtn.setPosition(WIDTH/2-260, HEIGHT-135);
        mainStage.addActor(instrBtn);
        mainStage.addActor(label1);


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
