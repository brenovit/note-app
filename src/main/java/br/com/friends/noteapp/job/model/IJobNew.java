package br.com.friends.noteapp.job.model;

public interface IJobNew extends Runnable {
	default String getName() {
		return this.getClass().getSimpleName();
	}
	
	boolean isAlive();
	void start();
	void stop();	
	String getNextExecution();
}
