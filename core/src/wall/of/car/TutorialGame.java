package wall.of.car;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Random;

public class TutorialGame extends ApplicationAdapter {
    ShapeRenderer shape;
    Ball ball;
    Paddle paddle;

    @Override
    public void create() {
        shape = new ShapeRenderer();
        ball = new Ball(Gdx.graphics.getWidth() >> 1, Gdx.graphics.getHeight() >> 1, 25, 7, 7);
        paddle = new Paddle(Gdx.input.getX(), 20, 10, 100);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shape.begin(ShapeRenderer.ShapeType.Filled);
        ball.update();
        ball.checkCollision(paddle);
        ball.draw(shape);
        paddle.update();
        paddle.draw(shape);
        shape.end();
    }
}
