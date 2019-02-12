package br.com.friends.noteapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.friends.noteapp.job.ScheduledTasks;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

	@Autowired
	private ScheduledTasks jobSchedule;

	@GetMapping(value = "/stop")
	public String stop() {
		jobSchedule.stop("job1");
		return "OK";
	}

	@GetMapping(value = "/start")
	public String start() {
		jobSchedule.start("job1");
		return "OK";
	}

}
