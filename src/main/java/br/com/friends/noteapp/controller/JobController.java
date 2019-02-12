package br.com.friends.noteapp.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.friends.noteapp.bean.job.JobResponse;
import br.com.friends.noteapp.job.JobSchedule;
import br.com.friends.noteapp.service.JobService;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

	@Autowired
	private JobService jobService;	
	
	@GetMapping(path = "/")
	public ResponseEntity<?> listJob() {
		JobResponse response = jobService.getJobs();
		return new ResponseEntity<JobResponse>(response, HttpStatus.OK);
	}

	private static final String SCHEDULED_TASKS = "scheduledTasks";

	@Autowired
	private ScheduledAnnotationBeanPostProcessor postProcessor;

	@Autowired
	private JobSchedule jobSchedule;

	@GetMapping(value = "/stop")
	public String stopSchedule() {
		jobSchedule.cancel();
		return "OK";
	}

	@GetMapping(value = "/start")
	public String startSchedule() {
		jobSchedule.sendNotification();
		return "OK";
	}

	@GetMapping(value = "/list")
	public ResponseEntity<?> listSchedules() throws JsonProcessingException {
		Set<ScheduledTask> setTasks = postProcessor.getScheduledTasks();
		if (!setTasks.isEmpty()) {
			return new ResponseEntity<Set<ScheduledTask>>(setTasks, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No running tasks !", HttpStatus.OK);
		}
	}
}
