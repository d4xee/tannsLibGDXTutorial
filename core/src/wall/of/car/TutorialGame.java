package wall.of.car;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class TutorialGame extends ApplicationAdapter {
    ShapeRenderer shape;
    Ball ball;

    @Override
    public void create() {
        shape = new ShapeRenderer();
        ball = new Ball(150, 200, 70, 12, 5);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        ball.update();
        shape.begin(ShapeRenderer.ShapeType.Filled);
        ball.draw(shape);
        shape.end();
    }
}
