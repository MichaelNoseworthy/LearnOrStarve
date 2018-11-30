package com.learnorstarve.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
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

        apple = new Apple(10, 600, 100,100);
            //apple.setScale(1.5f);

        banana = new Banana(300, 500, 120,100);
            //banana.setScale(0.15f);

        blackberry = new Blackberry(200, 600, 150,150);
            //blackberry.setScale(0.4f);

        cherry = new Cherry(450, 900, 100,100);
            //cherry.setScale(0.2f);

        corn = new Corn(500, 600, 100,100);
            //corn.setScale(0.25f);

        //jalapeno = new Jalapeno(300, 600, 100,100);

        lemon = new Lemon(200, 400, 100,100);
            //lemon.setScale(0.2f);

        pea = new Pea(100, 700, 100,100);
            //pea.setScale(0.5f);

        pepper = new Pepper(150, 900, 100,100);
            //pepper.setScale(0.9f);

        pineapple = new Pineapple(300, 900, 100,200);
            //pineapple.setScale(0.2f);

        pumpkin = new Pumpkin(400, 700, 100,100);
            //pumpkin.setScale(0.8f);

        tomato = new Tomato(100, 800, 100,100);
            //tomato.setScale(0.2f);

        watermelon = new Watermelon(100, 500, 100,100);
            //watermelon.setScale(0.45f);

        apple.getRotation();
        //apple.onClick();  //broken

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

        apple.moveBy(5*dt, 5*dt);
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
