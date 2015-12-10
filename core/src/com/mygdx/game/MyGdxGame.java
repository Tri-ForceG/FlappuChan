package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
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

public class MyGdxGame extends Game {
	public static final int WIDTH = 460;
	public static final int HEIGHT = 750;
	public static final String TITLE = "Dank Bird";


	@Override
	public void create() {
		setScreen(new Gravity(this));
	}

	@Override
	public void render () {
		super.render();
		//Gdx.gl.glClearColor(1, 0, 0, 1);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//world.step(1/ 60f, 6, 2);
		//b2dr.render(world, camera.combined);
		//batch.begin();
		//batch.draw(bg, 0, 0, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
		//batch.draw(bird, Gdx.graphics.getWidth() / 2 - bird.getWidth() / 2, Gdx.graphics.getHeight() / 2 - bird.getHeight() / 2);
		//batch.end();
	}
}
