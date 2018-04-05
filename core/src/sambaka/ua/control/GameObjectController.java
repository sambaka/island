package sambaka.ua.control;

import com.badlogic.gdx.math.Polygon;

import java.util.Random;

public class GameObjectController {
    Polygon bounds;
    private Random r = new Random();
    private float posX;
    private float posY;


    public GameObjectController(Polygon bounds) {
        this.bounds = bounds;
        this.posX = bounds.getX();
        this.posY = bounds.getY();
    }

    private int generateDxDy(int min, int max) {
        return r.nextInt(max - min + 1) + min;
    }

    //рандомное перемещение по клеткам
    public void move() {
        if (posX <= 0) {
            posX += 30f * generateDxDy(0, 1);
        } else if (posX >= 570f) {
            posX += 30f * generateDxDy(-1, 0);
        } else {
            posX += 30f * generateDxDy(-1, 1);
        }
        if (posY <= 0) {
            posY += 30f * generateDxDy(0, 1);
        } else if (posY >= 570f) {
            posY += 30 * generateDxDy(-1, 0);
        } else {
            posY += 30 * generateDxDy(-1, 1);
        }
        bounds.setPosition(posX, posY);
    }

    public void handle() {
        // wolfBounds.setPosition(wolfBounds.getX(), wolfBounds.getY() + 0.2f * GameScreen.DELTACFF);

    }
}
