package com.learnorstarve.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import static com.badlogic.gdx.Input.Keys.R;

/**
 * Created by markapptist on 2018-11-12.
 */

public class MenuScreen extends ScreenBeta {

    TextButton startButton;
    TextButton helpButton;
    TextButton highscoreButton;
    TextButton optionsButton;
    TextButton exitButton;
    Image titlePicture;


    //Sound FX & Music

    Sound bounceSound;
  //  bounceSound()  super ("UI/bounce.mp3.mp3", "UI/");
    Sound splatSound;
    Sound enterSound;
    Sound canonSound;
   // Sound musicSound;

   /** private Music music_rolemu_-_Peek-Door_Quest;

    music_rolemu_-_Peek-Door_Quest = Gdx.audio.newMusic(Gdx.files.internal("rolemu_-_Peek-Door_Quest.mp3"));
    music_rolemu_-_Peek-Door_Quest.setLooping(true);
    music_rolemu_-_Peek-Door_Quest.play(); **/ 






    Label label;

    /**PARTICLE EFFECTS**/
    BloodParticle blood;
    BloodParticle blood2;


    @Override
    public void initialize() {

        titlePicture = new Image(new Texture("UI/logo.png"));
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

        highscoreButton = new TextButton("High Scores", skin.get(("default"), TextButton.TextButtonStyle.class));
        highscoreButton.setOrigin(Align.center);
        highscoreButton.setTransform(true);
        highscoreButton.setScale(3);

        optionsButton = new TextButton("Options", skin.get(("default"), TextButton.TextButtonStyle.class));
        optionsButton.setOrigin(Align.center);
        optionsButton.setTransform(true);
        optionsButton.setScale(3);

        exitButton = new TextButton("Exit", skin.get(("default"), TextButton.TextButtonStyle.class));
        exitButton.setOrigin(Align.center);
        exitButton.setTransform(true);
        exitButton.setScale(3);

        setUpButtons();

        label = new Label("LEARN OR STARVE", labelStyle);

        //Add to TABLE

        //uiTable.add(label).size(label.getPrefWidth(),label.getPrefHeight());

        uiTable.add(titlePicture).size(titlePicture.getWidth(),titlePicture.getHeight());
        uiTable.row().padTop(HEIGHT / 25).padBottom(HEIGHT / 25);
        uiTable.add(startButton).size(startButton.getWidth(), startButton.getHeight()).expandX();

        uiTable.row().padTop(HEIGHT / 25).padBottom(HEIGHT / 25);
        uiTable.add(helpButton).size(helpButton.getWidth(), helpButton.getHeight()).expandX();

        uiTable.row().padTop(HEIGHT / 25).padBottom(HEIGHT / 25);
        uiTable.add(highscoreButton).size(highscoreButton.getWidth(), highscoreButton.getHeight()).expandX();

        uiTable.row().padTop(HEIGHT / 25).padBottom(HEIGHT / 25);
        uiTable.add(optionsButton).size(optionsButton.getWidth(), optionsButton.getHeight()).expandX();

        uiTable.row().padTop(HEIGHT / 25).padBottom(HEIGHT / 25);
        uiTable.add(exitButton).size(exitButton.getWidth(), exitButton.getHeight()).expandX();

        /**PARTICLE EFFECTS**/
        blood = new BloodParticle();
        blood.centerAtActor(startButton);
        blood.start();
        //blood.setPosition(WIDTH / 2, HEIGHT / 2);
        blood.setPosition(70, (HEIGHT / 2) + 100);
        blood.setScale(1.0f);

        blood2 = new BloodParticle();
        blood2.centerAtActor(startButton);
        blood2.start();
        //blood.setPosition(WIDTH / 2, HEIGHT / 2);
        blood2.setPosition((WIDTH / 2) + 100, (HEIGHT / 2) + 100);
        blood2.setScale(1.0f);

        mainStage.addActor(blood);

        mainStage.addActor(blood2);

        //SOUND EFFECTS
    }

    public void setUpButtons() {

        startButton.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);

                if(MyGame.gameScreen == null) {
                    MyGame.gameScreen = new GameScreen();
                }
                MyGame.setActiveScreen(MyGame.gameScreen);

            }
        });
        helpButton.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);

                Gdx.app.log("Yay?","+1");
                if(MyGame.instructionsScreen == null) {
                    MyGame.instructionsScreen = new InstructionsScreen();
                }
                MyGame.setActiveScreen(MyGame.instructionsScreen);
            }
        });
        optionsButton.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);

                Gdx.app.log("Yay?","+1");
                if(MyGame.optionsScreen == null) {
                    MyGame.optionsScreen = new OptionsScreen();
                }
                MyGame.setActiveScreen(MyGame.optionsScreen);
            }
        });
        highscoreButton.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);

                Gdx.app.log("Yay?","+1");
                if(MyGame.highscoreScreen == null) {
                    MyGame.highscoreScreen = new HighscoreScreen();
                }
                MyGame.setActiveScreen(MyGame.highscoreScreen);
            }
        });
        exitButton.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
                System.exit(0);
            }
        });

    }

/*    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        Gdx.app.log("A",pageName());
        return true;
    }
*/
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
    public void update(float dt) {

        //blood.act(dt);

    }
}
