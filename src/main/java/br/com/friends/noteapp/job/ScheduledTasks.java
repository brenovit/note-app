package br.com.friends.noteapp.job;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.friends.noteapp.job.model.IJobNew;
import br.com.friends.noteapp.job.notification.Job1;
import br.com.friends.noteapp.job.notification.Job2;
import br.com.friends.noteapp.job.notification.Job3;
import lombok.Getter;

@Component
public class ScheduledTasks {
	
	@Getter	
	private static final Map<Object, IJobNew> scheduledTasks = new HashMap<Object, IJobNew>();
	
	@Autowired
	private Job1 job1;

	@Autowired
	private Job2 job2;
	
	@Autowired
	private Job3 job3;
	
	@PostConstruct
	private void initiate() {
		scheduledTasks.put(job1.getName(), job1);
		scheduledTasks.put(job2.getName(), job2);
		scheduledTasks.put(job3.getName(), job3);
	}
	
	public void start(String jobName) {
		scheduledTasks.get(jobName).start();
	}

	public void stop(String jobName) {
		scheduledTasks.get(jobName).stop();
	}

}
