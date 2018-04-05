package sambaka.ua.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Polygon;
import sambaka.ua.model.WolfFemale;
import sambaka.ua.model.WolfMale;
import sambaka.ua.view.GameScreen;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class WolfFemaleController extends WolfController {
    private Random r = new Random();
    private CopyOnWriteArrayList<WolfFemale> f = GameScreen.wolfFemale;
    private CopyOnWriteArrayList<WolfMale> m = GameScreen.wolfMale;

    public WolfFemaleController(Polygon bounds) {
        super(bounds);
    }

    public void checkedIsMale() {
        boolean flag=false;
        for (WolfMale t : GameScreen.wolfMale
                ) {
            if (isMale(t)) {
                flag=true;
            }
        }
        if(flag){
            create();
        }
    }


    private boolean isMale(WolfMale t) {
        return (t.getBounds().getX() == bounds.getX()) &&
                (t.getBounds().getY() == bounds.getY());
    }

    private void create() {
        if (r.nextInt(101) >= 50) {
            Texture wolfMaleTexture = new Texture(Gdx.files.internal("wolf.png"));
            m.add(new WolfMale(wolfMaleTexture, 120, 120,
                    wolfMaleTexture.getWidth(), wolfMaleTexture.getHeight()));
        } else {
            Texture wolfFemaleTexture = new Texture(Gdx.files.internal("wolfFemale.png"));
            f.add(new WolfFemale(wolfFemaleTexture, 90, 90,
                    wolfFemaleTexture.getWidth(), wolfFemaleTexture.getHeight()));
            System.out.println("Самка");
        }
    }
}
