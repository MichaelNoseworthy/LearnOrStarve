package com.learnorstarve.game.Temp;

/**
 * Created by markapptist on 2018-11-16.
 */

public class StoryScreen extends ScreenBeta2 {

    Scene scene;
    ActorBeta2 continueKey;

    public void initialize() {
        ActorBeta2 background = new ActorBeta2(0, 0, mainStage);
        background.loadTexture("sprites/backgrounds/background0_59.png");
        background.setSize(WIDTH, HEIGHT);
        background.setOpacity(0);
    }

    @Override
    public void update(float dt) {

    }
}
