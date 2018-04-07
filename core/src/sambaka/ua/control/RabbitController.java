package sambaka.ua.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Polygon;
import sambaka.ua.model.Rabbit;

import sambaka.ua.view.GameScreen;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class RabbitController extends GameObjectController {
    private CopyOnWriteArrayList r = GameScreen.rabbit;
    private Rabbit rabbit;
    private Random random;

    public RabbitController(Polygon bounds, Rabbit rabbit) {
        super(bounds);
        this.rabbit = rabbit;
        random = new Random();
    }

    public void die() {
        r.remove(r.indexOf(this) + 1);

    }

    public void changeYears() {
        rabbit.setYears(1);
        if (rabbit.getYears() >= rabbit.getMaxYearLife()) {
            die();
        }
    }

    public void checkedIsCreate() {
        if (r.size() > 20)
            return;
        create();
        move();
    }




    // родить случайное потомство
    private void create() {
        if (random.nextInt(101) >= 80) {
            Texture rabbitTexture = new Texture(Gdx.files.internal("rabbit.png"));
            r.add(new Rabbit(rabbitTexture, GameScreen.position(), GameScreen.position(),
                    rabbitTexture.getWidth(), rabbitTexture.getHeight()));
        }
    }

}
