package sambaka.ua.view;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sambaka.ua.model.Grass;
import sambaka.ua.model.Rabbit;
import sambaka.ua.model.WolfFemale;
import sambaka.ua.model.WolfMale;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameScreen implements Screen {
    public static float DELTACFF;
    private static Random random = new Random();
    private Texture grassTexture;
    private Texture wolfMaleTexture;
    private Texture wolfFemaleTexture;
    private Texture rabbitTexture;
    private SpriteBatch batch;
    private Grass grass;
    private OrthographicCamera camera;
    public static CopyOnWriteArrayList<WolfMale> wolfMale;
    public static CopyOnWriteArrayList<WolfFemale> wolfFemale;
    public static CopyOnWriteArrayList<Rabbit> rabbit;


    @Override
    public void show() {
        batch = new SpriteBatch();
        initialGrass();
        initialsWolfsMale();
        initialsWolfsFemale();
        initialsRabbits();
    }

    private void initialGrass() {
        grassTexture = new Texture(Gdx.files.internal("grass.jpg"));
        grass = new Grass(grassTexture, 0, 0, grassTexture.getWidth(), grassTexture.getHeight());
    }

    private void initialsWolfsMale() {
        wolfMaleTexture = new Texture(Gdx.files.internal("wolf.png"));
        wolfMale = new CopyOnWriteArrayList<WolfMale>();
        for (int i = 0; i < 6; i++) {
            wolfMale.add(new WolfMale(wolfMaleTexture, position(), position(), wolfMaleTexture.getWidth(),
                    wolfMaleTexture.getHeight()));
        }
    }

    private void initialsRabbits() {
        rabbitTexture = new Texture(Gdx.files.internal("rabbit.png"));
        rabbit = new CopyOnWriteArrayList<Rabbit>();
        for (int i = 0; i < 1; i++) {
            rabbit.add(new Rabbit(rabbitTexture, position(), position(), rabbitTexture.getWidth(),
                    rabbitTexture.getHeight()));
        }
    }

    private void initialsWolfsFemale() {
        wolfFemaleTexture = new Texture(Gdx.files.internal("wolfFemale.png"));
        wolfFemale = new CopyOnWriteArrayList<WolfFemale>();
        for (int i = 0; i < 6; i++) {
            wolfFemale.add(new WolfFemale(wolfFemaleTexture, position(), position(), wolfFemaleTexture.getWidth(),
                    wolfFemaleTexture.getHeight()));
        }
    }

    public static int position() {
        return random.nextInt(20)*30;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 1, 0.1f, 0.2f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        DELTACFF = delta;
        // batch.setProjectionMatrix(camera.combined);
        batch.begin();
        grass.draw(batch);
        for (WolfMale w : wolfMale
                ) {
            w.draw(batch);
        }
        for (WolfFemale w : wolfFemale
                ) {
            w.draw(batch);
        }
        for (Rabbit r : rabbit
                ) {
            r.draw(batch);
        }
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        float aspectRatio = (float) height / width;
        camera = new OrthographicCamera(10f, 10f * aspectRatio);
        camera.zoom = 60f;
        camera.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }


    @Override
    public void dispose() {
        grassTexture.dispose();
        wolfMaleTexture.dispose();
        wolfFemaleTexture.dispose();
        rabbitTexture.dispose();
        batch.dispose();
    }
}
