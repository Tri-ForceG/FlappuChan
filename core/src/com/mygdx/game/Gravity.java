package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Admin on 11/30/2015.
 */
public class Gravity implements Screen, InputProcessor{
    SpriteBatch batch;
    Texture bird;
    Texture bg;
    BodyDef bdef;
    FixtureDef fdef;
    OrthographicCamera camera;
     World world;
     Box2DDebugRenderer b2dr;
    Body floor;

    public Gravity (Game game){
        b2dr = new Box2DDebugRenderer();
        batch = new SpriteBatch();

        world = new World(new Vector2(0, -98f), true);
        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {

            }

            @Override
            public void endContact(Contact contact) {

            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {

            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {

            }
        });
        createPlayer();
        createFloor();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

    }
    private void createPlayer() {

       bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        bird = new Texture("bird.png");

        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.position.set(230, 375);

        FixtureDef fdef = new FixtureDef();
        Body body;

        body = world.createBody(bdef);

        shape.setAsBox(bird.getWidth() / 2, bird.getHeight() / 2);;
        fdef = new FixtureDef();
        fdef.shape = shape;
        body.setSleepingAllowed(false);
        body.createFixture(fdef);
        body.setGravityScale(1);
    }
    private void createFloor() { // creating a floor so megaman will not pass through the ground
        bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();

        bdef.position.set(0, 3);
        bdef.type = BodyDef.BodyType.StaticBody;
        floor = world.createBody(bdef);

        shape.setAsBox(Gdx.graphics.getWidth(), 1);
        fdef = new FixtureDef();
        fdef.shape = shape;
        floor.setSleepingAllowed(false);
        floor.createFixture(fdef);
        floor.setGravityScale(0);
    }

    public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        world.step(1 / 60f, 6, 2);
        b2dr.render(world, camera.combined);
        batch.begin();
        batch.draw(bg, 0, 0, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        batch.draw(bird, Gdx.graphics.getWidth() / 2 - bird.getWidth() / 2, Gdx.graphics.getHeight() / 2 - bird.getHeight() / 2);
        System.out.println("Hitler");
        batch.end();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

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

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}

