package com.mygdx.game.objects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.GameSettings;

import java.util.Random;

public class TrashObject extends GameObject {

    private static final int paddingHorizontal = 30;

    private byte livesLeft;
    Random r;

    @SuppressWarnings("NewApi")
    public TrashObject(int width, int height, String texturePath, World world) {
        super(
                texturePath,
                width / 2 + paddingHorizontal + (new Random()).nextInt((GameSettings.SCREEN_WIDTH - 2 * paddingHorizontal - width)),
                GameSettings.SCREEN_HEIGHT + height / 2,
                width, height,
                GameSettings.TRASH_BIT,
                world
        );
        r = new Random();
        int ySpeed = r.nextInt(-5, 3);
        if (getX() - 360 <= 0) {
            body.setLinearVelocity(new Vector2((r.nextInt(5)), -GameSettings.TRASH_VELOCITY - ySpeed));
        } else {
            body.setLinearVelocity(new Vector2((r.nextInt(-5, 0)), -GameSettings.TRASH_VELOCITY - ySpeed));

        }
        if (r.nextInt(3) == 0) {
            livesLeft = 2;
        } else {
            livesLeft = 1;
        }
    }

    public boolean isAlive() {
        return livesLeft > 0;
    }

    public boolean isInFrame() {
        return getY() + height / 2 > 0;
    }

    @Override
    public void hit() {
        livesLeft -= 1;
    }

    public void updateDuration(){
    }

    public int drop() {
        return -1;
    }
}