package br.com.friends.noteapp.job.notification;

import org.springframework.stereotype.Component;

import br.com.friends.noteapp.job.model.IJob;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class Job2 implements IJob{	
	
	private boolean status;
	
	@Override
	public void run() {
		log.info(getName());
	}
	
	@Override
	public boolean getStatus() {
		return status;
	}	
	
	public void start() {
		status = true;
	}
	
	public void stop() {
		status =false;
	}	
	
}
