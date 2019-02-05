package br.com.friends.noteapp.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import br.com.friends.noteapp.bean.dto.JobList;
import br.com.friends.noteapp.job.notification.SendNotificationJob;

public class JobSchedule {

	@Value("${job.active}")
	private boolean isJobActive;

	@Autowired
	private SendNotificationJob sendNotificationJob;

	@Scheduled(cron = "${cron.job.send.notification}")
	public void sendNotification() {
		JobList.add(sendNotificationJob);
		if (isJobActive) {
			sendNotificationJob.run();
		}
	}
}
