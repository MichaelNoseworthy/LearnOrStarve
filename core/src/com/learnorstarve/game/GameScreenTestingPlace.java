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
import java.util.Timer;
import java.util.TimerTask;


public class GameScreenTestingPlace extends ScreenBeta {


    Cannon cannon;
    Button toMainMenu;
    Button toWinScreen;
    Button toLoseScreen;

    ActorBeta foreground;
    ActorBeta background;

    ArrayList<Foods> foods;
    int cannonX = 20;
    int cannonY = 20;

    //game added
    Button asking;
    Button poisonBtn;
    Label asked;
    Label ScoreLabel;//Actual number value
    Label PoisonLabel;//Actual number value
    Label ScoreLabelName;//Preceeding Listing Item
    Label PoisonLabelName;//Preceeding Listing Item
    boolean needsChange;
    int rightAnswer;
    int beingShown;
    int score;
    int poisonLvl;
    int difficulty;
    float difficultyF;
    boolean anotherFruit;
    boolean playerLost;
    boolean playerWin;

    Label StreakLabelName;//
    Label StreakLabel;//
    int streakCounter;


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
        streakCounter = 0;
        anotherFruit = false;
        playerLost = false;
        difficulty = 2;
        /*
        if(MyGame.optionsScreen != null){
        difficulty = MyGame.optionsScreen.diffultyNum;
        }

        */
        difficultyF = difficulty;
        needsChange = false;
        poisonLvl = 0;

        resetTimer = 0;

        beingShown = 0;
        rightAnswer = 0;
        score = 0;

        asked = new Label("LABEL", labelStyle);
        asked.setPosition(Gdx.graphics.getWidth() / 2 -  asked.getWidth() * 2, (Gdx.graphics.getHeight()/2 -  asked.getHeight() * 2) - 100);
        asked.setScale(1);
        asked.setFontScale(3);
        asked.setText("Manzana");

        StreakLabelName = new Label("LABEL", labelStyle);
        StreakLabelName.setPosition(50, HEIGHT - 450);
        StreakLabelName.setScale(1);
        StreakLabelName.setFontScale(3);
        StreakLabelName.setText("Streak: ");


        StreakLabel = new Label("LABEL", labelStyle);
        StreakLabel.setPosition(820, HEIGHT - 650);
        StreakLabel.setScale(1);
        StreakLabel.setFontScale(3);
        StreakLabel.setText("3");

        ScoreLabelName = new Label("Score: ", labelStyle);
        ScoreLabelName.setPosition(50,HEIGHT-250);
        ScoreLabelName.setScale(3);
        ScoreLabelName.setFontScale(3);

        ScoreLabel = new Label("LABEL", labelStyle);
        ScoreLabel.setPosition(680,HEIGHT-250);
        ScoreLabel.setScale(3);
        ScoreLabel.setFontScale(3);
        ScoreLabel.setText("0");

        PoisonLabelName = new Label("Toxicity: ", labelStyle);
        PoisonLabelName.setPosition(50,HEIGHT - 340);
        PoisonLabelName.setScale(3);
        PoisonLabelName.setFontScale(3);

        PoisonLabel = new Label("LABEL", labelStyle);
        PoisonLabel.setPosition(820,HEIGHT - 440);
        PoisonLabel.setScale(3);
        PoisonLabel.setFontScale(3);
        PoisonLabel.setText("0%");


        Timer timer = new Timer();
        toMainMenu = new TextButton("Main Menu", skin.get(("default"), TextButton.TextButtonStyle.class));
        toMainMenu.setScale(15);
        toMainMenu.setSize(300,200);
        toMainMenu.setPosition(150,HEIGHT-200);

        toWinScreen = new TextButton("Win Screen", skin.get(("default"), TextButton.TextButtonStyle.class));
        toWinScreen.setScale(5);

        toLoseScreen = new TextButton("Lose Screen", skin.get(("default"), TextButton.TextButtonStyle.class));
        toLoseScreen.setScale(5);

        asking = new TextButton("PICK", skin.get(("default"), TextButton.TextButtonStyle.class));
        asking.setTransform(true);
        asking.setScale(4);
        asking.setPosition(Gdx.graphics.getWidth() / 2 - asking.getWidth() * 2, (Gdx.graphics.getHeight()/2 - asking.getHeight() * 2) - 300);

        poisonBtn = new TextButton("PASS", skin.get(("default"), TextButton.TextButtonStyle.class));
        poisonBtn.setTransform(true);
        poisonBtn.setScale(4);
        poisonBtn.setPosition(Gdx.graphics.getWidth() / 2 - poisonBtn.getWidth() * 2, (Gdx.graphics.getHeight()/2 - poisonBtn.getHeight() * 2) - 500);

        foods = new ArrayList<Foods>();

        ActorBeta.setWorldBounds(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
/*
        foreground = new ActorBeta(0, 0, mainStage);
        foreground.loadTexture("sprites/backgrounds/background0_59.png");
        foreground.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
*/
        background = new ActorBeta(0, 0, mainStage);
        background.loadTexture("sprites/backgrounds/castle.jpg");
        background.setOrigin(background.getOriginX(),background.getOriginY());
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //background.setScale(2.0f,8);

        //uiStage.addActor(tableContainer);

        setUpButtons();
        cannon = new Cannon();
        cannon.setPosition(10, 10);
        cannon.setRotation(30);

//        mainStage.addActor(cannon);
        //uiTable.row().padTop(ScoreLabel.getOriginX());
        //uiTable.;
                //.padTop();


        uiTable.add(toMainMenu).size(toMainMenu.getWidth(),toMainMenu.getHeight());
        //uiTable.add(toWinScreen).size(toWinScreen.getWidth(),toWinScreen.getHeight());
        //uiTable.add(toLoseScreen).size(toLoseScreen.getWidth(),toLoseScreen.getHeight());

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
        pumpkin = new Foods(10);
        tomato = new Foods (11);
        watermelon = new Foods (12);

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
        foods.add(pumpkin);
        foods.add(tomato);
        foods.add(watermelon);


        mainStage.addActor(asked);//text shown
        mainStage.addActor(StreakLabel);
        mainStage.addActor(StreakLabelName);

        mainStage.addActor(ScoreLabel);
        mainStage.addActor(PoisonLabel);

        mainStage.addActor(ScoreLabelName);
        mainStage.addActor(PoisonLabelName);

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
        mainStage.addActor(foods.get(10));
        mainStage.addActor(foods.get(11));
        mainStage.addActor(foods.get(12));

        mainStage.addActor(asking);//button
        mainStage.addActor(poisonBtn);
        mainStage.addActor(toMainMenu);
        mainStage.addActor(cannon);

        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                Gdx.app.log("score", "I'm being activated every" + String.valueOf(difficulty));
                resetTimer = 0f;
            }
        },0,1000*difficulty);
    }

    @Override
    public void update(float dt) {

        if(streakCounter == 1){
            StreakLabel.setText("2");
        }

        if(streakCounter == 2){
            StreakLabel.setText("1");
        }

        if(streakCounter == 3){
            StreakLabel.setText("0");
            playerWin = true;
        }

        if (MyGame.PAUSEGAME == false) {
            resetTimer = resetTimer + dt;

            if (needsChange) {
                int random2 = MathUtils.random(12);
                Gdx.app.log("random2", String.valueOf(random2));

                switch (random2) {
                    case 0:
                        asked.setText("Manzana");//apple
                        rightAnswer = 0;
                        needsChange = false;
                        break;

                    case 1:
                        asked.setText("Platano"); //banana
                        rightAnswer = 1;
                        needsChange = false;
                        break;

                    case 2:
                        asked.setText("Mora");//blackberry
                        rightAnswer = 2;
                        needsChange = false;
                        break;

                    case 3:
                        asked.setText("Guinda");//cherry
                        rightAnswer = 3;
                        needsChange = false;
                        break;

                    case 4:
                        asked.setText("Maiz"); //corn
                        rightAnswer = 4;
                        needsChange = false;
                        break;

                    case 5:
                        asked.setText("Jalapegno");//Jalapeno
                        rightAnswer = 5;
                        needsChange = false;
                        break;

                    case 6:
                        asked.setText("Limon");
                        rightAnswer = 6;
                        needsChange = false;
                        break;

                    case 7:
                        asked.setText("Arveja");
                        rightAnswer = 7;
                        needsChange = false;
                        break;

                    case 8:
                        asked.setText("Pimienta");
                        rightAnswer = 8;
                        needsChange = false;
                        break;

                    case 9:
                        asked.setText("Ananas");
                        rightAnswer = 9;
                        needsChange = false;
                        break;

                    case 10:
                        asked.setText("Calabaza");
                        rightAnswer = 10;
                        needsChange = false;
                        break;

                    case 11:
                        asked.setText("Tomate");
                        rightAnswer = 11;
                        needsChange = false;
                        break;

                    case 12:
                        asked.setText("Sandia");
                        rightAnswer = 12;
                        needsChange = false;
                        break;

                    default:
                        asked.setText("Default");
                        needsChange = false;
                        break;
                }
            }

            if (resetTimer >= difficultyF) {
                anotherFruit = true;
            }

            if (anotherFruit) {
                anotherFruit = false;
                int random = MathUtils.random(12);
                Gdx.app.log("random", String.valueOf(random));
                switch (random) {
                    case 0:
                        beingShown = 0;
                        foods.get(0).setPosition(cannonX, cannonY);
                        break;

                    case 1:
                        beingShown = 1;
                        foods.get(1).setPosition(cannonX, cannonY);
                        break;

                    case 2:
                        beingShown = 2;
                        foods.get(2).setPosition(cannonX, cannonY);
                        break;

                    case 3:
                        beingShown = 3;
                        foods.get(3).setPosition(cannonX, cannonY);
                        break;

                    case 4:
                        beingShown = 4;
                        foods.get(4).setPosition(cannonX, cannonY);
                        break;
                    case 5:
                        beingShown = 5;
                        foods.get(5).setPosition(cannonX, cannonY);
                        break;

                    case 6:
                        beingShown = 6;
                        foods.get(6).setPosition(cannonX, cannonY);
                        break;

                    case 7:
                        beingShown = 7;
                        foods.get(7).setPosition(cannonX, cannonY);
                        break;

                    case 8:
                        beingShown = 8;
                        foods.get(8).setPosition(cannonX, cannonY);
                        break;

                    case 9:
                        beingShown = 9;
                        foods.get(9).setPosition(cannonX, cannonY);
                        break;

                    case 10:
                        beingShown = 10;
                        foods.get(10).setPosition(cannonX, cannonY);
                        break;

                    case 11:
                        beingShown = 11;
                        foods.get(11).setPosition(cannonX, cannonY);
                        break;

                    case 12:
                        beingShown = 12;
                        foods.get(12).setPosition(cannonX, cannonY);
                        break;

                    default:
                        foods.get(0).setPosition(cannonX, cannonY);
                        break;
                }
            }

            if (poisonLvl >= 100) {
                playerLost = true;
            }


            if (playerLost) {
                if (MyGame.loseScreen == null) {
                    MyGame.loseScreen = new LoseScreen();
                }

                MyGame.PAUSEGAME = true;
                PoisonLabel.setText("0%");
                ScoreLabel.setText("0");
                score = 0;
                poisonLvl = 0;
                playerLost = false;
                MyGame.setActiveScreen(MyGame.loseScreen);
            }

            if (playerWin) {
                if (MyGame.winScreen == null) {
                    MyGame.winScreen = new WinScreen();
                }

                MyGame.PAUSEGAME = true;
                PoisonLabel.setText("0%");
                ScoreLabel.setText("0");
                score = 0;
                poisonLvl = 0;
                playerWin = false;
                MyGame.setActiveScreen(MyGame.winScreen);
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
                MyGame.PAUSEGAME = true;
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
                //dispose();//dispose
                MyGame.PAUSEGAME = true;
                MyGame.setActiveScreen(MyGame.loseScreen);
            }
        });

        asking.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
                Gdx.app.log("Button pressed", "pressed");
                Gdx.app.log("score", String.valueOf(difficulty));
                if(rightAnswer == beingShown)
                {
                    score = score + 250;
                    ScoreLabel.setText(String.format("%03d", score));
                    Gdx.app.log("score", "Score plus plus");
                    resetTimer = 0f;
                    streakCounter++;
                    //needs test
                    anotherFruit = true;
                    if(poisonLvl > 0){
                        Gdx.app.log("score", "TEST");
                        poisonLvl = poisonLvl - 5;
                        PoisonLabel.setText(String.format("%03d", poisonLvl)+"%");
                    }
                }
                else  {
                    Gdx.app.log("poison", "Score minus");
                    poisonLvl = poisonLvl + 25;
                    PoisonLabel.setText(String.format("%03d", poisonLvl)+"%");
                }
                needsChange = true;
            }
        });

        poisonBtn.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
                Gdx.app.log("Button pressed", "pressed");
                resetTimer = 0f;
                anotherFruit = true;
            }
        });

    }

    @Override
    public void pause() {
    MyGame.PAUSEGAME = true;
    }

    @Override
    public void resume() {
        MyGame.PAUSEGAME = false;
    }

    @Override
    public void resize(int width, int height) {

    }
/*
    @Override
    public void dispose() {
        super.dispose();


        //foods = null;
        //uiStage = null;
        //score = 0;
        //playerLost = false;
        //counterStreak = 0;
        //playerWin = false;
        //PoisonLabel.dispose();
        //ScoreLabel.dispose();
        // = null;
        asked.dispose();
        MyGame.gameScreenTestingPlace.dispose();

    }

*/
}
