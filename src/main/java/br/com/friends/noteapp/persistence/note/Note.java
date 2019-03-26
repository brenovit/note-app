package br.com.friends.noteapp.persistence.note;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.friends.noteapp.bean.dto.NoteType;
import br.com.friends.noteapp.persistence.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Table(name="T_NOTE")
@NoArgsConstructor
public class Note {
	
	@Id
	@GeneratedValue	
	@Column(name="IDNOTE")
	private long id;
	
	@NotNull
	@NotBlank
	private String title;
	
	@NotNull
	@NotBlank
	private String body;

	@NotNull
	@NotBlank
	private String color;
	
	@Temporal(TemporalType.DATE)
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=true, updatable=true)
	private Date lastModificatedDate;
	
	@ManyToOne
	@NotNull(message="User required")
	@JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER")
	private User user;
	
	@Enumerated(EnumType.ORDINAL)
	@NotNull
	private NoteType type;
	
	private String personName;	
	private String gift;
	private String partyLocation;
	
	private Date alertTime;
	
	@NotNull		
	private boolean sended;
	
	public Note(String title, String body, String color) {
		this.title = title;
		this.body = body;
		this.color =  color;
	}
	
}
