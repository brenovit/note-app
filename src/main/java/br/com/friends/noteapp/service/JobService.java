package br.com.friends.noteapp.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import br.com.friends.noteapp.bean.dto.JobList;
import br.com.friends.noteapp.bean.response.JobResponse;
import br.com.friends.noteapp.job.model.IJob;

@Service
public class JobService {

	public JobResponse getJobs() {
		JobResponse response = new JobResponse();
		response.setJobs(new ArrayList<IJob>(JobList.getList()));
		return response;
	}

}
