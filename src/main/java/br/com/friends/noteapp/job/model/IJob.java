package br.com.friends.noteapp.job.model;

public interface IJob extends Runnable {
	default String getName() {
		return this.getClass().getSimpleName();
	}
	
	boolean isRunning();
	IJob start();
	IJob stop();	
	String getNextExecution();
}
