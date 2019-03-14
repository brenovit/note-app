package br.com.friends.noteapp.bean.dto;

import java.util.HashSet;
import java.util.Set;

import br.com.friends.noteapp.job.model.IJob;

public class JobList {
	private static Set<IJob> list = new HashSet<IJob>();
	
	public static Set<IJob> getList(){		
		 return list;
	}

	public static void add(IJob job) {
		list.add(job);
	}
}
