package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bird {
    //picture
    Texture img;
    //position of image
    Vector2 position;

    float vy;
    float gravity;
//constructor for bird, choose which image we use and it's size
    public Bird() {
        img = new Texture("bird1.png");
        position = new Vector2(100, 380);
        vy=0;
        gravity=-0.7f;

    }

    public void render(SpriteBatch batch) {

        batch.draw(img, position.x, position.y);



    }

    public void update() {


    if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
        vy=10;
    }
        vy+=gravity;
        position.y+=vy;
    }
public void recreate(){
        position=new Vector2(100,300);
        vy=0;
}

}
