package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Bullet;
import com.mygdx.game.CollisionRect;
import com.mygdx.game.MyGdxGame;

import java.util.ArrayList;

public class Screen1 implements Screen {
    Texture img;
    Texture wall;

    float X;
    float Y;

    MyGdxGame game;

    CollisionRect rect;

    ArrayList<Bullet> bullets;

    public Screen1(MyGdxGame game)
    {
        this.game = game;
        bullets = new ArrayList<>();
        wall =  new Texture("BrickWall.jpg");
        rect = new CollisionRect(1750, 0, 100, 900);
    }

    @Override
    public void show() {
        img = new Texture("badlogic.jpg");
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
        {
            Gdx.app.exit();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) || Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            bullets.add(new Bullet(0, 2, Gdx.input.getX(), Gdx.input.getY()));
        }

        ArrayList<Bullet> bulletToRemove = new ArrayList<>();

        for (Bullet bullet: bullets) {
            bullet.update(delta);
            if(bullet.remove)
            {
                bulletToRemove.add(bullet);
            }
        }

        bullets.removeAll(bulletToRemove);

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.batch.draw(wall, 1750, 0, 100, 900);

        for (Bullet bullet: bullets) {
            bullet.render(game.batch);
            if(rect.collidesWith(bullet.getCollisionRect()))
            {
                Vector3 vector3 = bullet.GetVelocity();
                Vector3 bounced = new Vector3();
                bounced.x = -vector3.x + 5;
                bounced.y = vector3.y;
                bullet.updateVelocity(bounced);
            }
        }

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
