package br.com.friends.noteapp.bean.note;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.friends.noteapp.bean.note.NoteRequest.ItemRequest;
import br.com.friends.noteapp.bean.note.NoteRequest.TaskRequest;
import lombok.Data;
import lombok.Getter;

@Data
public class NoteResponse {
	private Long id;
	private String title;
	private String body;
	private String color;
	private Date lastModificatedDate;
	private Long userId;
	private Integer type;
	private String personName;
	private String gift;
	private String partyLocation;
	private String sended;
	private String alertTime;
	private String recipeName;
	private String taskName;
	
	@Getter
	private String time;
	private List<TaskRequest> tasks	= new ArrayList<TaskRequest>();
	private List<ItemRequest> itens = new ArrayList<ItemRequest>();
	
}
