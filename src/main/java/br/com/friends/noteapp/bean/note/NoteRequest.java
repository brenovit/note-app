package br.com.friends.noteapp.bean.note;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.Getter;

@Data
public class NoteRequest {
	private String title;
	private String body;
	private Long userId;
	private Integer type;
	private String color;
	private String personName;	
	private String gift;
	private String locationParty;
	
	@Getter
	private String time;
	private List<TaskRequest> tasks	= new ArrayList<TaskRequest>();
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
	
	public Date getAlertTime() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return sdf.parse(time);
	}
}
