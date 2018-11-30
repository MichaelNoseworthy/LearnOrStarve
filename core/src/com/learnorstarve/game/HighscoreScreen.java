package com.learnorstarve.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Align;
import com.learnorstarve.game.MyGame;
import com.learnorstarve.game.ScreenBeta;

/**
 * Created by mehol on 2018-11-18.
 */

public class HighscoreScreen extends ScreenBeta {
    /**
     * Created by mehol on 2018-11-18.
     */

    TextButton toMainMenu;
    Image highscore;
    Label label1;
    Label HighscoreTable[];
    String HighscoreArray[];

    @Override
    public void initialize() {

        highscore = new Image(new Texture("UI/highscores.png"));
        uiStage.addActor(tableContainer);

        HighscoreArray = new String[]{
                "King ","30",
                "Queen ","25",
                "Princess ","20",
                "Prince ","15",
                "Knight ","10",
                "Archer ","5",
                "Peasant ","1",
                "Peasant ","1",
                "Peasant ","1",
                "Peasant ","1"};
        HighscoreTable = new Label[10];
        for(int i = 0; i < HighscoreTable.length; i++)
        {
            HighscoreTable[i] = new Label(Integer.toString(i+1)+ HighscoreArray[2*i]+HighscoreArray[2*i+1],labelStyle);
            HighscoreTable[i].setOrigin(Align.center);
            HighscoreTable[i].setFontScale(2);
        };

        toMainMenu = new TextButton("Main Menu", skin.get(("default"), TextButton.TextButtonStyle.class));
        toMainMenu.setOrigin(Align.center);
        toMainMenu.setTransform(true);
        toMainMenu.setScale(3);

        label1 = new Label("LABEL", labelStyle);
        label1.setPosition(WIDTH/2-400, HEIGHT/2+500);
        label1.setScale(1);
        label1.setFontScale(1);
        label1.setText("Place holder for scores");

        setUpButton();


        uiTable.add(highscore).size(highscore.getWidth(),highscore.getHeight());
        uiTable.row().pad(HEIGHT/50);
        //highscoreButton.setPosition(WIDTH/2-260, HEIGHT-135);

        //uiTable.add(label1).size(label1.getWidth(), label1.getHeight());        uiTable.row().padTop(HEIGHT / 25).padBottom(HEIGHT/25);
        for (int i = 0; i < HighscoreTable.length; i++) {
            uiTable.add(HighscoreTable[i]).size(HighscoreTable[i].getPrefWidth(), HighscoreTable[i].getPrefHeight());
            uiTable.row().padTop(HEIGHT / 100).padBottom(HEIGHT / 100);
        }

        uiTable.add(toMainMenu).size(toMainMenu.getWidth(), toMainMenu.getHeight());

    }

    public void setUpButton() {

        toMainMenu.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Yay?","+1");
                super.touchDown(event, x, y, pointer, button);
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

    public void updateTable(String newA[]) {
        HighscoreArray = newA;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        super.touchUp(screenX, screenY, pointer, button);

        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        super.touchDragged(screenX, screenY, pointer);

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
