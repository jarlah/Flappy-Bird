package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Bird {
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;

    private Texture texture;
    private Vector3 position;
    private Vector3 velocity;
    private Rectangle bounds;
    private Animation birdAnimation;

    public Bird(int x, int y) {
        this.position = new Vector3(x, y, 0);
        this.velocity = new Vector3(0, 0, 0);
        this.texture = new Texture("birdanimation.png");
        this.birdAnimation = new Animation(new TextureRegion(texture), 3, 0.5f);
        this.bounds = new Rectangle(x, y, texture.getWidth() / 3, texture.getHeight());
    }

    public void update(float dt) {
        birdAnimation.update(dt);
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
        texture.dispose();
    }

    public Vector3 getPosition() {
        return position;
    }

    private Vector3 getVelocity() {
        return velocity;
    }

    public TextureRegion getBird() {
        return birdAnimation.getFrame();
    }

    public void jump() {
        this.velocity.y = 250;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
