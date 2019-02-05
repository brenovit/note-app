package br.com.friends.noteapp.job.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.friends.noteapp.job.model.IJob;
import br.com.friends.noteapp.service.SendNotificationService;

@Component
public class SendNotificationJob implements IJob{
	
	@Value("${job.send.notification.active}")
	private boolean isActive;
	
	@Autowired
	private SendNotificationService sendNotificationService;
	
	@Override
	public void run() {
		if(isActive) {
			execute();
		}
	}
	
	private void execute(){
		sendNotificationService.execute();
	}

	@Override
	public boolean getStatus() {
		return isActive;
	}	
	
}
