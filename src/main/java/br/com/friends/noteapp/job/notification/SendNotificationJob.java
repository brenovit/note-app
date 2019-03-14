package br.com.friends.noteapp.job.notification;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Component;

import br.com.friends.noteapp.job.model.IJob;
import br.com.friends.noteapp.service.SendNotificationService;
import lombok.Getter;

@Component
public class SendNotificationJob implements IJob{
	
	@Getter
	@Value("${job.send.notification.active}")
	private boolean isActive;
	
	@Value("${cron.job.send.notification}")
	private String cron;
	@Autowired
	private SendNotificationService sendNotificationService;

	@Getter
	private boolean isRunning;
	@Getter
	private String nextExecution;
	
	@Autowired
	private TaskScheduler taskScheduler;

	@Getter
	private ScheduledFuture<?> scheduledFuture;
	
	private CronTrigger trigger;
		
	@Override
	public void run() {
		if(isActive) {
			execute();
		}
	}
	
	private void execute(){
		sendNotificationService.execute();
	}
	
	public IJob start() {
		isRunning = true;
		trigger = new CronTrigger(cron);
		scheduledFuture = taskScheduler.schedule(this,trigger);
		nextExecution = getNextExecutionTime();
		return this;
	}
	
	private String getNextExecutionTime() {
		SimpleTriggerContext triggerContext = new SimpleTriggerContext();
		triggerContext.update(null, null, new Date());
		return new DateTime(trigger.nextExecutionTime(triggerContext)).toString("dd/MM/yyyy HH:mm:ss");		
	}
	
	@Override
	public IJob stop() {
		isRunning = false;
		scheduledFuture.cancel(true);		
		nextExecution = "";
		return this;
	}	
}
