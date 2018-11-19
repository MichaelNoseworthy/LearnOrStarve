package com.learnorstarve.game.Temp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Align;

/**
 * Created by markapptist on 2018-11-12.
 */

public class MenuScreen2 extends ScreenBeta2 {

    TextButton startButton;
    TextButton helpButton;
    TextButton exitButton;

    Label label;

    /**PARTICLE EFFECTS**/
    FireParticle fire;


    @Override
    public void initialize() {

        uiTable.background(skin.getDrawable("window-c"));

        uiStage.addActor(tableContainer);

        startButton = new TextButton("Start", skin.get(("default"), TextButton.TextButtonStyle.class));
        startButton.setOrigin(Align.center);
        startButton.setTransform(true);
        startButton.setScale(3);

        helpButton = new TextButton("Help", skin.get(("default"), TextButton.TextButtonStyle.class));
        helpButton.setOrigin(Align.center);
        helpButton.setTransform(true);
        helpButton.setScale(3);

        exitButton = new TextButton("Exit", skin.get(("default"), TextButton.TextButtonStyle.class));
        exitButton.setOrigin(Align.center);
        exitButton.setTransform(true);
        exitButton.setScale(3);

        setUpButtons();

        label = new Label("LABEL", labelStyle);

        //Add to TABLE

        uiTable.row().padTop(HEIGHT / 12).padBottom(HEIGHT / 12);
        uiTable.add(startButton).size(startButton.getWidth(), startButton.getHeight()).expandX();

        uiTable.row().padTop(HEIGHT / 12).padBottom(HEIGHT / 12);
        uiTable.add(helpButton).size(helpButton.getWidth(), helpButton.getHeight()).expandX();

        uiTable.row().padTop(HEIGHT / 12).padBottom(HEIGHT / 12);
        uiTable.add(exitButton).size(exitButton.getWidth(), exitButton.getHeight()).expandX();

        /**PARTICLE EFFECTS**/
        fire = new FireParticle();
        fire.centerAtActor(startButton);
        fire.start();
        fire.setPosition(WIDTH / 2, HEIGHT / 2);
        fire.setScale(2.0f);

        mainStage.addActor(fire);
    }

    public void setUpButtons() {

        startButton.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);

                if(MyGame2.gameScreen == null) {
                    MyGame2.gameScreen = new GameScreen2();
                    MyGame2.setActiveScreen(MyGame2.gameScreen);
                }
            }
        });
    }

    @Override
    public void render(float delta) {super.render(delta);}

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void update(float dt) {fire.act(dt);}
}
