package sambaka.ua.view;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sambaka.ua.model.Grass;
import sambaka.ua.model.WolfFemale;
import sambaka.ua.model.WolfMale;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameScreen implements Screen {
    public static float DELTACFF;

    private Texture grassTexture;
    private Texture wolfMaleTexture;
    private Texture wolfFemaleTexture;
    private SpriteBatch batch;
    private Grass grass;
    private OrthographicCamera camera;
    public static CopyOnWriteArrayList<WolfMale> wolfMale;
    public static CopyOnWriteArrayList<WolfFemale> wolfFemale;

    @Override
    public void show() {
        batch = new SpriteBatch();
        initialGrass();
        initialsWolfsMale();
        initialsWolfsFemale();
    }

    private void initialGrass() {
        grassTexture = new Texture(Gdx.files.internal("grass.jpg"));
        grass = new Grass(grassTexture, 0, 0, grassTexture.getWidth(), grassTexture.getHeight());
    }

    private void initialsWolfsMale() {
        wolfMaleTexture = new Texture(Gdx.files.internal("wolf.png"));
        wolfMale = new CopyOnWriteArrayList<WolfMale>();
        for (int i = 0; i < 1; i++) {
            wolfMale.add(new WolfMale(wolfMaleTexture, 0, 0, wolfMaleTexture.getWidth(), wolfMaleTexture.getHeight()));
        }
    }

    private void initialsWolfsFemale() {
        wolfFemaleTexture = new Texture(Gdx.files.internal("wolfFemale.png"));
        wolfFemale=new CopyOnWriteArrayList<WolfFemale>();
        for (int i = 0; i < 1; i++) {
            wolfFemale.add(new WolfFemale(wolfFemaleTexture, 90, 90, wolfFemaleTexture.getWidth(), wolfFemaleTexture.getHeight()));
        }
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
        for (WolfFemale w:wolfFemale
             ) {
            w.draw(batch);
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
        batch.dispose();
    }
}
