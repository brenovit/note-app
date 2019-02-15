package br.com.friends.noteapp.job;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.friends.noteapp.job.model.IJob;
import br.com.friends.noteapp.job.notification.SendNotificationJob;
import lombok.Getter;

@Component
public class ScheduledTasks {
	
	@Getter	
	private static final Map<Object, IJob> scheduledTasks = new HashMap<Object, IJob>();
	
	@Autowired
	private SendNotificationJob job1;
	
	
	@PostConstruct
	private void initiate() {
		scheduledTasks.put(job1.getName(), job1);
	}
	
	public IJob start(String jobName) {
		return scheduledTasks.get(jobName).start();
	}

	public IJob stop(String jobName) {
		return scheduledTasks.get(jobName).stop();
	}

}
