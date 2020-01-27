package dev.wannadie.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

  private Display display;

  private boolean running = false;

  public String title;
  public int width;
  public int height;
  
  private BufferStrategy bs;
  private Graphics g;

  private Thread thread;

  public Game(String title, int width, int height) {
	this.title = title;
	this.width = width;
	this.height = height;
  }

  private void init() {
	display = new Display(title, width, height);
  }

  private void update() {

  }

  private void render() {
	bs = display.getCanvas().getBufferStrategy();
	if (bs == null) {
	  display.getCanvas().createBufferStrategy(3);
	  return;
	}
	
	g = bs.getDrawGraphics();
	
	g.clearRect(0, 0, width, height);
	
	bs.show();
	g.dispose();
  }

  public void run() {
	init();

	while(running) {
	  update();
	  render();
	}
	
	stop();
  }

  public synchronized void start() {
	if (running) {
	  return;
	} else {
	  running = true;
	  thread = new Thread(this);
	  thread.start(); 
	}
  }

  public synchronized void stop() {
	if (!running) {
	  return;
	} else {
	  running = false;
	  try {
		thread.join();
	  } catch (InterruptedException e) {
		e.printStackTrace();
	  }
	}

  }

}
