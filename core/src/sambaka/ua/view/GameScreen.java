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

public class GameScreen implements Screen {
    public static float DELTACFF;

    private Texture grassTexture;
    private Texture wolfMailTexture;
    private Texture wolfFemaleTexture;
    private SpriteBatch batch;
    private Grass grass;
    private OrthographicCamera camera;
    private WolfMale[] wolfMale;
    private WolfFemale wolfFemale;

    @Override
    public void show() {
        batch = new SpriteBatch();
        grassTexture = new Texture(Gdx.files.internal("grass.jpg"));
        grass = new Grass(grassTexture, 0, 0, grassTexture.getWidth(), grassTexture.getHeight());
        initialsWolfsMail();

        wolfFemaleTexture = new Texture(Gdx.files.internal("wolfFemail.png"));
        wolfFemale = new WolfFemale(wolfFemaleTexture, 100, 100, wolfFemaleTexture.getWidth(), wolfFemaleTexture.getHeight());
    }

    private void initialsWolfsMail() {
        wolfMailTexture = new Texture(Gdx.files.internal("wolf.png"));
        wolfMale = new WolfMale[10];
        for (int i = 0; i < wolfMale.length; i++) {
            wolfMale[i] = new WolfMale(wolfMailTexture, 0, 0, wolfMailTexture.getWidth(), wolfMailTexture.getHeight());
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
        for (WolfMale w:wolfMale
             ){
            w.draw(batch);
        }

        wolfFemale.draw(batch);
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
        wolfMailTexture.dispose();
        wolfFemaleTexture.dispose();
        batch.dispose();
    }
}
