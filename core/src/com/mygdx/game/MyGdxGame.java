package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class MyGdxGame extends ApplicationAdapter {
	public static final int WIDTH = 460;
	public static final int HEIGHT = 750;
	public static final String TITLE = "Dank Bird";

	SpriteBatch batch;
	Texture bird;
	Texture bg;

	private Vector2 position;
	private Vector2 velocity;
	private static final int GRAVITY = -15;

	public MyGdxGame (int x, int y) {
		position = new Vector2(x, y);
		velocity = new Vector2(0,0);
		bird = new Texture("bird.png");
	}
	public MyGdxGame() {
		int x = 0;
		int y = 20;
		position = new Vector2(x, y);
		velocity = new Vector2(0,0);
//		bird = new Texture("bird.png");
		System.out.println("Test");
	}
	public void update (float dt) {
		velocity.add(0, GRAVITY);
		velocity.scl(dt);
		position.add(0, velocity.y);

		velocity.scl(1 / dt);
	}

	
	@Override
	public void create () {

		batch = new SpriteBatch();
		// = new Texture("bird.png");
		bg  = new Texture("bg.png");

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(bg, 0, 0, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
		batch.draw(bird, Gdx.graphics.getWidth() / 2 - bird.getWidth() / 2, Gdx.graphics.getHeight() / 2 - bird.getHeight() / 2);
		batch.end();
	}
}
