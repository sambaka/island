package sambaka.ua.model;

import com.badlogic.gdx.graphics.Texture;

public class Wolf extends GameObject {
    private final int maxYearLife = 60;
    private int health;
    private int years;

    public Wolf(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        this.years = 0;
        this.health = 70;
    }

    public int getYears() {
        return years;
    }

    public int getMaxYearLife() {
        return maxYearLife;
    }

    public void setYears(int change) {
        years += change;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int change) {
        this.health += change;
    }


}
