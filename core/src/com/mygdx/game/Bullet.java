package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class Bullet {

    public static final int SPEED = 700;
    private static Texture texture;
    CollisionRect rect;
    World world;

    float x, y;
    double down = 0.955;
    double Height = 1;

    public boolean remove = false;

    public Bullet (float x, float y){
        this.x = x;
        this.y = y;
        world = new World(new Vector2(0, -9.81f), true);

        this.rect = new CollisionRect(x, y, 80, 80);
        if(texture == null)
        {
            texture = new Texture("Tennis-Ball.png");
        }
    }

    public void update(float deltaTime){
        x = x + 10;
        if(y > Gdx.graphics.getHeight() || x > Gdx.graphics.getWidth())
        {
            remove = true;
        }
        rect.move(x, y);
    }

    public void render(SpriteBatch batch)
    {
        batch.draw(texture, x, y, 80, 80);
    }

    public CollisionRect getCollisionRect ()
    {
        return rect;
    }
}
