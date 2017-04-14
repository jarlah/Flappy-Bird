package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Bird {
    private static final int GRAVITY = -15;

    private Vector3 position;
    private Vector3 velocity;
    private Texture bird;

    public Bird(int x, int y) {
        this.position = new Vector3(x, y, 0);
        this.velocity = new Vector3(0, 0, 0);
        this.bird = new Texture("bird.png");
    }

    public void update(float dt) {
        this.getVelocity().add(0, GRAVITY, 0);
        this.getVelocity().scl(dt);
        this.getPosition().add(0, this.getVelocity().y, 0);
        this.getVelocity().scl(1/dt);
    }

    public void dispose() {
        bird.dispose();
    }

    public Vector3 getPosition() {
        return position;
    }

    public Vector3 getVelocity() {
        return velocity;
    }

    public Texture getBird() {
        return bird;
    }
}
