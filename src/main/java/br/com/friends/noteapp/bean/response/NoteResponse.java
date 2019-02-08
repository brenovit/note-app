package br.com.friends.noteapp.bean.response;

import java.util.Date;
import java.util.UUID;

import br.com.friends.noteapp.bean.dto.NoteType;
import lombok.Data;

@Data
public class NoteResponse {
	private long id;
	private String title;
	private String body;
	private String color;
	private Date lastModificatedDate;
	private UUID userId;
	private NoteType type;
	private String personName;
	private String gift;
	private String locationParty;
}
