package com.mygdx.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {
    OrthographicCamera cam;
    Vector3 mouse;
    GameStateManager gsm;

    State(GameStateManager gsm) {
        this.gsm = gsm;
        cam = new OrthographicCamera();
        mouse = new Vector3();
    }

    abstract void handleInput();
    abstract void update(float dt);
    abstract void render(SpriteBatch sb);
    abstract void dispose();
}
