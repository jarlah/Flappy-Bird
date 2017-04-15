package com.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
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
    private Sound flap;
    public boolean colliding;

    public Bird(int x, int y) {
        this.position = new Vector3(x, y, 0);
        this.velocity = new Vector3(0, 0, 0);
        this.texture = new Texture("birdanimation.png");
        this.birdAnimation = new Animation(new TextureRegion(texture), 3, 0.5f);
        this.bounds = new Rectangle(x, y, texture.getWidth() / 3, texture.getHeight());
        this.flap = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
    }

    public void update(float dt) {
        birdAnimation.update(dt);
        if(this.position.y > 0) {
            this.velocity.add(0, GRAVITY, 0);
        }
        this.velocity.scl(dt);
        if (!colliding) {
            this.position.add(MOVEMENT * dt, this.velocity.y, 0);
        }
        if (this.position.y < 62) {
            this.position.y = 62;
        }
        this.velocity.scl(1/dt);
        bounds.setPosition(position.x, position.y);
    }

    public void dispose() {
        texture.dispose();
        flap.dispose();
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getBird() {
        return birdAnimation.getFrame();
    }

    public void jump() {
        this.velocity.y = 250;
        flap.play(0.5f);
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
