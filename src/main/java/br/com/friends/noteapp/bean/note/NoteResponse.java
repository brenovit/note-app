package br.com.friends.noteapp.bean.note;

import java.util.Date;

import br.com.friends.noteapp.bean.dto.NoteType;
import lombok.Data;

@Data
public class NoteResponse {
	private Long id;
	private String title;
	private String body;
	private String color;
	private Date lastModificatedDate;
	private long userId;
	private NoteType type;
	private String personName;
	private String gift;
	private String locationParty;
}
