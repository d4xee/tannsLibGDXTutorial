package wall.of.car;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;
    Color color = Color.WHITE;

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
        if (rightOrLeftWallCollision()) {
            xSpeed = -xSpeed;
        }
        if (topOrBottomWallCollision()) {
            ySpeed = -ySpeed;
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(x, y, size);
    }

    private boolean topOrBottomWallCollision() {
        if (y + size >= Gdx.graphics.getHeight()) {
            return true;
        }
        else if (y - size <= 0) {
            return true;
        }
        return false;
    }

    private boolean rightOrLeftWallCollision() {
        if (x + size >= Gdx.graphics.getWidth()) {
            return true;
        }
        else if (x - size <= 0) {
            return true;
        }
        return false;
    }

    public void checkCollision(Paddle paddle) {
        if (collidesWith(paddle)) {
            ySpeed = -ySpeed;
        }
    }

    private boolean collidesWith(Paddle paddle) {
        int xCircle;
        int yCircle;

        for (int i = 0; i < 360; i+=5) {
            xCircle = (int) (size *  Math.cos(i)) + x;
            yCircle = (int) (size *  Math.sin(i)) + y;

            if (xCircle == paddle.x
                    && paddle.y <= yCircle
                    && yCircle <= paddle.y + paddle.height) {
                return true;
            }
        }

        for (int i = 0; i < 360; i+=5) {
            xCircle = (int) (size *  Math.cos(i)) + x;
            yCircle = (int) (size *  Math.sin(i)) + y;

            if (yCircle == paddle.y + paddle.height
                    && paddle.x <= xCircle
                    && xCircle <= paddle.x + paddle.width) {
                return true;
            }
        }

        for (int i = 0; i < 360; i+=5) {
            xCircle = (int) (size *  Math.cos(i)) + x;
            yCircle = (int) (size *  Math.sin(i)) + y;

            if (xCircle == paddle.x + paddle.width
                    && paddle.y <= yCircle
                    && yCircle <= paddle.y + paddle.height) {
                return true;
            }
        }

        for (int i = 0; i < 360; i+=5) {
            xCircle = (int) (size *  Math.cos(i)) + x;
            yCircle = (int) (size *  Math.sin(i)) + y;

            if (yCircle == paddle.y
                    && paddle.x <= xCircle
                    && xCircle <= paddle.x + paddle.width) {
                return true;
            }
        }

        return false;
    }
}