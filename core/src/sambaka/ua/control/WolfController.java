package sambaka.ua.control;

import com.badlogic.gdx.math.Polygon;

public abstract class WolfController extends GameObjectController {
    public WolfController(Polygon bounds) {
        super(bounds);
    }

    protected abstract void eat();

    protected abstract void look();

    public abstract void hunt();

    protected abstract void changeHealth();
}
