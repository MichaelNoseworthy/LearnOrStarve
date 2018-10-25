package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by markapptist on 2018-09-26.
 */

public class LevelOne extends ScreenBeta {

    ActorBeta background;

    Skeleton skeleton;

    Box box;

    @Override
    public void initialize() {

        skeleton = new Skeleton();
        skeleton.setPosition(Gdx.graphics.getWidth()/ 2, Gdx.graphics.getHeight() /2);
        skeleton.setScale(5.0f);

        box = new Box();
        box.setPosition(Gdx.graphics.getWidth()/ 4, Gdx.graphics.getHeight() /4);
        box.setScale(1.0f);

        background = new ActorBeta();
        background.loadTexture("backgroundImg.jpg");
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        mainStage.addActor(background);
        mainStage.addActor(skeleton);
        mainStage.addActor(box);

        defaultSoundEffect = Gdx.audio.newSound(Gdx.files.internal("sparkle.mp3"));
        defaultBackgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("Prelude-and-Action.mp3"));
        secondarySoundEffect = Gdx.audio.newSound(Gdx.files.internal("Ting-Popup_Pixels-349896185.mp3"));

        defaultBackgroundMusic.setPosition(20.0f);
        defaultBackgroundMusic.play();
        defaultBackgroundMusic.setLooping(true);
    }

    @Override
    public void hide() {

    }

    @Override
    public void update(float dt) {

    }


    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        skeleton.setPosition(screenX, Gdx.graphics.getHeight() - screenY);

        defaultSoundEffect.play(2.0f);

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        super.touchUp(screenX, screenY, pointer, button);

        skeleton.setPosition(Gdx.graphics.getWidth()/ 2, Gdx.graphics.getHeight() /2);
        box = new Box();


        secondarySoundEffect.play(7.0f);
        Gdx.app.log("skeletons.png", "You've disposed of this many skeletons" );

        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        super.touchDragged(screenX, screenY, pointer);

        skeleton.setPosition(screenX, Gdx.graphics.getHeight() - screenY);


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
