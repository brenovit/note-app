package br.com.friends.noteapp.bean.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.friends.noteapp.job.model.IJob;

public class JobList {
	private static List<IJob> list = new ArrayList<IJob>();
	
	public static List<IJob> getList(){		
		 return list;
	}

	public static void add(IJob job) {
		list.add(job);
	}
}
