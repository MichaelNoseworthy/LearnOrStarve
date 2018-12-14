package com.learnorstarve.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by mehol on 2018-11-23.
 */

public class Cannon extends ActorBeta {

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private float rotation;
    private int width;
    private int height;

    private Circle boundingCircle;

    public Cannon(float x, float y, int width, int height) {
        loadTexture("UI/cannon.png");
        this.width = width;
        this.height = height;
        this.setPosition(100,100); //always spawn there
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 460);
        boundingCircle = new Circle();
    }
}
