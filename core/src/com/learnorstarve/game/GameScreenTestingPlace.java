package com.learnorstarve.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.learnorstarve.game.Food.Apple;
import com.learnorstarve.game.Food.Banana;
import com.learnorstarve.game.Food.Blackberry;
import com.learnorstarve.game.Food.Cherry;
import com.learnorstarve.game.Food.Corn;
import com.learnorstarve.game.Food.Food;
import com.learnorstarve.game.Food.Jalapeno;
import com.learnorstarve.game.Food.Lemon;
import com.learnorstarve.game.Food.Pea;
import com.learnorstarve.game.Food.Pepper;
import com.learnorstarve.game.Food.Pineapple;
import com.learnorstarve.game.Food.Pumpkin;
import com.learnorstarve.game.Food.Tomato;
import com.learnorstarve.game.Food.Watermelon;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class GameScreenTestingPlace extends ScreenBeta {


    //    Cannon cannon;
    Button toMainMenu;
    Button toWinScreen;
    Button toLoseScreen;

    ActorBeta foreground;
    ActorBeta background;

    ArrayList<Foods> foods;

    float resetTimer;

    Foods apple;
    Foods banana;
    Foods blackberry;
    Foods cherry;
    Foods corn;
    Foods jalapeno;
    Foods lemon;
    Foods pea;
    Foods pepper;
    Foods pineapple;
    Foods pumpkin;
    Foods tomato;
    Foods watermelon;

    @Override
    public void initialize() {

        resetTimer = 0;

        Timer timer = new Timer();
        toMainMenu = new TextButton("Main Menu", skin.get(("default"), TextButton.TextButtonStyle.class));
        toMainMenu.setScale(5);
        toWinScreen = new TextButton("Win Screen", skin.get(("default"), TextButton.TextButtonStyle.class));
        toWinScreen.setScale(5);
        toLoseScreen = new TextButton("Lose Screen", skin.get(("default"), TextButton.TextButtonStyle.class));
        toLoseScreen.setScale(5);

        foods = new ArrayList<Foods>();

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

        //apple = new Apple(10, 600, 100,100);
            //apple.setScale(1.5f);

      //  apple2 = new Foods(0,300, 600, 10,10);
        apple = new Foods(0);
        banana = new Foods(1);
        blackberry = new Foods(2);
        cherry = new Foods(3);
        corn = new Foods(4);
        jalapeno = new Foods(5);
        lemon = new Foods(6);
        pea = new Foods(7);
        pepper = new Foods(8);
        pineapple = new Foods(9);

        foods.add(apple);
        foods.add(banana);
        foods.add(blackberry);
        foods.add(cherry);
        foods.add(corn);
        foods.add(jalapeno);
        foods.add(lemon);
        foods.add(pea);
        foods.add(pepper);
        foods.add(pineapple);

        mainStage.addActor(foods.get(0));
        mainStage.addActor(foods.get(1));
        mainStage.addActor(foods.get(2));
        mainStage.addActor(foods.get(3));
        mainStage.addActor(foods.get(4));
        mainStage.addActor(foods.get(5));
        mainStage.addActor(foods.get(6));
        mainStage.addActor(foods.get(7));
        mainStage.addActor(foods.get(8));
        mainStage.addActor(foods.get(9));
        //mainStage.addActor(foods.get(10));

        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                //foods.get(0).setPosition(0,0);
                resetTimer = 0;
            }
        },0,1000*3);


    }

    @Override
    public void update(float dt) {
        resetTimer = resetTimer +dt;
//        apple.moveBy(5*dt, 5*dt);


        //foods.get(0).moveBy(15,25);

        foods.get(0).act(dt);

        foods.get(1).act(dt);

        if (resetTimer > 3) {
            int random = MathUtils.random(6);
            Gdx.app.log("random", String.valueOf(random));
            switch (random) {
                case 0:
                   foods.get(0).setPosition(0,0);
//                   foods.get(0).moveBy(15,25);
                   break;

                case 1:
                    foods.get(1).setPosition(0,0);
  //                  foods.get(1).moveBy(15,25);

                    break;
                case 2:
                    foods.get(2).setPosition(0,0);

                    break;
                case 3:
                    foods.get(3).setPosition(0,0);

                    break;
                case 4:
                    foods.get(4).moveBy(15,25);
                    break;
                case 5:
                    foods.get(5).moveBy(15,25);
                    break;

                case 6:
                    foods.get(6).setPosition(0,0);
                    break;

                default:
                    foods.get(7).setPosition(0,0);
                    foods.get(7).moveBy(15,25);
                    break;
            }
        }
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
