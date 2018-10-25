package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

/**
 *  Extend the Actor class to include graphics and collision detection.
 *  Actor class stores data such as position and rotation.
 */
public class ActorBeta extends Actor
{
    private TextureRegion textureRegion;
    private Rectangle rectangle;

    private Animation<TextureRegion> animation;
    private float elapsedTime;
    private boolean animationPaused;

    private Polygon boundaryPolygon;

    public ActorBeta()
    {
        super();
        textureRegion = new TextureRegion();
        rectangle = new Rectangle();
        animation = null;
        elapsedTime = 0;
        animationPaused = false;
        boundaryPolygon = null;
    }

    public ActorBeta(float x, float y, Stage s) {

        super();

        setPosition(x, y);
        s.addActor(this);

        textureRegion = new TextureRegion();
        rectangle = new Rectangle();

        animation = null;
        elapsedTime = 0;
        animationPaused = false;
        boundaryPolygon = null;


    }

    public void setTexture(Texture t)
    {
        textureRegion.setRegion(t);
        this.setSize( t.getWidth(), t.getHeight() );
        rectangle.setSize(t.getWidth(), t.getHeight());
    }

    public Rectangle getRectangle()
    {
        rectangle.setPosition( this.getX(), this.getY() );
        return rectangle;
    }
    
    public boolean overlaps(ActorBeta other)
    {
        return this.getRectangle().overlaps( other.getRectangle() );
    }


    //Stage will automatically call Actor class
    public void act(float dt)
    {
        super.act(dt);


        if (!animationPaused)
            elapsedTime += dt;
    }
    
    public void draw(Batch batch, float parentAlpha) 
    {

        Color c = getColor(); // used to apply tint color effect

        batch.setColor(c.r, c.g, c.b, c.a);

        if (animation != null && isVisible() )
            batch.draw( animation.getKeyFrame(elapsedTime),
                getX(), getY(), getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation() );

        super.draw( batch, parentAlpha );

    }

    /* Animation methods */

    public void setAnimation(Animation<TextureRegion> anim) {
        animation = anim;
        TextureRegion tr = animation.getKeyFrame(0);
        float w = tr.getRegionWidth();
        float h = tr.getRegionHeight();

        setSize(w, h);
        setOrigin(w/2, h/2);
    }

    /* Animation methods for multiple images */

    public Animation<TextureRegion> loadAnimationFromFiles(String[] fileNames, float frameDuration, boolean loop)
    {
        //Number of images to read
        int fileCount = fileNames.length;

        //Create empty TextureRegion array
        Array<TextureRegion> textureArray = new Array<TextureRegion>();

        //For the number of images, add them back into the array
        for (int n = 0; n < fileCount; n++) {
            String fileName = fileNames[n];
            //Create new texture with fileName at n
            Texture texture = new Texture(Gdx.files.internal(fileName));
            //Set Linear filter
            texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            //Add this textures to the Array
            textureArray.add(new TextureRegion(texture));
        }

        //Instantiate animation object while passing in array and duration of each frame
        Animation<TextureRegion> anim = new Animation<TextureRegion>(frameDuration, textureArray);

        //if loop is true, set LOOP ON
        if (loop)
            anim.setPlayMode(Animation.PlayMode.LOOP);

        //else, no looping
        else
            anim.setPlayMode(Animation.PlayMode.NORMAL);

        //if animation is null, set the animation to a default state
        if (animation == null)
            setAnimation(anim);

        return anim;
    }

    /* Animation from sprite sheet */

    public Animation<TextureRegion> loadAnimationFromSheet(String fileName,
                                                           int rows,
                                                           int cols,
                                                           float frameDuration,
                                                           boolean loop)
    {
        //instantiate new Texture from file
        Texture texture = new Texture(Gdx.files.internal(fileName), true);

        //set Texture filter to Linear
        /*
        Linear will do edges smooth but it is possible that it will be producing some weird
        artifacts on connections between tiles of element created from many smaller sprites
        - also can cause problems with big textures

        Nearest will do edges sharp which will be very bad for some circles

        MipMap connects pros of Lienar and Nearest but will need more space for many versions
        of sprite
         */

        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);


        //set frame width and height by dividing rows and columns
        int frameWidth = texture.getWidth() / cols;
        int frameHeight = texture.getHeight() / rows;

        //@return a 2D array of TextureRegions indexed by [row][column].
        TextureRegion[][] temp = TextureRegion.split(texture, frameWidth, frameHeight);

        //create new texture array region
        Array<TextureRegion> textureArray = new Array<TextureRegion>();

        //for the number of rows and columns add to temp array
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                textureArray.add(temp[r][c]);

        //new animation object created from frame duration and texture array
        Animation<TextureRegion> anim = new Animation<TextureRegion>(frameDuration, textureArray);

        //if loop on LOOP animation
        if (loop)
            anim.setPlayMode(Animation.PlayMode.LOOP);

        else
            anim.setPlayMode(Animation.PlayMode.NORMAL);

        if (animation == null)
            setAnimation(anim);

        return anim;
    }

    /* Animation for single image */

    public Animation<TextureRegion> loadTexture(String fileName)
    {
        //set a new array of file names to a capacity of 1
        String[] fileNames = new String[1];

        //first image in array will be file name
        fileNames[0] = fileName;

        //return anim object from first animation method that will load a single image
        return loadAnimationFromFiles(fileNames, 1, true);
    }

    /* Check to see if animation is finished */

    public boolean isAnimationFinished()
    {
        return animation.isAnimationFinished(elapsedTime);
    }

    public void setAnimationPaused(boolean pause) {
        animationPaused = pause;
    }

    public void setBoundaryPolygon(int numSides)
    {
        float w = getWidth();
        float h = getHeight();

        float[] vertices = new float[2*numSides];
        for (int i = 0; i < numSides; i++)
        {
            float angle = i * 6.28f / numSides;
            // x-coordinate
            vertices[2*i] = w/2 * MathUtils.cos(angle) + w/2;
            // y-coordinate
            vertices[2*i+1] = h/2 * MathUtils.sin(angle) + h/2;
        }
        boundaryPolygon = new Polygon(vertices);

    }
}