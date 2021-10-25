package wall.of.car;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;
        if (rightOrLeftCollision()) {
            xSpeed = -xSpeed;
        }
        if (topOrBottomCollision()) {
            ySpeed = -ySpeed;
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.circle(x, y, size);
    }

    public boolean topOrBottomCollision() {
        if (y + size >= Gdx.graphics.getHeight()) {
            return true;
        }
        else if (y - size <= 0) {
            return true;
        }
        return false;
    }

    public boolean rightOrLeftCollision() {
        if (x + size >= Gdx.graphics.getWidth()) {
            return true;
        }
        else if (x - size <= 0) {
            return true;
        }
        return false;
    }
}
