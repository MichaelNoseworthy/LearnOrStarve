package com.learnorstarve.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by mehol on 2018-11-23.
 */

public class Cannon extends ActorBeta {

    Cannon()
    {
    loadTexture("UI/cannon.png");
        this.setBoundaryRectangle();
    }
}
