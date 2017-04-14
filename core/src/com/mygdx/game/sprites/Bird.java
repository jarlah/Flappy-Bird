package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Bird {
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;

    private Vector3 position;
    private Vector3 velocity;
    private Texture bird;
    private Rectangle bounds;

    public Bird(int x, int y) {
        this.position = new Vector3(x, y, 0);
        this.velocity = new Vector3(0, 0, 0);
        this.bird = new Texture("bird.png");
        this.bounds = new Rectangle(x, y, bird.getWidth(), bird.getHeight());
    }

    public void update(float dt) {
        if(this.position.y > 0) {
            this.getVelocity().add(0, GRAVITY, 0);
        }
        this.getVelocity().scl(dt);
        this.getPosition().add(MOVEMENT * dt, this.getVelocity().y, 0);
        if (this.position.y < 0) {
            this.position.y = 0;
        }
        this.getVelocity().scl(1/dt);
        bounds.setPosition(position.x, position.y);
    }

    public void dispose() {
        bird.dispose();
    }

    public Vector3 getPosition() {
        return position;
    }

    private Vector3 getVelocity() {
        return velocity;
    }

    public Texture getBird() {
        return bird;
    }

    public void jump() {
        this.velocity.y = 250;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
