package sambaka.ua.view;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sambaka.ua.model.Grass;
import sambaka.ua.model.WolfMale;

public class GameScreen implements Screen {
    private Texture grassTexture;
    private Texture wolfMailTexture;
    private SpriteBatch batch;
    private Grass grass;
    private OrthographicCamera camera;
    private WolfMale wolf;

    @Override
    public void show() {
        batch = new SpriteBatch();
        grassTexture = new Texture(Gdx.files.internal("grass.jpg"));
        grass = new Grass(grassTexture, 0, 0, grassTexture.getWidth(), grassTexture.getHeight());
        wolfMailTexture =new Texture(Gdx.files.internal("wolf.png"));
        wolf=new WolfMale(wolfMailTexture,0,0,wolfMailTexture.getWidth(),wolfMailTexture.getHeight());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 1, 0.1f, 0.2f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
       // batch.setProjectionMatrix(camera.combined);
        batch.begin();
        grass.draw(batch);
        wolf.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        float aspectRatio = (float) height / width;
        camera=new OrthographicCamera(10f,10f*aspectRatio);
        camera.zoom=60f;
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
        batch.dispose();
    }
}
