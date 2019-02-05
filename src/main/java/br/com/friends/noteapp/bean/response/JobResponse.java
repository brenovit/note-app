package br.com.friends.noteapp.bean.response;

import java.util.List;

import br.com.friends.noteapp.job.model.IJob;
import lombok.Data;

@Data
public class JobResponse {
	private List<IJob> jobs;
}
