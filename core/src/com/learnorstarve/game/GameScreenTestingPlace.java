package com.learnorstarve.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.learnorstarve.game.Food.Apple;
import com.learnorstarve.game.Food.Banana;
import com.learnorstarve.game.Food.Blackberry;
import com.learnorstarve.game.Food.Cherry;
import com.learnorstarve.game.Food.Corn;
import com.learnorstarve.game.Food.Jalapeno;
import com.learnorstarve.game.Food.Lemon;
import com.learnorstarve.game.Food.Pea;
import com.learnorstarve.game.Food.Pepper;
import com.learnorstarve.game.Food.Pineapple;
import com.learnorstarve.game.Food.Pumpkin;
import com.learnorstarve.game.Food.Tomato;
import com.learnorstarve.game.Food.Watermelon;


public class GameScreenTestingPlace extends ScreenBeta {


    //    Cannon cannon;
    Button toMainMenu;
    Button toWinScreen;
    Button toLoseScreen;

    ActorBeta foreground;
    ActorBeta background;

    Apple apple;
    Banana banana;
    Blackberry blackberry;
    Cherry cherry;
    Corn corn;
    Jalapeno jalapeno;
    Lemon lemon;
    Pea pea;
    Pepper pepper;
    Pineapple pineapple;
    Pumpkin pumpkin;
    Tomato tomato;
    Watermelon watermelon;

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

        apple = new Apple();
            apple.setScale(0.5f);

        banana = new Banana();
            banana.setScale(0.15f);

        blackberry = new Blackberry();
            blackberry.setScale(0.4f);

        cherry = new Cherry();
            cherry.setScale(0.2f);

        corn = new Corn();
            corn.setScale(0.25f);

        jalapeno = new Jalapeno();

        lemon = new Lemon();
            lemon.setScale(0.2f);

        pea = new Pea();
            pea.setScale(0.5f);

        pepper = new Pepper();
            pepper.setScale(0.9f);

        pineapple = new Pineapple();
            pineapple.setScale(0.2f);

        pumpkin = new Pumpkin();
            pumpkin.setScale(0.8f);

        tomato = new Tomato();
            tomato.setScale(0.2f);

        watermelon = new Watermelon();
            watermelon.setScale(0.45f);

        //apple.centerAtActor(startButton);
        //apple.start();
        //apple.setPosition(WIDTH / 2, HEIGHT / 2);
        apple.setPosition(10, 600);
        banana.setPosition(10, 500);
        blackberry.setPosition(100, 600);
        cherry.setPosition(150, 600);
        corn.setPosition(250, 600);
        lemon.setPosition(200, 400);
        pea.setPosition(100, 700);
        pepper.setPosition(150, 900);
        pineapple.setPosition(100, 700);
        pumpkin.setPosition(400, 700);
        tomato.setPosition(100, 800);
        watermelon.setPosition(100, 500);


        mainStage.addActor(apple);
        mainStage.addActor(banana);
        mainStage.addActor(blackberry);
        mainStage.addActor(cherry);
        mainStage.addActor(corn);
        mainStage.addActor(lemon);
        mainStage.addActor(pea);
        mainStage.addActor(pepper);
        mainStage.addActor(pineapple);
        mainStage.addActor(pumpkin);
        mainStage.addActor(tomato);
        mainStage.addActor(watermelon);

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
