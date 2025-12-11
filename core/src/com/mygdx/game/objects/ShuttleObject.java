package com.mygdx.game.objects;

import static java.lang.Math.abs;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.GameSettings;

import java.util.Random;

public class ShuttleObject extends TrashObject{
    Random r;
    int bound;
    int duration = -1;
    int livesLeft;
    int danger;
    static int dropType;

    public ShuttleObject(int width, int height, String texturePath, World world) {
        super(width, height, texturePath, world);
        r = new Random();
        danger = r.nextInt(3) + 1;
        body.setLinearVelocity(new Vector2(0, -GameSettings.TRASH_VELOCITY - r.nextInt(30 * danger)));
        livesLeft = danger;
        dropType = r.nextInt(3);
        bound = abs(360 - getX());
        if (360 <= getX()){
            duration = -1;
        }
    }

    public void updateDuration() {
        body.setLinearVelocity(new Vector2(10 * duration, -GameSettings.TRASH_VELOCITY));
        if (getX() > 360 + bound || getX() < 360 - bound) {
            setX(getX() + 10 * duration * -1);
            duration *= -1;
        }
    }

    public void hit() {
        livesLeft -= 1;
    }

    public boolean isAlive() {
        return livesLeft > 0;
    }

    public int drop(){
        return dropType;
    }
}
