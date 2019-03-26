package br.com.friends.noteapp.bean.note;

import java.util.Date;

import lombok.Data;

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
	
}
