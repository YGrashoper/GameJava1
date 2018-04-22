package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Obstacles {

    //additional class for separate obstacle
    class WallPair {
        Vector2 position;
        float speed;
        int offset;
        Rectangle emptySpace;


        public WallPair(Vector2 pos) {
            position = pos;
            speed = 2;
            offset = new Random().nextInt(250);
            emptySpace = new Rectangle(position.x, position.y - offset + 300, 50, betweenDistance);

        }

        public void update() {
            position.x -= speed;
            if (position.x < -50) {
                position.x = 800;
                offset = new Random().nextInt(250);
            }
            emptySpace.x = position.x;
        }
    }

    static WallPair[] obs;
    Texture txt;
    int betweenDistance;

    public Obstacles() {
        txt = new Texture("wall.png");
        obs = new WallPair[4];
        betweenDistance = 250;
        int startPosx = 400;
        for (int i = 0; i < obs.length; i++) {
            obs[i] = new WallPair(new Vector2(startPosx, 0));
            startPosx += 220;
        }
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < obs.length; i++) {
            batch.draw(txt, obs[i].position.x, obs[i].position.y);
            batch.draw(txt, obs[i].position.x, obs[i].position.y + betweenDistance + txt.getHeight() - obs[i].offset);

        }

    }

    public void update() {
        for (int i = 0; i < obs.length; i++) {
            obs[i].update();


        }

    }

    public void recreate() {
        int startPosx = 400;
        for (int i = 0; i < obs.length; i++) {
            obs[i] = new WallPair(new Vector2(startPosx, 0));
            startPosx += 220;
        }


    }
}
