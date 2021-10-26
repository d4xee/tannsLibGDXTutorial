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
        checkCollision(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
        checkCollision(paddle.x, paddle.y, paddle.width, paddle.height);
    }

    public void checkCollision(Block block) {
        checkCollision(block.x, block.y, block.width, block.height);
        if (collidesWith(block.x, block.y, block.width, block.height) != Collision.NO_COLLISION) {
            block.destroyed = true;
        }
    }

    private void checkCollision(int x, int y, int width, int height) {
        if (collidesWith(x, y, width, height) == Collision.LEFT_SIDE) {
            xSpeed = -xSpeed;
        }
        else if (collidesWith(x, y, width, height) == Collision.TOP_SIDE) {
            ySpeed = -ySpeed;
        }
        else if (collidesWith(x, y, width, height) == Collision.RIGHT_SIDE) {
            xSpeed = -xSpeed;
        }
        else if (collidesWith(x, y, width, height) == Collision.BOTTOM_SIDE) {
            ySpeed = -ySpeed;
        }
    }

    private int collidesWith(int x, int y, int width, int height) {
        int xCircle;
        int yCircle;

        for (int i = 0; i < 360; i+=5) {
            xCircle = (int) (size *  Math.cos(i)) + this.x;
            yCircle = (int) (size *  Math.sin(i)) + this.y;

            if (xCircle == x
                    && y <= yCircle
                    && yCircle <= y + height) {
                return Collision.LEFT_SIDE;
            }
            else if (yCircle == y + height
                    && x <= xCircle
                    && xCircle <= x + width) {
                return Collision.TOP_SIDE;
            }
            else if (xCircle == x + width
                    && y <= yCircle
                    && yCircle <= y + height) {
                return Collision.RIGHT_SIDE;
            }
            else if (yCircle == y
                    && x <= xCircle
                    && xCircle <= x + width) {
                return Collision.BOTTOM_SIDE;
            }
        }

        return Collision.NO_COLLISION;
    }
}