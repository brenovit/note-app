package br.com.friends.noteapp.job.notification;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Component;

import br.com.friends.noteapp.job.model.IJobNew;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class Job1 implements IJobNew {	
	
	@Getter
	private boolean isAlive;
	@Getter
	private String nextExecution;
	
	@Autowired
	private TaskScheduler taskScheduler;

	@Getter
	private ScheduledFuture<?> scheduledFuture;
	
	private static final CronTrigger trigger = new CronTrigger("*/5 * * * * *");	
	
	@Override
	public void run() {
		log.info(getName());
		nextExecution = getNextExecutionTime().toString();
	}	
	
	@Override
	public void start() {
		isAlive = true;
		log.info("Start: "+getName()+" | "+new Date().toString());	
		scheduledFuture = taskScheduler.schedule(this, trigger);
	}
	
	private Date getNextExecutionTime() {
		SimpleTriggerContext triggerContext = new SimpleTriggerContext();
		triggerContext.update(null, null, new Date());
		return trigger.nextExecutionTime(triggerContext);
	}
	
	@Override
	public void stop() {
		log.info("Stop: "+getName()+" | "+new Date().toString());
		isAlive = false;
		scheduledFuture.cancel(true);		
		nextExecution = "";		
	}	
}
