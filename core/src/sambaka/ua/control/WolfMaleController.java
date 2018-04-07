package sambaka.ua.control;


import com.badlogic.gdx.math.Polygon;
import sambaka.ua.model.Rabbit;
import sambaka.ua.model.WolfMale;
import sambaka.ua.view.GameScreen;

import java.util.concurrent.CopyOnWriteArrayList;

public class WolfMaleController extends WolfController {
    private CopyOnWriteArrayList<WolfMale> m = GameScreen.wolfMale;
    // private CopyOnWriteArrayList<Rabbit> r = GameScreen.rabbit;
    private WolfMale wolfMale;

    public WolfMaleController(Polygon bounds, WolfMale wolfMale) {
        super(bounds);
        this.wolfMale = wolfMale;
    }

    @Override
    protected void eat() {
        wolfMale.setHealth(30);
    }

    @Override
    protected void look() {

    }

    @Override
    public void hunt() {

        for (Rabbit t : GameScreen.rabbit
                ) {
            if (isRabbit(t)) {
                t.die();
                wolfMale.setHealth(20);
                System.out.println("!!!!!!!!!");
            }
        }


    }

    private boolean isRabbit(Rabbit r) {
        return (r.getBounds().getX() == bounds.getX()) &&
                (r.getBounds().getY() == bounds.getY());
    }

    @Override
    public void changeHealth() {
        wolfMale.setYears(1);
        wolfMale.setHealth(-2);
        if (wolfMale.getHealth() <= 0 || wolfMale.getYears() > wolfMale.getMaxYearLife()) {
            die();
        }
    }

    private void die() {
        m.remove(m.indexOf(this) + 1);
        System.out.println("Самец умер "+wolfMale.getYears());
    }
}
