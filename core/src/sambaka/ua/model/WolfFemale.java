package sambaka.ua.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sambaka.ua.control.WolfFemaleController;

public class WolfFemale extends Wolf{
    private WolfFemaleController wolfFemaleController;
    public WolfFemale(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        wolfFemaleController =new WolfFemaleController(bounds,this);
    }

    public void draw(SpriteBatch batch) {
        super.draw(batch);
        wolfFemaleController.hunt();
        wolfFemaleController.checkedIsMale();
        wolfFemaleController.move();
        wolfFemaleController.changeHealth();

    }
}
