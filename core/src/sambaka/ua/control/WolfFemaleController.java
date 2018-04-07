package sambaka.ua.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Polygon;
import sambaka.ua.model.Rabbit;
import sambaka.ua.model.WolfFemale;
import sambaka.ua.model.WolfMale;
import sambaka.ua.view.GameScreen;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class WolfFemaleController extends WolfController {
    private Random r = new Random();
    private WolfFemale wolfFemale;
    private CopyOnWriteArrayList<WolfFemale> f = GameScreen.wolfFemale;
    private CopyOnWriteArrayList<WolfMale> m = GameScreen.wolfMale;

    public WolfFemaleController(Polygon bounds, WolfFemale wolfFemale) {
        super(bounds);
        this.wolfFemale = wolfFemale;
    }

    //проверить текущие положение и если там самец родить случайное потомство
    public void checkedIsMale() {
        if (f.size() > 20 || m.size() > 20 || wolfFemale.getHealth()<20)
            return;
        for (WolfMale t : GameScreen.wolfMale
                ) {
            if (isMale(t)) {
                create();
                move();
            }
        }
    }


    //проверка условие на самца
    private boolean isMale(WolfMale t) {
        return (t.getBounds().getX() == bounds.getX()) &&
                (t.getBounds().getY() == bounds.getY());
    }

    // родить случайное потомство
    private void create() {
        if (r.nextInt(101) >= 50) {
            Texture wolfMaleTexture = new Texture(Gdx.files.internal("wolf.png"));
            m.add(new WolfMale(wolfMaleTexture, bounds.getX(), bounds.getY(),
                    wolfMaleTexture.getWidth(), wolfMaleTexture.getHeight()));
        } else {
            Texture wolfFemaleTexture = new Texture(Gdx.files.internal("wolfFemale.png"));
            f.add(new WolfFemale(wolfFemaleTexture, bounds.getX(), bounds.getY(),
                    wolfFemaleTexture.getWidth(), wolfFemaleTexture.getHeight()));
        }
    }

    @Override
    protected void eat() {

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
                wolfFemale.setHealth(30);
                System.out.println("*************");
            }
        }

    }

    private boolean isRabbit(Rabbit r) {
        return (r.getBounds().getX() == bounds.getX()) &&
                (r.getBounds().getY() == bounds.getY());
    }

    public void changeHealth() {
        wolfFemale.setYears(1);
        wolfFemale.setHealth(-2);
        if (wolfFemale.getHealth() <= 0 || wolfFemale.getYears() > wolfFemale.getMaxYearLife()) {
            die();
        }
    }

    private void die() {
        f.remove(f.indexOf(this) + 1);
        System.out.println("Самка умерла "+wolfFemale.getYears());
    }
}
