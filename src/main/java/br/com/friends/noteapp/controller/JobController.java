package br.com.friends.noteapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.friends.noteapp.bean.response.JobResponse;
import br.com.friends.noteapp.service.JobService;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	@GetMapping(path="/")
	public ResponseEntity<?> listJob(){
		JobResponse response = jobService.getJobs();
		return new ResponseEntity<JobResponse>(response, HttpStatus.OK);
	}
}
