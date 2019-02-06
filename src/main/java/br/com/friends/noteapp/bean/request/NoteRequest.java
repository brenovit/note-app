package br.com.friends.noteapp.bean.request;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class NoteRequest {
	private String title;
	private String body;	
	private String userId;
	private String type;
	private String personName;	
	private String gift;
	private String locationParty;
	private List<TaskRequest> tasks = new ArrayList<TaskRequest>();
	private List<ItemRequest> itens = new ArrayList<ItemRequest>();
	
	@Data
	class TaskRequest {
		private String description;
		private String date;
		private boolean done;
	}
	
	@Data
	class ItemRequest {
		private String description;
		private Float quantity;
		private String unit;
	}
}
