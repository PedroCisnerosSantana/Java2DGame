package dev.wannadie.tilegame;

public class Game implements Runnable {

  private Display display;

  public int width;
  public int height;

  private Thread thread;

  public Game(String title, int width, int height) {
	this.width = width;
	this.height = height;
	display = new Display(title, width, height);
  }

  public void run() {

  }

  public synchronized void start() {
	thread = new Thread();
	thread.start();
  }

  public synchronized void stop() {

  }

}
