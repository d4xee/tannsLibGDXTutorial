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
    ArrayList<Block> blocks = new ArrayList<>();

    @Override
    public void create() {
        shape = new ShapeRenderer();
        ball = new Ball(Gdx.graphics.getWidth() >> 1, Gdx.graphics.getHeight() >> 2, 25, 5, 5);
        paddle = new Paddle(Gdx.input.getX(), 20, 10, 100);

        int blockWidth = 55;
        int blockHeight = 20;
        for (int y = Gdx.graphics.getHeight()/2; y < Gdx.graphics.getHeight(); y += blockHeight + 10) {
            for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
                blocks.add(new Block(x, y, blockWidth, blockHeight));
            }
        }
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shape.begin(ShapeRenderer.ShapeType.Filled);
        ball.update();
        ball.checkCollision(paddle);
        for (Block block : blocks) {
            ball.checkCollision(block);
            block.draw(shape);
        }
        ball.draw(shape);
        paddle.update();
        paddle.draw(shape);
        for (int i = 0; i< blocks.size(); i++) {
            Block b = blocks.get(i);
            if (b.destroyed) {
                blocks.remove(b);
                i--;
            }
        }
        shape.end();
    }
}
