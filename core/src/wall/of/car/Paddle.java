package wall.of.car;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    int x;
    int y;
    int height;
    int width;

    public Paddle(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public void update() {
        x = Gdx.input.getX();
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }
}
