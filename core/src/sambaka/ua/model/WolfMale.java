package sambaka.ua.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sambaka.ua.control.WolfMaleController;

public class WolfMale extends GameObject {

    private WolfMaleController wolfMaleController;
    public WolfMale(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        wolfMaleController =new WolfMaleController(bounds);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        wolfMaleController.move();
    }
}
