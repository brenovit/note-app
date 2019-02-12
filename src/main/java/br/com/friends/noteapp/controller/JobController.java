package br.com.friends.noteapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.friends.noteapp.job.ScheduledTasks;
import br.com.friends.noteapp.job.model.IJobNew;

@RestController
@RequestMapping("/jobs")
public class JobController {

	@Autowired
	private ScheduledTasks jobSchedule;

	@GetMapping(value = "/stop/{jobName}")
	public String stop(@PathVariable String jobName) {
		jobSchedule.stop(jobName);
		return "OK";
	}

	@GetMapping(value = "/start/{jobName}")
	public String start(@PathVariable String jobName) {
		jobSchedule.start(jobName);
		return "OK";
	}
	
	@GetMapping(value = "/list")
	public ResponseEntity<?> list() {
		Map<Object, IJobNew> scheduledTasks = ScheduledTasks.getScheduledTasks();
		return new ResponseEntity<Map<Object, IJobNew>>(scheduledTasks, HttpStatus.OK);
	}

}
