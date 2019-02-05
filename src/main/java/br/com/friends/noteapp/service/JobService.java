package br.com.friends.noteapp.service;

import org.springframework.stereotype.Service;

import br.com.friends.noteapp.bean.dto.JobList;
import br.com.friends.noteapp.bean.response.JobResponse;

@Service
public class JobService {

	public JobResponse getJobs() {
		JobResponse response = new JobResponse();
		response.setJobs(JobList.getList());
		return response;
	}

}
