package com.learnorstarve.game;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Foods extends ActorBeta {

    private Vector2 velocity;
    private Vector2 acceleration;

    private float rotation;
    private int width;
    private int height;
    private int numberHold;
    private String name;

    private Circle boundingCircle;

    Foods(int number, float x, float y, int width, int height){

        if(number == 0){
            loadTexture("foods/apple.png");
            numberHold = 0;
            this.width = width;
            this.height = height;
            this.setPosition(x,y);
            //this.setScale(0.8f);
            velocity = new Vector2(0, 0);
            acceleration = new Vector2(0, 460);
            boundingCircle = new Circle();
        }
    }

    Foods(int number, int width, int height){

        if(number == 0){
            loadTexture("foods/apple.png");
            this.width = width;
            this.height = height;
            this.setPosition(300,600); //always spawn there
            velocity = new Vector2(0, 0);
            acceleration = new Vector2(0, 460);
            boundingCircle = new Circle();

        }
    }

    Foods(int number){

        if(number == 0){
            loadTexture("foods/apple.png");
            this.width = 100;
            this.height = 100;
            this.setPosition(300,600); //always spawn there
            //this.setScale(0.8f);
            velocity = new Vector2(0, 0);
            acceleration = new Vector2(0, 460);
            boundingCircle = new Circle();
            this.setBoundaryRectangle();

        }
        if(number == 1){
            loadTexture("foods/banana.png");
            this.setScale(0.5f);
            numberHold = 1;
            this.width = 100;
            this.height = 100;
            this.setPosition(300,600); //always spawn there
            //this.setScale(0.4f);
            velocity = new Vector2(0, 0);
            acceleration = new Vector2(0, 460);
            boundingCircle = new Circle();
            this.setBoundaryRectangle();

        }
        if(number == 2){
            loadTexture("foods/blackberry.png");
            numberHold = 2;
            this.width = 100;
            this.height = 100;
            this.setPosition(300,600); //always spawn there
            //this.setScale(0.8f);
            velocity = new Vector2(0, 0);
            acceleration = new Vector2(0, 460);
            boundingCircle = new Circle();
            this.setBoundaryRectangle();

        }
        if(number == 3){
            loadTexture("foods/cherry.png");
            numberHold = 3;
            this.width = 100;
            this.height = 100;
            this.setPosition(300,600); //always spawn there
            //this.setScale(0.8f);
            velocity = new Vector2(0, 0);
            acceleration = new Vector2(0, 460);
            boundingCircle = new Circle();
            this.setBoundaryRectangle();

        }
        if(number == 4){
            loadTexture("foods/corn.png");
            numberHold = 4;
            this.width = 100;
            this.height = 100;
            this.setPosition(300,600); //always spawn there
            //this.setScale(0.8f);
            velocity = new Vector2(0, 0);
            acceleration = new Vector2(0, 460);
            boundingCircle = new Circle();
            this.setBoundaryRectangle();

        }
        if(number == 5){
            loadTexture("foods/jalapeno.png");
            numberHold = 5;
            this.width = 100;
            this.height = 100;
            this.setPosition(100,600); //always spawn there
            //this.setScale(2.0f);
            velocity = new Vector2(0, 0);
            acceleration = new Vector2(0, 460);
            boundingCircle = new Circle();
            this.setBoundaryRectangle();

        }
        if(number == 6){
            numberHold = 6;
            loadTexture("foods/lemon.png");
            this.width = 100;
            this.height = 100;
            this.setPosition(300,600); //always spawn there
            //this.setScale(0.8f);
            velocity = new Vector2(0, 0);
            acceleration = new Vector2(0, 460);
            boundingCircle = new Circle();
            this.setBoundaryRectangle();

        }
        if(number == 7){
            loadTexture("foods/pea.png");
            numberHold = 7;
            this.width = 100;
            this.height = 100;
            this.setPosition(300,600); //always spawn there
            //this.setScale(0.8f);
            velocity = new Vector2(0, 0);
            acceleration = new Vector2(0, 460);
            boundingCircle = new Circle();
            this.setBoundaryRectangle();
        }

        if(number == 8){
            loadTexture("foods/pepper.png");
            numberHold = 8;
            this.width = 100;
            this.height = 100;
            this.setPosition(300,600); //always spawn there
            //this.setScale(0.8f);
            velocity = new Vector2(0, 0);
            acceleration = new Vector2(0, 460);
            boundingCircle = new Circle();
            this.setBoundaryRectangle();
        }

        if(number == 9){
            loadTexture("foods/pineapple.png");
            numberHold = 9;
            this.width = 100;
            this.height = 100;
            this.setPosition(300,600); //always spawn there
            //this.setScale(0.8f);
            velocity = new Vector2(0, 0);
            acceleration = new Vector2(0, 460);
            boundingCircle = new Circle();
            this.setBoundaryRectangle();
        }

        if(number == 10){
            loadTexture("foods/pumpkin.png");
            numberHold = 10;
            this.width = 100;
            this.height = 100;
            this.setPosition(300,600); //always spawn there
            //this.setScale(0.8f);
            velocity = new Vector2(0, 0);
            acceleration = new Vector2(0, 460);
            boundingCircle = new Circle();
            this.setBoundaryRectangle();
        }

        if(number == 11){
            loadTexture("foods/tomato.png");
            numberHold = 11;
            this.width = 100;
            this.height = 100;
            this.setPosition(300,600); //always spawn there
            //this.setScale(0.8f);
            velocity = new Vector2(0, 0);
            acceleration = new Vector2(0, 460);
            boundingCircle = new Circle();
            this.setBoundaryRectangle();
        }

        if(number == 12){
            loadTexture("foods/watermelon.png");
            numberHold = 12;
            this.width = 100;
            this.height = 100;
            this.setPosition(300,600); //always spawn there
            //this.setScale(0.8f);
            velocity = new Vector2(0, 0);
            acceleration = new Vector2(0, 460);
            boundingCircle = new Circle();
            this.setBoundaryRectangle();
        }
    }

    @Override
    public void act(float dt) {
        super.act(dt);

        moveBy(10,30);

    }

}
