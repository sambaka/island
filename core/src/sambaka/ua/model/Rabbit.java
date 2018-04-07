package sambaka.ua.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sambaka.ua.control.RabbitController;

public class Rabbit extends GameObject {
    private int maxYearLife=20;

    private int years=0;

    private RabbitController rabbitController;
    public Rabbit(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        rabbitController=new RabbitController(bounds,this);
    }
    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        rabbitController.move();
        rabbitController.changeYears();
        rabbitController.checkedIsCreate();
    }

    public int getYears() {
        return years;
    }

    public void setYears(int change) {
        this.years +=change;
    }

    public int getMaxYearLife() {
        return maxYearLife;
    }
    public void die(){
        rabbitController.die();
    }
}
