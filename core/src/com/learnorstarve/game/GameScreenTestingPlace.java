package com.learnorstarve.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
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
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class GameScreenTestingPlace extends ScreenBeta {

    Random randomFood = new Random();

    String word;
    int test;

    int max = 11; // max words
    int min = 0; //0 point for words

    Label label1;

    Cannon cannon;
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

        //test = min + randomFood.nextInt(max);
        word = words(12);
        label1 = new Label("LABEL", labelStyle);
        label1.setPosition(WIDTH/2-340, HEIGHT/2+500);
        label1.setScale(1);
        label1.setFontScale(1);
        label1.setText(word);

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
        cannon = new Cannon(0,0, 100,100);
        cannon.setPosition(0, 0);
        mainStage.addActor(cannon);



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

        mainStage.addActor(label1);

        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                //foods.get(0).setPosition(0,0);
                resetTimer = 0;
            }
        },0,1000*3);




    }

/*
    public void HandlingButtons(){
        foods.get(0).addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
            }
*/
String words(int word)
{
    if (word == 0)
        return "Apple";
    if (word == 1)
        return "Banana";
    if (word == 2)
        return "Blackberry";
    if (word == 3)
        return "Cherry";
    if (word == 4)
        return "Corn";
    if (word == 5)
        return "Jalapeno";
    if (word == 6)
        return "Lemon";
    if (word == 7)
        return "Peas";
    if (word == 8)
        return "Peppers";
    if (word == 9)
        return "Pineapple";
    if (word == 10)
        return "Pumpkin";
    if (word == 11)
        return "Tomato";
    if (word == 12)
        return "Watermelon";
    else
        return "error";
}

    @Override
    public void update(float dt) {

        resetTimer = resetTimer +dt;

        if (resetTimer > 3) {
            int random = MathUtils.random(6);
            Gdx.app.log("random", String.valueOf(random));
            switch (random) {
                case 0:
                   foods.get(0).setPosition(0,0);
                    label1.setText(words(0));
                   break;

                case 1:
                    foods.get(1).setPosition(0,0);
                    label1.setText(words(1));
                    break;
                case 2:
                    foods.get(2).setPosition(0,0);
                    label1.setText(words(2));
                    break;
                case 3:
                    foods.get(3).setPosition(0,0);
                    label1.setText(words(3));

                    break;
                case 4:
                    foods.get(4).setPosition(0,0);
                    label1.setText(words(4));
                    break;
                case 5:
                    foods.get(5).setPosition(0,0);
                    label1.setText(words(5));
                    break;

                case 6:
                    foods.get(6).setPosition(0,0);
                    label1.setText(words(6));
                    break;

                default:
                    foods.get(7).setPosition(0,0);
                    label1.setText(words(7));
                    break;
            }
        }

        //HandlingButtons();
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
