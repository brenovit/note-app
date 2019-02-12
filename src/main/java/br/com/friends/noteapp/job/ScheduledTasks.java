package br.com.friends.noteapp.job;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import br.com.friends.noteapp.job.notification.SendNotificationJob;

@Component
public class ScheduledTasks {
	
	@Autowired
	private SendNotificationJob sendNotificationJob;
	
	
	@Autowired
	private TaskScheduler taskScheduler;
	
	@Autowired
	private ScheduledFuture<?> scheduledFuture;
	
	public void start(String jobName) {		
		
			CronTrigger cron = new CronTrigger("");
			DateTime date = new DateTime(2019, 2, 11, 21, 16);
			PeriodicTrigger periodicTrigger = new PeriodicTrigger(2000, TimeUnit.MILLISECONDS);
			scheduledFuture = taskScheduler.schedule(sendNotificationJob,periodicTrigger);			
		
	}

	public void stop(String jobName) {
		// TODO Auto-generated method stub
		
	}
	
}
