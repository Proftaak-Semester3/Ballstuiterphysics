package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Bullet;
import com.mygdx.game.CollisionRect;
import com.mygdx.game.MyGdxGame;

import java.util.ArrayList;

public class Screen1 implements Screen {

    public static final int SPEED = 120;

    Texture img;
    float X;
    float Y;

    MyGdxGame game;

    ArrayList<Bullet> bullets;

    public Screen1(MyGdxGame game)
    {
        this.game = game;
        bullets = new ArrayList<>();
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
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            bullets.add(new Bullet(0, 2));
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

        for (Bullet bullet: bullets) {
            bullet.render(game.batch);
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
